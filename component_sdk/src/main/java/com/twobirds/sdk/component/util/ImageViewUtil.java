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

package com.twobirds.sdk.component.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import com.twobirds.sdk.component.custom.image.imageloader.DefaultImageLoadingListener;
import com.twobirds.sdk.component.custom.image.imageloader.IImageOnLoadingCompleteListener;

/**
 * ImageView工具类
 *
 * @author TwoBirds
 * @version 0.0.1
 */
public class ImageViewUtil {

    private static int defaultImage = 0;
    private static DisplayImageOptions.Builder displayImageOptionsBuilder = new DisplayImageOptions.Builder().cacheInMemory().cacheOnDisc().imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(Bitmap.Config.RGB_565);

    private static <T extends View> T findView(View contentView, int viewId) {
        return (T) contentView.findViewById(viewId);
    }

    public static void setImageView(Context context, View layout, int imageViewId, String imageUri) {
        setImageView(context, layout, imageViewId, imageUri, 0, false, null);
    }

    public static void setImageView(Context context, View layout, int imageViewId, String imageUri, boolean isOpenLoadAnimation) {
        setImageView(context, layout, imageViewId, imageUri, 0, isOpenLoadAnimation, null);
    }

    public static void setImageView(Context context, View layout, int imageViewId, String imageUri, IImageOnLoadingCompleteListener iImageOnLoadingCompleteListener) {
        setImageView(context, layout, imageViewId, imageUri, 0, false, iImageOnLoadingCompleteListener);
    }

    public static void setImageView(Context context, View layout, int imageViewId, String imageUri, int defaultImage) {
        setImageView(context, layout, imageViewId, imageUri, defaultImage, false, null);
    }

    public static void setImageView(Context context, View layout, int imageViewId, String imageUri, int defaultImage, boolean isOpenLoadAnimation) {
        setImageView(context, layout, imageViewId, imageUri, defaultImage, isOpenLoadAnimation, null);
    }

    public static void setImageView(Context context, View layout, int imageViewId, String imageUri, int defaultImage, IImageOnLoadingCompleteListener iImageOnLoadingCompleteListener) {
        setImageView(context, layout, imageViewId, imageUri, defaultImage, false, iImageOnLoadingCompleteListener);
    }

    public static void setImageView(Context context, View layout, int imageViewId, String imageUri, int defaultImage, boolean isOpenLoadAnimation, IImageOnLoadingCompleteListener iImageOnLoadingCompleteListener) {
        ImageView imageView = findView(layout, imageViewId);
        if (null != imageView && context != null) {
            if (defaultImage != 0) {
                displayImageOptionsBuilder.showImageOnFail(defaultImage).showImageForEmptyUri(defaultImage);

                Drawable defaultDrawable = context.getResources().getDrawable(defaultImage);
                if (null != defaultDrawable) {
                    imageView.setImageDrawable(defaultDrawable);
                }
            } else {
                displayImageOptionsBuilder.showImageOnFail(defaultImage).showImageForEmptyUri(defaultImage);
            }

            DefaultImageLoadingListener defaultImageLoadingListener = null;
            if (null == iImageOnLoadingCompleteListener) {
                defaultImageLoadingListener = new DefaultImageLoadingListener(context, imageView, isOpenLoadAnimation);
            } else {
                defaultImageLoadingListener = new DefaultImageLoadingListener(context, imageView, isOpenLoadAnimation, iImageOnLoadingCompleteListener);
            }
            ImageLoader.getInstance().displayImage(imageUri, imageView, displayImageOptionsBuilder.build(), defaultImageLoadingListener);
        }
    }
}
