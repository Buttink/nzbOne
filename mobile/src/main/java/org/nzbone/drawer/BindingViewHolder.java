package org.nzbone.drawer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BindingViewHolder<T> extends RecyclerView.ViewHolder {

    @NonNull private final T binding;

    public BindingViewHolder(@NonNull View itemView,
                             @NonNull T binding) {
        super(itemView);
        this.binding = binding;
    }

    @NonNull
    public T getBinding() {
        return binding;
    }
}
