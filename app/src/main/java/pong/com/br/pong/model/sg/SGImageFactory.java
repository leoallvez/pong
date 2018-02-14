package pong.com.br.pong.model.sg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Leonardo on 13/02/2018.
 */

public class SGImageFactory {

    protected Context mContext = null;

    public SGImageFactory(Context context) {
        mContext = context;
    }

    public SGImage createImage(String filename) {

        Bitmap bitmap = null;

        try {
            AssetManager assetManager = mContext.getAssets();
            InputStream inputStream = assetManager.open(filename);
            bitmap = BitmapFactory.decodeStream(inputStream);

            inputStream.close();
        } catch (IOException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SGImageFactory.createImage(): file ");
            stringBuilder.append(filename);
            stringBuilder.append(" not found!");

            Log.d("SimpleGameEngine", stringBuilder.toString());
            return null;
        }
        
        SGImage image = new SGImage(bitmap);

        return image;
    }

    public SGImage createImage(int  resourceId) {

        Bitmap bitmap = null;

        try {
            Resources resources = mContext.getResources();
            InputStream inpuntStream = resources.openRawResource(resourceId);

            bitmap = BitmapFactory.decodeStream(inpuntStream);
            inpuntStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SGImage image = new SGImage(bitmap);

        return image;
    }

    public Context getmContext() { return mContext; }
}
