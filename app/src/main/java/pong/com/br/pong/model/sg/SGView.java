package pong.com.br.pong.model.sg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

/**
 * Created by Leonardo on 09/02/2018.
 */

public class SGView extends View {

    private SGRenderer mRenderer;
    private SGStepwach mStepwach = new SGStepwach();
    private SGImageFactory mImageFactory;
    private Point mDimension = new Point();
    private boolean mHasStarted;

    public SGView(Context context){
        super(context);
        mImageFactory = new SGImageFactory(context);
        mRenderer = new SGRenderer();
    }

    @Override
    public void onDraw(Canvas canvas){

        step(canvas, mStepwach.tick());

        invalidate();
    }

    public void step(Canvas canvas, float elapsedTimeInSeconds){}

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {

        mDimension.set(width, height);

        if(!mHasStarted){
            setup();
            mHasStarted = true;
        }
    }

    protected void setup() {}

    public Point getDimensions() {
        return mDimension;
    }

    public SGImageFactory getImageFactory() {
        return mImageFactory;
    }

    public SGRenderer getRenderer() {
        return mRenderer;
    }
}
