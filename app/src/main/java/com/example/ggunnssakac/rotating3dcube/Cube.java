package com.example.ggunnssakac.rotating3dcube;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Cube extends Activity
{
    private GLSurfaceView ourSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ourSurface = new MyGLSurfaceView(this);
        setContentView(ourSurface);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        ourSurface.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }
}
