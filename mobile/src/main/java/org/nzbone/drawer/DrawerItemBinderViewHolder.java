package org.nzbone.drawer;

import android.support.annotation.NonNull;
import android.view.View;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

import org.nzbone.drawer.item.DrawerItemDataBinding;
import org.nzbone.drawer.item.DrawerItemPresenter;
import org.nzbone.drawer.item.model.DrawerItemModel;

@AutoFactory
public class DrawerItemBinderViewHolder extends BindingViewHolder<DrawerItemModel> {

    @NonNull private final DrawerItemDataBinding binding;
    @NonNull private final DrawerItemPresenter presenter;

    public DrawerItemBinderViewHolder(@NonNull View root,
                                      @NonNull org.nzbone.drawer.item.DrawerItemDataBinding binding,
                                      @Provided @NonNull DrawerItemPresenter presenter) {
        super(root);
        this.binding = binding;
        this.presenter = presenter;
    }

    @Override
    public void bind(DrawerItemModel model) {
        binding.setModel(model);
        binding.setPresenter(presenter);
    }
}
