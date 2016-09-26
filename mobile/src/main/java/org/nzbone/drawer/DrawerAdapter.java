package org.nzbone.drawer;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.nzbone.drawer.item.DrawerItemDataBinding;
import org.nzbone.drawer.item.DrawerItemType;
import org.nzbone.drawer.item.DrawerSeparatorItemDataBinding;
import org.nzbone.drawer.item.model.DrawerItemModel;

public class DrawerAdapter extends BindingAdapter<DrawerItemModel> {

    @NonNull private final DrawerItemBinderViewHolderFactory itemFactory;
    @NonNull private final DrawerSeparatorBinderViewHolderFactory separatorFactory;

    protected DrawerAdapter(@NonNull DrawerItemBinderViewHolderFactory itemFactory,
                            @NonNull DrawerSeparatorBinderViewHolderFactory separatorFactory) {
        super();
        this.itemFactory = itemFactory;
        this.separatorFactory = separatorFactory;
    }

    @Override
    public BindingViewHolder<DrawerItemModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (DrawerItemType.values()[viewType]) {
            case ADD_ACCOUNT:
            case ACCOUNT: {
                DrawerItemDataBinding binding = DrawerItemDataBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false);
                return itemFactory.create(binding.getRoot(), binding);
            }
            case SEPARATOR: {
                DrawerSeparatorItemDataBinding binding = DrawerSeparatorItemDataBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false);
                return separatorFactory.create(binding.getRoot());
            }
        }
        throw new IllegalArgumentException("Type pass in was not a known type");
    }

    @Override
    protected void onBindViewHolder(BindingViewHolder<DrawerItemModel> holder, DrawerItemModel item) {
        holder.bind(item);
    }

    @Override
    protected int getItemViewType(DrawerItemModel drawerItemModel) {
        return drawerItemModel.type().ordinal();
    }
}
