package pong.com.br.pong.model.sg;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by Leonardo on 13/02/2018.
 */

public class SGImage {

    private Bitmap mBitmap = null;
    private Point mDimesions = new Point();

    public SGImage(Bitmap bitmap) {
        mBitmap = bitmap;
        mDimesions.set(mBitmap.getWidth(), mBitmap.getHeight());
    }

    public Bitmap getBitmap() { return mBitmap; }
    public Point getDimesions() { return mDimesions;}

}
