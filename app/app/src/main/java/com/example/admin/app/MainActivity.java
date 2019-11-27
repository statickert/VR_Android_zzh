package com.example.admin.app;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.example.admin.tool.MyCamera;
import com.example.admin.tool.SurfaceViewCamera;
import com.google.vr.sdk.widgets.video.VrVideoView;



public class MainActivity extends Activity {
    VrVideoView mVideoView;
    SurfaceViewCamera surfaceViewCamera;
    MyCamera myCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)){//否则去请求相机权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},100);
        }
        SurfaceViewCamera.mCamera =myCamera.OpenCamera();
        mVideoView = (VrVideoView) findViewById(R.id.video);
        VrVideoView.Options options = new VrVideoView.Options();
        try{
            mVideoView.addView(surfaceViewCamera);
        }catch (Exception e){
            Log.v("1",e.toString());
        }
    }
}
