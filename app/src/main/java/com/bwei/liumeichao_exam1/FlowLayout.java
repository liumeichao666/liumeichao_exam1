package com.bwei.liumeichao_exam1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


public class FlowLayout extends ViewGroup {


    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    //测量宽高的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //1.获取所有孩子宽高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //2.设置模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //3.
        int width = 0;
        int height = 0;
        int lineWidth=0;
        int lineHeight=0;
        int totalHeight=0;
        View childView;
        int childWidth=0;
        int childHeight=0;

        //4.遍历
        for (int i = 0; i <getChildCount() ; i++) {
            //获得孩子组件
            childView=getChildAt(i);
            //获得孩子宽
            childWidth=childView.getMeasuredWidth();
            width=childWidth*5;
            childHeight=childView.getMeasuredHeight();

            //判断
           if(i%3==0){
               totalHeight+=lineHeight;
               lineHeight=childHeight;
               lineWidth=childWidth;
           }else{
               totalHeight+=lineHeight;
               //模为1的都是第二个 所以行宽为累加
               lineWidth+=childWidth;
               lineHeight=childHeight;
           }


           if(i==getChildCount()-1){
               totalHeight+=lineHeight;
               height=totalHeight;
           }
        }

        //模式的判断
        width = widthMode == MeasureSpec.EXACTLY ? widthSize : width;
        height = heightMode == MeasureSpec.EXACTLY ? heightSize : height;
        //设置测量的宽高
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int lineWidth=0;
        int lineHeight=0;
        int totalHeight=0;
        View childView;
        int childWidth=0;
        int childHeight=0;

        //4.遍历
        for (int i = 0; i <getChildCount() ; i++) {
            //获得孩子组件
            childView=getChildAt(i);
            //获得孩子宽
            childWidth=childView.getMeasuredWidth();
            childHeight=childView.getMeasuredHeight();

            //判断
            if(i%3==0){
                totalHeight+=lineHeight;
                lineWidth=0;
                childViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth,totalHeight+childHeight);
                lineHeight=childHeight;
                lineWidth=childWidth;
            }else{
                totalHeight+=lineHeight;
                //模为1的都是第二个 所以行宽为累加
                childViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth,totalHeight+childHeight);
                lineWidth+=childWidth;
                lineHeight=childHeight;
            }



        }
    }

    private void childViewLayout(View childView, int l, int t, int r, int b) {
        childView.layout(l,t,r,b);


    }
}
