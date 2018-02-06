package pong.com.br.pong;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SGActivity extends Activity {

    public static final String TAG = "SimpleGameEngine";

    public enum SGOrientation { LANDSCAPE, PORTRAIT }

    @SuppressLint("NewApi")
    public void enableFullScreen() {

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.requestFeature(Window.FEATURE_NO_TITLE);

        if(Build.VERSION.SDK_INT >= 19) {
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }

    public void setOrietation(SGOrientation orietation) {

        switch (orietation){
            case LANDSCAPE:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case PORTRAIT:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }
    }

    public void enableKeepScreanOn() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy() called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause() called.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart() called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume() called.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart() called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, " onStop() called.");
    }
}
