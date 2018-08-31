package com.hencoder.hencoderpracticelayout1.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


public class Sample03CustomViewGroup extends ViewGroup {


  private int[] mChildLefts;
  private int[] mChildTops;
  private int[] mChildRights;
  private int[] mChildBottoms;


  public Sample03CustomViewGroup(Context context) {
    super(context);
    init(context, null);
  }

  public Sample03CustomViewGroup(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);

  }

  private void init(Context context, AttributeSet attrs) {
//    setWillNotDraw(false);

  }

  public Sample03CustomViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    init(context, attrs);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    int childCount = getChildCount();
    System.out.println("childCount = " + childCount);

    mChildLefts = new int[childCount];
    mChildTops = new int[childCount];
    mChildRights = new int[childCount];
    mChildBottoms = new int[childCount];
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    System.out.println("Sample03CustomViewGroup.onMeasure");


    //1.根据自己的LayoutParams属性获取MeasureSpec
    //2.测量各个子view的宽高和位置并保存，测量自己的宽高
    //3.重写onLayout，调用保存的位置信息，给每个子view摆放位置
    int selfWidthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
    int selfWidthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

    int selfHeightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
    int selfHeightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

//    if (selfWidthSpecMode == MeasureSpec.EXACTLY) {
//      System.out.println("selfWidthSpecMode = EXACTLY");
//    } else if (selfWidthSpecMode == MeasureSpec.AT_MOST) {
//      System.out.println("selfWidthSpecMode = AT_MOST");
//    } else if (selfWidthSpecMode == MeasureSpec.UNSPECIFIED) {
//      System.out.println("selfWidthSpecMode = UNSPECIFIED");
//    }
//
//    System.out.println("selfWidthSpecSize = " + selfWidthSpecSize);

    if (selfHeightSpecMode == MeasureSpec.EXACTLY) {
      System.out.println("selfHeightSpecMode = EXACTLY");
    } else if (selfHeightSpecMode == MeasureSpec.AT_MOST) {
      System.out.println("selfHeightSpecMode = AT_MOST");
    } else if (selfHeightSpecMode == MeasureSpec.UNSPECIFIED) {
      System.out.println("selfHeightSpecMode = UNSPECIFIED");
    }

    System.out.println("selfHeightSpecSize = " + selfHeightSpecSize);
    int usedWidth = 0;
    int usedHeight = 0;
    int maxHeight = 0;

    for (int i = 0; i < getChildCount(); i++) {
      View childView = getChildAt(i);
      int unspecifiedSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
      childView.measure(unspecifiedSpec, unspecifiedSpec);
      int rawMeasuredChildWidth = childView.getMeasuredWidth();
      int rawMeasuredChildHeight = childView.getMeasuredHeight();
      System.out.println("rawMeasuredChildWidth = " + rawMeasuredChildWidth);
      System.out.println("rawMeasuredChildHeight = " + rawMeasuredChildHeight);

      if (usedWidth + rawMeasuredChildWidth > selfWidthSpecSize) {
        usedWidth = 0;
        usedHeight += maxHeight;
      }


      LayoutParams lp = childView.getLayoutParams();
      System.out.println("lp.width = " + lp.width);
      System.out.println("lp.height = " + lp.height);
      int childWidthMeasureSpec;
      int childHeightMeasureSpec;
      switch (lp.width) {
        case LayoutParams.MATCH_PARENT:
          if (selfWidthSpecMode == MeasureSpec.EXACTLY || selfWidthSpecMode == MeasureSpec.AT_MOST) {
            childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(selfWidthSpecSize - usedWidth, MeasureSpec.EXACTLY);
          } else {
            childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
          }
          break;

        case LayoutParams.WRAP_CONTENT:
          if (selfWidthSpecMode == MeasureSpec.EXACTLY || selfWidthSpecMode == MeasureSpec.AT_MOST) {
            childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(selfWidthSpecSize - usedWidth, MeasureSpec.AT_MOST);
          } else {
            childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
          }
          break;

        default:
          childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
          break;
      }

      int childWidthSpecMode = MeasureSpec.getMode(childWidthMeasureSpec);
      int childWidthSpecSize = MeasureSpec.getSize(childWidthMeasureSpec);

      if (childWidthSpecMode == MeasureSpec.EXACTLY) {
        System.out.println("childWidthSpecMode = EXACTLY");
      } else if (childWidthSpecMode == MeasureSpec.AT_MOST) {
        System.out.println("childWidthSpecMode = AT_MOST");
      } else if (childWidthSpecMode == MeasureSpec.UNSPECIFIED) {
        System.out.println("childWidthSpecMode = UNSPECIFIED");
      }
      System.out.println("childWidthSpecSize = " + childWidthSpecSize);


      switch (lp.height) {

        case LayoutParams.MATCH_PARENT:
          if (selfHeightSpecMode == MeasureSpec.EXACTLY || selfHeightSpecMode == MeasureSpec.AT_MOST) {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(selfHeightSpecSize - usedHeight, MeasureSpec.EXACTLY);
          } else {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
          }
          break;

        case LayoutParams.WRAP_CONTENT:

          if (selfHeightSpecMode == MeasureSpec.EXACTLY || selfHeightSpecMode == MeasureSpec.AT_MOST) {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(selfHeightSpecSize - usedHeight, MeasureSpec.AT_MOST);
          } else {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
          }
          break;

        default:
          childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(lp.height, MeasureSpec.EXACTLY);
          break;
      }

      int childHeightSpecMode = MeasureSpec.getMode(childHeightMeasureSpec);
      int childHeightSpecSize = MeasureSpec.getSize(childHeightMeasureSpec);
      if (childHeightSpecMode == MeasureSpec.EXACTLY) {
        System.out.println("childHeightSpecMode = EXACTLY");
      } else if (childHeightSpecMode == MeasureSpec.AT_MOST) {
        System.out.println("childHeightSpecMode = AT_MOST");
      } else if (childHeightSpecMode == MeasureSpec.UNSPECIFIED) {
        System.out.println("childHeightSpecMode = UNSPECIFIED");
      }
      System.out.println("childHeightSpecSize = " + childHeightSpecSize);

      childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);

      int measuredChildWidth = childView.getMeasuredWidth();
      int measuredChildHeight = childView.getMeasuredHeight();
      System.out.println("measuredChildWidth = " + measuredChildWidth);
      System.out.println("measuredChildHeight = " + measuredChildHeight);
      maxHeight = Math.max(maxHeight, measuredChildHeight);
//      if (usedWidth + measuredChildWidth > selfWidthSpecSize) {
//        usedWidth = 0;
////        usedHeight += measuredChildHeight;
//      }
      System.out.println("usedWidth = " + usedWidth);
      System.out.println("usedHeight = " + usedHeight);
      mChildLefts[i] = usedWidth;
      mChildTops[i] = usedHeight;
      mChildRights[i] = mChildLefts[i] + measuredChildWidth;
      mChildBottoms[i] = mChildTops[i] + measuredChildHeight;

      usedWidth += measuredChildWidth;
    }


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
    for (int i = 0; i < getChildCount(); i++) {
      getChildAt(i).layout(mChildLefts[i], mChildTops[i], mChildRights[i], mChildBottoms[i]);
    }

  }


  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    System.out.println("Sample03CustomViewGroup.onDraw");
  }

}
