package com.qf.administrator.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/1/12.
 */

public class MyView extends View {
    private Bitmap bitmap;
    private Matrix matrix;
    private float d_x;
    private float d_y;//上一次手指触摸的位置
    private float last_dis ;//上一次手指间的距离
    private float last_jiaodu;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //绘制图片
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.a);
        matrix = new Matrix();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointerCount = event.getPointerCount();//获取触摸点
        if(pointerCount==1){
            //1根手指
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    d_x = event.getX();
                    d_y = event.getY();
                break;
                case MotionEvent.ACTION_MOVE:
                    float x = event.getX();
                    float y = event.getY();
                    /**
                     * 参数1：x坐标的偏移量
                     * 参数2：y坐标的偏移量 正值x向右 y向下
                     */
                    matrix.postTranslate(x-d_x,y-d_y);
                    d_x = x;
                    d_y = y;
                break;

            }
        }else if(pointerCount == 2){
            //两根手指
            //手指的两点 手指两点的中心点 手指两点的距离
            float x_1 = event.getX(0);
            float y_1 = event.getY(0);
            float x_2 = event.getX(1);
            float y_2 = event.getY(1);

            //两个点的中心点
            float cx = (x_1+x_2)/2;
            float cy = (y_1+y_2)/2;

            //两点距离
            float dis = (float) Math.sqrt(Math.pow(x_1-x_2,2)+Math.pow(y_1-y_2,2));
            float degrees = (float) Math.toDegrees(Math.atan2(x_2 - x_1, y_2 - y_1));
            //多指操控获取动作
            switch (event.getActionMasked()){
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_POINTER_DOWN:
                    last_dis = dis;
                    last_jiaodu = degrees;
                break;
                case MotionEvent.ACTION_MOVE:
                    matrix.postScale(dis/last_dis,dis/last_dis,cx,cy);
                    matrix.postRotate(last_jiaodu-degrees,cx,cy);
                    last_dis = dis;
                    last_jiaodu = degrees;
                break;

            }

        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,matrix,null);
    }
}
