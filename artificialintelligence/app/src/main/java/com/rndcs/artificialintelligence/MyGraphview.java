package com.rndcs.artificialintelligence;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;

import android.widget.Toast;

public class MyGraphview extends View
{
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private float[] value_degree;
    private int[] COLORS={Color.GREEN,Color.RED,Color.GRAY,Color.CYAN};
    int width;
    int height;
    int val;
    int dist=50;
    RectF rectf;
    int temp=0;
    public MyGraphview(Context context, float[] values) {

        super(context);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);

        height = metrics.heightPixels;
        width = metrics.widthPixels;
        //  Toast.makeText(getApplicationContext(), "User name is empty", Toast.LENGTH_SHORT).show();

        // Gets linearlayout
        //  LinearLayout layout = (LinearLayout)findViewById(R.id.linear);
        // Gets the layout params that will allow you to resize the layout
        //      LayoutParams params = layout.getLayoutParams();
        // Changes the height and width to the specified *pixels*
        //   params.height = 400;

        //  layout.setLayoutParams(params);
        if (width<=480)
        {
            val=300;
            dist=50;
        }
        else
        {
            if (width<=600)
            {
                val=500;
                dist=80;
            }
            else
            {
                if ( width<=720)
                {
                    val=500;
                    dist=80;
                }
                else
                {
                    val=600;
                }
            }
        }


        rectf= new RectF ((width-val)/2, dist, (width+val)/2, val+dist);

        value_degree=new float[values.length];
        for(int i=0;i<values.length;i++)
        {
            value_degree[i]=values[i];
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        //
        // Paint paint = new Paint();
        //canvas.drawPaint(paint);
        //paint.setColor(Color.BLACK);
        //paint.setTextSize(16);
        //canvas.drawText("My Text" + width+","+height, 50, 50, paint);

        for (int i = 0; i < value_degree.length; i++) {//values2.length; i++) {
            if (i == 0) {
                paint.setColor(COLORS[i]);
                canvas.drawArc(rectf, 0, value_degree[i], true, paint);
            }
            else
            {
                temp += (int) value_degree[i - 1];
                paint.setColor(COLORS[i]);


                canvas.drawArc(rectf, temp, value_degree[i], true, paint);




            }
        }
    }

}
