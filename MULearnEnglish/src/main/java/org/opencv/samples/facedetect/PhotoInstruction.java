package org.opencv.samples.facedetect;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.content.Intent;



public class PhotoInstruction extends Activity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = new Intent(this, FdActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_instruction);
        final TextView ObjectName = (TextView) findViewById(R.id.ObjectName);
        int ObjectInt = new Random().nextInt(2);

        switch (ObjectInt){
            case 0: ObjectName.setText("Scissors");
                intent.putExtra("casc", 0);
                break;
            case 1: ObjectName.setText("Door");
                intent.putExtra("casc", 1);
                break;
        }
    }

    public void takePicture (View view){
        startActivity(intent);
    }
}
