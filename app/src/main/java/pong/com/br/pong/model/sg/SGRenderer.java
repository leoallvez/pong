package pong.com.br.pong.model.sg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Leonardo on 15/02/2018.
 */

public class SGRenderer {
    private Canvas mTempCanvas;
    private Paint mTempPaint = new Paint();
    private RectF mTempDstRect = new RectF();

    public SGRenderer() {}

    public void beginDrawing(Canvas canvas, int backgroundColor) {

        mTempCanvas = canvas;
        canvas.drawColor(backgroundColor);
    }

    public void endDrawing() {}


}
