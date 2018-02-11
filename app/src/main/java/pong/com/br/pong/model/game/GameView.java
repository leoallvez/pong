package pong.com.br.pong.model.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import pong.com.br.pong.model.sg.SGView;


/**
 * Created by Leonardo on 08/02/2018.
 */

public class GameView extends SGView{

    private final static int BALL_SIZE = 16;
    private final static  int BALL_SPEED = 2;
    private final static int DISTANCE_FROM_EDGE = 16;
    private final static int PADDLE_HEIGHT = 92;
    private final static int PADDLE_WIDTH = 23;
    private final static int OPPONENT_SPEED = 2;

    private Rect mBallDestination = new Rect();
    private boolean mBallMoveRight = true;
    private Rect mOpponentDestination = new Rect();
    private boolean mOpponentMoveDown = true;
    private Rect mPlayerDestination = new Rect();

    private Paint mTempPaint = new Paint();
    public GameView(Context context){
        super(context);
    }

    @Override
    public void step(Canvas canvas) {
        moveBall();
        moveOppnoent();
        
        mTempPaint.setColor(Color.RED);

        canvas.drawRect(mPlayerDestination, mTempPaint);
        canvas.drawRect(mBallDestination, mTempPaint);
        canvas.drawRect(mOpponentDestination, mTempPaint);
    }

    @Override
    public void setup (){


        Point viewDimensions = getDimensions();
        Point viewCenter = new Point(viewDimensions.x / 2, viewDimensions.y /2);

        int halfBall = BALL_SIZE / 2;
        int halfPaddleHeight = PADDLE_HEIGHT / 2;

        mBallDestination.set(viewCenter.x - halfBall, //Left
                viewCenter.y - halfBall, //Top
                viewCenter.x + halfBall, // Right
                viewCenter.y + halfBall //Base
        );

        mPlayerDestination.set(DISTANCE_FROM_EDGE, //Left
                viewCenter.y - halfPaddleHeight, //Top
                DISTANCE_FROM_EDGE + PADDLE_WIDTH, //Right
                viewCenter.y + halfPaddleHeight //Base
        );

        mOpponentDestination.set(viewDimensions.x - (DISTANCE_FROM_EDGE + PADDLE_WIDTH), //Left
                viewCenter.y - halfPaddleHeight, //Top
                viewDimensions.x - DISTANCE_FROM_EDGE,// Right
                viewCenter.y + halfPaddleHeight // Base
        );
    }

    private void moveBall() {
        Point viewDimesions = getDimensions();

        if(mBallMoveRight) {
            mBallDestination.left += BALL_SPEED;
            mBallDestination.right += BALL_SPEED;

            if(mBallDestination.right >= viewDimesions.x) {
                mBallDestination.left = viewDimesions.x - BALL_SIZE;
                mBallDestination.right = viewDimesions.x;
                mBallMoveRight = false;
            }
        }else{

            mBallDestination.left -= BALL_SPEED;
            mBallDestination.right -= BALL_SPEED;

            if(mBallDestination.left < 0) {
                mBallDestination.left = 0;
                mBallDestination.right = BALL_SIZE;
                mBallMoveRight = true;
            }

        }
    }

    private void moveOppnoent() {
        Point viewDimensions = getDimensions();

        if(mOpponentMoveDown) {
            mOpponentDestination.top += OPPONENT_SPEED;
            mOpponentDestination.bottom += OPPONENT_SPEED;

            if(mOpponentDestination.bottom >= viewDimensions.y){
                mOpponentDestination.top = viewDimensions.y - PADDLE_HEIGHT;
                mOpponentDestination.bottom = viewDimensions.y;

                mOpponentMoveDown = false;
            }
        }else{

            mOpponentDestination.top -= OPPONENT_SPEED;
            mOpponentDestination.bottom -= OPPONENT_SPEED;

            if(mOpponentDestination.top < 0){

                mOpponentDestination.top = 0;
                mOpponentDestination.bottom = PADDLE_HEIGHT;
                mOpponentMoveDown = true;
            }
        }
    }
}
