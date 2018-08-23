package com.hencoder.hencoderpracticelayout1.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class Practice02CustomSizeView extends View {
    public Practice02CustomSizeView(Context context) {
        super(context);
    }

    public Practice02CustomSizeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02CustomSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
