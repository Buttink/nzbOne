package org.nzbone.drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.nzbone.BaseFragment;
import org.nzbone.R;
import org.nzbone.drawer.item.model.DrawerItemModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DrawerFragment extends BaseFragment implements DrawerView {

    @BindView(R.id.list) RecyclerView recyclerView;

    @Inject DrawerPresenterFactory presenterFactory;

    private Unbinder viewBinding = Unbinder.EMPTY;
    private DrawerAdapter adapter;
    private DrawerPresenter presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getApplication().getComponent().inject(this);
        presenter = presenterFactory.build(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drawer, container, false);
        viewBinding = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DrawerAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    public void onModelUpdated(List<DrawerItemModel> model) {
        if (adapter != null) {
            adapter.update(model);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewBinding.unbind();
    }
}
