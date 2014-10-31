package com.example.ggunnssakac.rotating3dcube;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.os.SystemClock;
import android.util.Log;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by ggunn on 29/10/14.
 */
public class GLCubeRendererEX implements GLSurfaceView.Renderer {

    private GLCube cube;
    private int X, Y = 0;
    private float R, G, B, A;
    private int width, height;

    public GLCubeRendererEX() {
        cube = new GLCube();
        this.R = 0.8F;
        this.G = 0.0F;
        this.B = 0.2F;
        this.A = 1F;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        gl.glClearColor(R, G, B, A);
        gl.glClearDepthf(1f);
    }

    public void onDrawFrame(GL10 gl) {
        gl.glDisable(GL10.GL_DITHER);//?
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        GLU.gluLookAt(gl, 0, 0, -5, 0, 0, 0, 0, 2, 0);

        long time = SystemClock.uptimeMillis() % 4000L;
        float angle = 0.090f * ((int) time);

        gl.glRotatef(angle, 1, 1, 1);
        gl.glTranslatef(0.5f-(float)X/width, 0.5f-(float)Y/height, 1);


        cube.draw(gl);

    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        this.width = width;
        this.height = height;
        gl.glViewport(0, 0, width, height);
        float ratio = (float) width / height;
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 25);

    }

    public void setpointX(int i) {
        this.X = i;
    }

    public void setpointY(int i) {
        this.Y = i;
    }

    public void setR(float f) {
        this.R = f;
    }

    public void setG(float f) {
        this.G = f;
    }

    public void setB(float f) {
        this.B = f;
    }

}
