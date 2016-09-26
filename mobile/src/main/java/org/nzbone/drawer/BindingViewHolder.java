package org.nzbone.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BindingViewHolder<T> extends RecyclerView.ViewHolder {

    public BindingViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T model);
}
