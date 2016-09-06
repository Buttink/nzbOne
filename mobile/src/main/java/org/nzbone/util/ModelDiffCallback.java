package org.nzbone.util;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import java.util.List;

public class ModelDiffCallback extends DiffUtil.Callback {

    @NonNull private final List<? extends ListModel> oldModel;
    @NonNull private final List<? extends ListModel> newModel;

    public ModelDiffCallback(@NonNull List<? extends ListModel> oldModel,
                             @NonNull List<? extends ListModel> newModel) {
        this.oldModel = oldModel;
        this.newModel = newModel;
    }

    @Override
    public int getOldListSize() {
        return oldModel.size();
    }

    @Override
    public int getNewListSize() {
        return newModel.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        int oldId = oldModel.get(oldItemPosition).id();
        int newId = newModel.get(newItemPosition).id();
        return oldId == newId;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        ListModel oldItem = oldModel.get(oldItemPosition);
        ListModel newItem = newModel.get(newItemPosition);
        return oldItem.equals(newItem);
    }
}
