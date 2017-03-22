package org.opencv.samples.facedetect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;


import java.util.Random;

public class Wrong extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);
    }
    public void next(View view){
        Intent intent;
        int game = new Random().nextInt(2);
        switch (game){
            case 0: intent = new Intent(this, PhotoInstruction.class);
                break;
            case 1: intent = new Intent(this, Listener.class);
                break;
            default:  throw new RuntimeException("Error");
        }
        startActivity(intent);
    }
}
