package com.ljm.meiziview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/5/12 0012.
 */
public class MeziView extends View{

    private float startX = 0;
    private float startY = 200;

    public float currentX;
    public float currentY;

    public MeziView(Context context) {
        super(context);

        currentX = startX;
        currentY = startY;
    }

    public MeziView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeziView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1
        Paint paint = new Paint();
        //2
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        //3 开始绘制
        canvas.drawBitmap(bitmap,currentX,currentY,paint);

        if(bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
