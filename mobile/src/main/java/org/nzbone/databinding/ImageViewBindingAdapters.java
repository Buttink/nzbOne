package org.nzbone.databinding;

import android.databinding.BindingAdapter;
import android.support.annotation.ColorRes;
import android.widget.ImageView;

public class ImageViewBindingAdapters {

    @BindingAdapter({"bind:tint"})
    public static void loadImage(ImageView view, @ColorRes int color) {
        view.setColorFilter(color);
    }
}
