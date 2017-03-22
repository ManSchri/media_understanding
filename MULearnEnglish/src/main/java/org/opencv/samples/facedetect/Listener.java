package org.opencv.samples.facedetect;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;


public class Listener extends Activity {

    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    String ObjectWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);

        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

        final ImageView image = (ImageView) findViewById(R.id.objectImage);

        //int word = new Random().nextInt(3);
        int word = 1;
        switch (word){
            case 0: ObjectWord = "scissors";
                image.setImageResource(R.drawable.scissors);
                break;
            case 1: ObjectWord = "door";
                image.setImageResource(R.drawable.door);
                break;
            case 2: ObjectWord = "pen";
                image.setImageResource(R.drawable.pen);
                break;
        }


        // hide the action bar
        //getActionBar().hide();

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        Button skip = (Button) findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent;
                int game = new Random().nextInt(2);
                switch (game){
                    case 0: intent = new Intent(Listener.this, PhotoInstruction.class);
                        break;
                    case 1: intent = new Intent(Listener.this, Listener.class);
                        break;
                    default: throw new RuntimeException("Error");
                }
                startActivity(intent);
            }
        });

    }

    /**
     * Showing google speech input dialog
     * */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     * */

    int wrongcounter = 3;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    if(result.get(0).equals(ObjectWord)){
                       Intent intent = new Intent(this, RightImage.class);
                        startActivity(intent);
                    }
                    else{
                        txtSpeechInput.setText(result.get(0));
                        wrongcounter = wrongcounter - 1;
                        if(wrongcounter==0){
                            Intent intent = new Intent(this, Wrong.class);
                            startActivity(intent);
                        }

                    }
                }
                break;
            }

        }
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.Listener, menu);
//        return true;
//    }

}