package com.hencoder.hencoderpracticelayout1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;


public class Sample03CustomViewGroup extends ViewGroup {


  public Sample03CustomViewGroup(Context context) {
    super(context);
    init(context, null);
  }

  public Sample03CustomViewGroup(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);

  }

  private void init(Context context, AttributeSet attrs) {
    setWillNotDraw(false);
  }

  public Sample03CustomViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    init(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    System.out.println("Sample03CustomViewGroup.onMeasure");

  }

//  @Override
//  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//    super.onSizeChanged(w, h, oldw, oldh);
//    System.out.println("w = [" + w + "], h = [" + h + "], oldw = [" + oldw + "], oldh = [" + oldh + "]");
//    System.out.println("Sample02CustomSizeView.onSizeChanged");
//  }

  @Override
  protected void onLayout(boolean changed, int l, int t, int r, int b) {
    System.out.println("Sample03CustomViewGroup.onLayout");

  }



  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    System.out.println("Sample03CustomViewGroup.onDraw");
  }

}
