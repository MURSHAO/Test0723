package com.bawei.test0723.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.bawei.test0723.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DotRandomView extends View {

    private Paint paint_one;
    private Paint paint_two;
    private Paint paint_three;

    List<Point> list = new ArrayList<>();


    public DotRandomView(Context context) {
        super(context);
    }

    public DotRandomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public DotRandomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        paint_one = new Paint();
        paint_one.setStyle(Paint.Style.FILL);
        paint_one.setAntiAlias(true);
        paint_one.setColor(ContextCompat.getColor(context, R.color.colorAccent));

        paint_two = new Paint();
        paint_two.setStyle(Paint.Style.STROKE);
        paint_two.setStrokeWidth(10);
        paint_two.setAntiAlias(true);
        paint_two.setColor(ContextCompat.getColor(context, R.color.colorPrimary));

        paint_three = new Paint();
        paint_three.setStyle(Paint.Style.FILL);
        paint_three.setAntiAlias(true);
        paint_three.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
    }

    private int x,y;
    private int destX,destY;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Point point : list) {
            if (point.x>x&&point.x<destX&&point.y>y&&point.y<destY){
                canvas.drawCircle(point.x,point.y,20,paint_three);
            }else {
                canvas.drawCircle(point.x,point.y,20,paint_one);
            }
        }
        canvas.drawRect(x,y,destX,destY,paint_two);
    }
    public void addDot(){
        int cx = new Random().nextInt(getScreenWidthOrHeight(true));
        int cy = new Random().nextInt(getScreenWidthOrHeight(false));

        Point point = new Point();
        point.x = cx;
        point.y = cy;
        list.add(point);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = (int) event.getX();
                y = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:

                destX = (int) event.getX();
                destY = (int) event.getY();
                invalidate();

                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        return true;
    }

    public int getScreenWidthOrHeight(boolean width){
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (width){
            return dm.widthPixels;
        }else {
            return dm.heightPixels;
        }
    }
}
