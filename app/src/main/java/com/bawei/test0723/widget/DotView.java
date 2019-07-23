package com.bawei.test0723.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.bawei.test0723.R;

public class DotView extends View {

    private Paint paint;
    private float x,y;
    public DotView(Context context) {
        super(context,null);
    }

    public DotView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
        initView(context,attrs);

    }

    public DotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }
    private void initView(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setDither(true);
        paint.setColor(ContextCompat.getColor(context, R.color.colorAccent));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x+100,y+100,100,paint);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX() - 100;
                y = event.getY() - 100;
                break;
            case MotionEvent.ACTION_MOVE:

                x = event.getX() - 100;
                y = event.getY() - 100;
                break;
            case MotionEvent.ACTION_UP:

                x=0;
                y=0;
                break;
        }
        postInvalidate();
        return true;
    }
}
