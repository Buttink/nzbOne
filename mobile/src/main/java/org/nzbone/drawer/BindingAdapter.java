package org.nzbone.drawer;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import org.nzbone.util.ListModel;
import org.nzbone.util.ModelDiffCallback;

import java.util.ArrayList;
import java.util.List;

public abstract class BindingAdapter<S, T extends ListModel> extends RecyclerView.Adapter<BindingViewHolder<S>> {

    @NonNull private List<T> model = new ArrayList<>();

    public void update(final List<T> model) {
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new ModelDiffCallback(this.model, model));
        this.model = model;
        result.dispatchUpdatesTo(this);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder<S> holder, int position) {
        onBindViewHolder(holder, model.get(position));
    }

    protected abstract void onBindViewHolder(BindingViewHolder<S> holder, T item);

    @Override
    public int getItemCount() {
        return model.size();
    }
}
