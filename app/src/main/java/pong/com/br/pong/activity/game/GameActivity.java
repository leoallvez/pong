package pong.com.br.pong.activity.game;

import android.os.Bundle;
import android.util.Log;

import pong.com.br.pong.activity.sg.SGActivity;
import pong.com.br.pong.model.game.GameView;
import pong.com.br.pong.model.sg.SGPreferences;

public class GameActivity extends SGActivity {

    public static final String TAG = "PongV1";
    private GameView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enableFullScreen();
        enableKeepScreanOn();
        //setContentView(R.layout.activity_game);
        SGPreferences preferences = getmPreferences();
        if(preferences.getInt("first_time", -1) == -1){
            preferences.begin()
                    .putInt("first_time", 1)
                    .putInt("difficulty", 0)
                    .putInt("hight_score", 15)
                    .end();
            Log.d(TAG, "first starts");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Difficulty Level: ");
        stringBuilder.append(preferences.getInt("difficulty", 0));
        Log.d(TAG, stringBuilder.toString());

        mView = new GameView(this);
        setContentView(mView);
    }
}
