package pong.com.br.pong.model.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import pong.com.br.pong.model.sg.SGView;


/**
 * Created by Leonardo on 08/02/2018.
 */

public class GameView extends SGView{

    private final static int BALL_SIZE = 16;
    private final static int DISTANCE_FROM_EDGE = 16;
    private final static int PADDLE_HEIGHT = 92;
    private final static int PADDLE_WIDTH = 23;

    private Rect mBallDestination = new Rect();
    private Rect mOpponentDestination = new Rect();
    private Rect mPlayerDestination = new Rect();

    private Paint mTempPaint = new Paint();
    public GameView(Context context){
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRGB(0,0,255);
        mTempPaint.setColor(Color.RED);
        canvas.drawRect(10, 10, 60, 60, mTempPaint);
    }

    @Override
    public void setup (){
        //Point  viewDimensions = getDimensions();
    }

}
