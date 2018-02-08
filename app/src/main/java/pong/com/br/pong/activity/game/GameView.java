package pong.com.br.pong.activity.game;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;


/**
 * Created by Leonardo on 08/02/2018.
 */

public class GameView extends View {

    public GameView(Context context){
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRGB(0,0,255);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(10, 10, 60, 60, paint);
    }
}
