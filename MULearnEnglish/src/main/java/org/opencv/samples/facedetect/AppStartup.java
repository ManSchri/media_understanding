package org.opencv.samples.facedetect;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class AppStartup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_startup);

    }
    public void startLearning(View view){
        Intent intent = new Intent(this, FdActivity.class);
        startActivity(intent);
    }

}
