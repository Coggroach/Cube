package com.example.ggunnssakac.rotating3dcube;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by ggunn on 29/10/14.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private static final float TOUCH_SCALE_FACTOR = 180.0f / 320;

    public MyGLSurfaceView(Context context){
        super(context);
        setEGLContextClientVersion(2);
        mRenderer = new GLCubeRendererEX();
        setRenderer(mRenderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

    }


    float X = 0;
    float Y = 0;
    boolean moving = false;



    GLCubeRendererEX mRenderer;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        X = e.getX();//-mRenderer.getWidth()/2;
        Y = e.getY();


       switch (e.getAction()) {

           case MotionEvent.ACTION_DOWN:

           case MotionEvent.ACTION_MOVE:

                   //-mRenderer.getHeight()*3/2;
                   mRenderer.setpointX((int)X);
                   mRenderer.setpointY((int)Y);
                   requestRender();


        }


        return true;
    }


}
