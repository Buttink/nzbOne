package org.nzbone.drawer.model;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import org.nzbone.drawer.item.model.DrawerItemModel;

import java.util.List;

@AutoValue
public abstract class DrawerModel {

    @NonNull
    public DrawerModel create(@NonNull List<DrawerItemModel> items) {
        return new AutoValue_DrawerModel(items);
    }

    @NonNull public abstract List<DrawerItemModel> items();
}
