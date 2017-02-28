package com.zssfw.oschina.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * @创建者 administrator
 * @创建时间 2017/2/27 16:15
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/27$
 * @更新描述 ${TODO}
 */

public class DyRecycleView extends RecyclerView {
    public DyRecycleView(Context context) {
        this(context, null);
    }

    public DyRecycleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            childAt.measure(widthSpec,0);
        }
    }
}
