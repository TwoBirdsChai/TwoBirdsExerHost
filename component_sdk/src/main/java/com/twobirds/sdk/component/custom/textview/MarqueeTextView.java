/**
 *
 * Copyright (c) 2015 Chutong Technologies All rights reserved.
 *
 */

/**
 * Version Control
 *
 * | version | date        | author         | description
 *   0.0.1     2015.11.30    TwoBirds     整理代码
 *
 */

package com.twobirds.sdk.component.custom.textview;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 实现跑马灯效果的TextView
 *
 * @author TwoBirds
 * @version 0.0.1
 */
public class MarqueeTextView extends TextView
{
    public MarqueeTextView(Context context)
    {
        this(context, null);
    }
    
    public MarqueeTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        
        setFocusable(true);
        setFocusableInTouchMode(true);
        
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(-1);
    }
    
    public MarqueeTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        
        setFocusable(true);
        setFocusableInTouchMode(true);
        
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(-1);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect)
    {
        if (focused)
        {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }
    
    @Override
    public void onWindowFocusChanged(boolean focused)
    {
        if (focused)
        {
            super.onWindowFocusChanged(focused);
        }
    }
    
    @Override
    public boolean isFocused()
    {
        return true;
    }
}
