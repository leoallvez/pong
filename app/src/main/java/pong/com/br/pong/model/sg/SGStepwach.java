package pong.com.br.pong.model.sg;

import android.os.SystemClock;

/**
 * Created by Leonardo on 12/02/2018.
 */

public class SGStepwach {
    protected long mCurrentTime;
    protected long mLastTime;
    protected float mElapsedTime;

    protected float tick() {
        if(mCurrentTime == 0) {
            mLastTime = mCurrentTime = SystemClock.uptimeMillis();
        }else{
            mCurrentTime = SystemClock.uptimeMillis();
        }
        mElapsedTime = (mCurrentTime - mLastTime) / 1000.0f;
        mLastTime = mCurrentTime;

        return mElapsedTime;
    }

}
