package org.opencv.samples.facedetect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import org.opencv.core.Mat;
import org.opencv.android.Utils;
import android.app.Activity;


import org.opencv.imgcodecs.Imgcodecs;

import java.util.Random;

public class RightImage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_image);
        // tried displaying the image taken by the user, but didn't work
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent;
                int game = new Random().nextInt(2);
                switch (game){
                    case 0: intent = new Intent(RightImage.this, PhotoInstruction.class);
                        break;
                    case 1: intent = new Intent(RightImage.this, Listener.class);
                        break;
                    default: throw new RuntimeException("Error");
                }
                startActivity(intent);
            }
        });
    }
}
