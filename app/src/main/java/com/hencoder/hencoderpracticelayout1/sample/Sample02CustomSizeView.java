package com.hencoder.hencoderpracticelayout1.sample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;


public class Sample02CustomSizeView extends View {
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
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
