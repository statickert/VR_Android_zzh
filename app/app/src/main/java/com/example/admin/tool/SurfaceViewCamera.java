package com.example.admin.tool;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class SurfaceViewCamera extends SurfaceView implements SurfaceHolder.Callback  {
    private SurfaceHolder holder;
    public static Camera mCamera;
    public SurfaceViewCamera(Context context) {
        super(context);
        holder=getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try{
            mCamera.setPreviewDisplay(surfaceHolder);
            mCamera.startPreview();
        }catch (Exception e){
            Log.v("surfaceCreated",e.toString());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        if(holder.getSurface()==null)
            return;
        try{
            mCamera.stopPreview();
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        }catch (Exception e){
            Log.v("surfaceChanged",e.toString());
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
//https://www.android-doc.com/guide/topics/media/camera.html
