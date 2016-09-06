package org.nzbone.drawer.item.model;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import org.nzbone.drawer.item.DrawerItemType;
import org.nzbone.util.ListModel;

@AutoValue
public abstract class DrawerItemModel extends ListModel {

    @NonNull
    public static DrawerItemModel create(int id,
                                  @NonNull DrawerItemType type,
                                  @NonNull String name,
                                  @DrawableRes int icon,
                                  @ColorRes int color) {
        return new AutoValue_DrawerItemModel(id, type, name, icon, color);
    }

    @NonNull public abstract DrawerItemType type();
    @NonNull public abstract String name();
    @DrawableRes public abstract int icon();
    @ColorRes public abstract int tint();
}
