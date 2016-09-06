package org.nzbone.drawer;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.nzbone.drawer.item.DrawerItemDataBinding;
import org.nzbone.drawer.item.model.DrawerItemModel;

public class DrawerAdapter extends BindingAdapter<DrawerItemDataBinding, DrawerItemModel> {

    @Override
    public BindingViewHolder<DrawerItemDataBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        DrawerItemDataBinding binding = DrawerItemDataBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new BindingViewHolder<>(binding.getRoot(), binding);
    }

    @Override
    protected void onBindViewHolder(BindingViewHolder<DrawerItemDataBinding> holder, DrawerItemModel item) {
        holder.getBinding().setModel(item);
    }
}
