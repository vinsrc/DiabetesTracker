package com.project.uwm.mydiabitiestracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Anitha on 7/23/2017.
 */

public class NoteActivity extends AppCompatActivity{
    public static final String NA = "NoteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_main);
    }
    protected void onStart() {
        super.onStart();
        Log.w(NA, "inside NoteActivity:onStart()\n");
    }
    protected void onRestart() {
        super.onRestart();
        Log.v(NA, "inside NoteActivity:onRestart()\n");
    }
    protected void onResume() {
        super.onResume();
        Log.v(NA, "inside NoteActivity:onResume()\n");
    }
    protected void onPause() {
        super.onPause();
        Log.v(NA, "inside NoteActivity:onPause()\n");
    }
    protected void onStop() {
        super.onStop();
        Log.v(NA, "inside NoteActivity:onStop()\n");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.v(NA, "inside NoteActivity:onDestroy()\n");
    }
}
