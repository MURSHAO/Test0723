package com.bawei.test0723.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.bawei.test0723.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineView extends View {

    private Paint paint_one;
    private Paint paint_two;
    private Paint paint_three;
    private Paint paint_four;
    private List<String> list;
    List<Point> pointList = new ArrayList<>();

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        paint_one = new Paint();
        paint_one.setAntiAlias(true);
        paint_one.setStyle(Paint.Style.FILL);
        paint_one.setColor(ContextCompat.getColor(context, R.color.colorAccent));

        paint_two = new Paint();
        paint_two.setAntiAlias(true);
        paint_two.setStyle(Paint.Style.FILL);
        paint_two.setColor(ContextCompat.getColor(context,R.color.colorAccent));
        paint_two.setTextSize(20);
        paint_two.setTextAlign(Paint.Align.CENTER);

        paint_three = new Paint();
        paint_three.setAntiAlias(true);
        paint_three.setStyle(Paint.Style.FILL);
        paint_three.setColor(ContextCompat.getColor(context,R.color.colorAccent));

        paint_four = new Paint();
        paint_four.setAntiAlias(true);
        paint_four.setStyle(Paint.Style.FILL);
        paint_four.setColor(ContextCompat.getColor(context,R.color.colorAccent));

        list = new ArrayList<>();
        list.add("周一");
        list.add("周二");
        list.add("周三");
        list.add("周四");
        list.add("周五");
        list.add("周六");
        list.add("周日");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50,600,1000,600,paint_one);
        canvas.drawLine(50,600,50,50,paint_one);

        int x= 950/list.size()+1;

        pointList.clear();

        for (String s : list) {
            Point point = new Point();
            point.x = 50+x;
            point.y = new Random().nextInt(600);
            pointList.add(point);

            canvas.drawText(s,50+x,640,paint_two);
            x+= 950/list.size()+1;
        }
        for (int i = 0; i < pointList.size(); i++) {
            canvas.drawCircle(pointList.get(i).x,pointList.get(i).y,10,paint_three);
            if(i<pointList.size()-1){
                canvas.drawLine(pointList.get(i).x,pointList.get(i).y,pointList.get(i+1).x,pointList.get(i+1).y,paint_four);
            }
        }
    }
}
