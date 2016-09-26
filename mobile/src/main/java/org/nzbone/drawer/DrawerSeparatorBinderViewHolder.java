package org.nzbone.drawer;

import android.support.annotation.NonNull;
import android.view.View;

import com.google.auto.factory.AutoFactory;

import org.nzbone.drawer.item.model.DrawerItemModel;

@AutoFactory
public class DrawerSeparatorBinderViewHolder
        extends BindingViewHolder<DrawerItemModel> {

    public DrawerSeparatorBinderViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(DrawerItemModel model) {
        // do nothing
    }
}
