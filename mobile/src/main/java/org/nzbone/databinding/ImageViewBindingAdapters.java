package org.nzbone.databinding;

import android.databinding.BindingAdapter;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

public class ImageViewBindingAdapters {

    @BindingAdapter({"tintBinding"})
    public static void loadTint(ImageView view, @ColorRes int color) {
        view.setColorFilter(color);
    }

    @BindingAdapter({"srcBinding"})
    public static void loadImage(ImageView view, @DrawableRes int img) {
        view.setImageResource(img);
    }
}
