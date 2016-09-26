package org.nzbone.drawer;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import org.nzbone.util.ListModel;
import org.nzbone.util.ModelDiffCallback;

import java.util.ArrayList;
import java.util.List;

public abstract class BindingAdapter<T extends ListModel> extends RecyclerView.Adapter<BindingViewHolder<T>> {

    @NonNull private List<T> model = new ArrayList<>();

    public final void update(final List<T> model) {
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new ModelDiffCallback(this.model, model));
        this.model = model;
        result.dispatchUpdatesTo(this);
    }

    @Override
    public final void onBindViewHolder(BindingViewHolder<T> holder, int position) {
        onBindViewHolder(holder, model.get(position));
    }

    protected abstract void onBindViewHolder(BindingViewHolder<T> holder, T model);

    @Override
    public final int getItemViewType(int position) {
        return getItemViewType(model.get(position));
    }

    protected abstract int getItemViewType(T t);

    @Override
    public final int getItemCount() {
        return model.size();
    }
}
