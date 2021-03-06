package pong.com.br.pong.model.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

import pong.com.br.pong.R;
import pong.com.br.pong.model.sg.SGImage;
import pong.com.br.pong.model.sg.SGImageFactory;
import pong.com.br.pong.model.sg.SGRenderer;
import pong.com.br.pong.model.sg.SGView;


/**
 * Created by Leonardo on 08/02/2018.
 */

public class GameView extends SGView{

    private final static int BALL_SIZE = 16;
    private final static  int BALL_SPEED = 120;
    private final static int DISTANCE_FROM_EDGE = 16;
    private final static int PADDLE_HEIGHT = 92;
    private final static int PADDLE_WIDTH = 23;
    private final static int OPPONENT_SPEED = 120;

    private SGImage mBallImage;
    private SGImage mOpponentImage;
    private SGImage mPlayerImage;

    private Rect mTempImageSource = new Rect();

    private RectF mBallDestination = new RectF();
    private RectF mOpponentDestination = new RectF();
    private RectF mPlayerDestination = new RectF();

    private boolean mBallMoveRight = true;
    private boolean mOpponentMoveDown = true;

    private Paint mTempPaint = new Paint();
    public GameView(Context context){
        super(context);
    }

    @Override
    public void step(Canvas canvas, float elapsedTimeInSeconds) {
        moveBall(elapsedTimeInSeconds);
        moveOppnoent(elapsedTimeInSeconds);

        SGRenderer renderer = getRenderer();

        renderer.beginDrawing(canvas, Color.BLACK);

        mTempImageSource.set(0, 0, BALL_SIZE, BALL_SIZE);
        renderer.drawImage(mBallImage, mTempImageSource, mBallDestination);

        mTempImageSource.set(0, 0, PADDLE_WIDTH, PADDLE_HEIGHT);
        renderer.drawImage(mPlayerImage, mTempImageSource, mPlayerDestination);

        mTempImageSource.set(0, 0, PADDLE_WIDTH, PADDLE_HEIGHT);
        renderer.drawImage(mOpponentImage, mTempImageSource, mOpponentDestination);

        renderer.endDrawing();
    }

    @Override
    public void setup (){

        SGImageFactory imageFactory = getImageFactory();

        mBallImage = imageFactory.createImage(R.drawable.ball);
        mPlayerImage = imageFactory.createImage("player.png");
        mOpponentImage = imageFactory.createImage("opponent.png");

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

    private void moveBall(float elapsedTimeInSeconds) {
        Point viewDimesions = getDimensions();

        if(mBallMoveRight) {

            mBallDestination.left += BALL_SPEED * elapsedTimeInSeconds;
            mBallDestination.right += BALL_SPEED * elapsedTimeInSeconds;

            if(mBallDestination.right >= viewDimesions.x) {
                mBallDestination.left = viewDimesions.x - BALL_SIZE;
                mBallDestination.right = viewDimesions.x;
                mBallMoveRight = false;
            }
        }else{

            mBallDestination.left -= BALL_SPEED * elapsedTimeInSeconds;
            mBallDestination.right -= BALL_SPEED * elapsedTimeInSeconds;

            if(mBallDestination.left < 0) {
                mBallDestination.left = 0;
                mBallDestination.right = BALL_SIZE;
                mBallMoveRight = true;
            }

        }
    }

    private void moveOppnoent(float elapsedTimeInSeconds) {
        Point viewDimensions = getDimensions();

        if(mOpponentMoveDown) {

            mOpponentDestination.top += OPPONENT_SPEED * elapsedTimeInSeconds;
            mOpponentDestination.bottom += OPPONENT_SPEED * elapsedTimeInSeconds;

            if(mOpponentDestination.bottom >= viewDimensions.y){
                mOpponentDestination.top = viewDimensions.y - PADDLE_HEIGHT;
                mOpponentDestination.bottom = viewDimensions.y;

                mOpponentMoveDown = false;
            }
        }else{

            mOpponentDestination.top -= OPPONENT_SPEED * elapsedTimeInSeconds;
            mOpponentDestination.bottom -= OPPONENT_SPEED * elapsedTimeInSeconds;

            if(mOpponentDestination.top < 0){

                mOpponentDestination.top = 0;
                mOpponentDestination.bottom = PADDLE_HEIGHT;
                mOpponentMoveDown = true;
            }
        }
    }
}
