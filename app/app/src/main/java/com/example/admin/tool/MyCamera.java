package com.example.admin.tool;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



public class MyCamera {
    Camera camera;
    CameraCaptureSession cameraCaptureSession;
    CameraManager cameraManager;
    MyCamera(){//配置参数

    }

    public Camera OpenCamera(){//打开相机
        try {
            camera = Camera.open();
        }catch (Exception e){
            Log.v("Camera.open",e.toString());
        }
        return camera;
    }

    private void CreateCameraSession(){//连接相机

    }
}
