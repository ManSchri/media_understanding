package org.opencv.samples.facedetect;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import java.util.Random;

public class AppStartup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_startup);

    }
    public void startLearning(View view){
        Intent intent;
        int game = new Random().nextInt(2);
        switch (game){
            case 0: intent = new Intent(this, PhotoInstruction.class);
                break;
            case 1: intent = new Intent(this, Listener.class); // change to speechInstruction
                break;
            default: intent = new Intent(this, PhotoInstruction.class);
        }
        startActivity(intent);
    }

}
