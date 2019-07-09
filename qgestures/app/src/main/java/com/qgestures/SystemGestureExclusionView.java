package com.qgestures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.view.ViewCompat;

import java.util.Collections;
import java.util.List;

public class SystemGestureExclusionView extends View {

    private Rect boundingBox = new Rect();
    private List<Rect> exclusions = Collections.singletonList(boundingBox);

    public SystemGestureExclusionView(Context context) {
        super(context);
    }

    public SystemGestureExclusionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SystemGestureExclusionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SystemGestureExclusionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            boundingBox.set(left, top, right, bottom);
            ViewCompat.setSystemGestureExclusionRects(this, exclusions);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.getClipBounds(boundingBox);
        ViewCompat.setSystemGestureExclusionRects(this, exclusions);
    }
}