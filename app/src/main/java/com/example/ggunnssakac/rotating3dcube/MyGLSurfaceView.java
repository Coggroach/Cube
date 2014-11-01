package com.example.ggunnssakac.rotating3dcube;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
/**
 * Created by ggunn on 29/10/14.
 */
public class MyGLSurfaceView extends GLSurfaceView
{
    public MyGLSurfaceView(Context context)
    {
        super(context);
        mRenderer = new GLCubeRendererEX();
        setRenderer(mRenderer);
    }

    float X = 0;
    float Y = 0;
    GLCubeRendererEX mRenderer;

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        X = e.getX();
        Y = e.getY();

       switch (e.getAction())
       {
           case MotionEvent.ACTION_MOVE:
                   mRenderer.setPointX((int)X);
                   mRenderer.setPointY((int)Y);
                   requestRender();
        }
        return true;
    }


}
