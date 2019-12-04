package com.example.admin.vr_system;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import com.google.vr.sdk.widgets.video.VrVideoView;

public class MainActivity extends AppCompatActivity {

    VrVideoView mVideoView;
    private CameraSurfaceView surfaceView;
    private RelativeLayout surfaceviewlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        surfaceView=new CameraSurfaceView(MainActivity.this);


//        vr
        mVideoView = (VrVideoView) findViewById(R.id.video);
        try{
            mVideoView.addView(surfaceView);
        }catch (Exception e){
            Log.v("1",e.toString());
        }
    }
    void requestPermission(){
        final int REQUEST_CODE = 1;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE);
    }
}
