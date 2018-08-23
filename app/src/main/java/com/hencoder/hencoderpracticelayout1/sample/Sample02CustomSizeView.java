package com.hencoder.hencoderpracticelayout1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;


public class Sample02CustomSizeView extends View {

  private float mRadius = 100f;
  private Paint mPaint = new Paint();


  public Sample02CustomSizeView(Context context) {
    super(context);
  }

  public Sample02CustomSizeView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample02CustomSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//    int width = getWidth();
//    int height = getHeight();
//    System.out.println("height = " + height);
//    System.out.println("width = " + width);
    System.out.println("Sample02CustomSizeView.onMeasure");

//    final int specMode = MeasureSpec.getMode(heightMeasureSpec);
//    final int specSize = MeasureSpec.getSize(heightMeasureSpec);
//
//    System.out.println("specMode = " + specMode);
//    System.out.println("specSize = " + specSize);

    int paddingTop = getPaddingTop();
    int paddingBottom = getPaddingBottom();
    System.out.println("paddingTop = " + paddingTop);
//    setMeasuredDimension(10000, 10000);

    mPaint.setTextSize(20);
    String text = "自定义View尺寸";
    Rect bounds = new Rect();
    mPaint.getTextBounds(text, 0, text.length(), bounds);
    System.out.println("bounds = " + bounds);

    int measuredWidth = getMeasuredWidth();
    int measuredHeight = (int) (paddingTop + 2 * mRadius + (bounds.bottom - bounds.top) + paddingBottom);

    measuredWidth = resolveSize(measuredWidth, widthMeasureSpec);
    measuredHeight = resolveSize(measuredHeight, heightMeasureSpec);



    setMeasuredDimension(measuredWidth, measuredHeight);

  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    System.out.println("w = [" + w + "], h = [" + h + "], oldw = [" + oldw + "], oldh = [" + oldh + "]");
    System.out.println("Sample02CustomSizeView.onSizeChanged");
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    System.out.println("Sample02CustomSizeView.onDraw");


    int measuredWidth = getMeasuredWidth();
    int measuredHeight = getMeasuredHeight();

    System.out.println("measuredWidth = " + measuredWidth);
    System.out.println("measuredHeight = " + measuredHeight);

    mPaint.setColor(Color.BLUE);


    canvas.drawCircle(0, 0, 100, mPaint);

  }

  @Override
  protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
    System.out.println("Sample02CustomSizeView.onLayout");

  }
}
