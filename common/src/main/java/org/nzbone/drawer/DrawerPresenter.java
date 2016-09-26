package org.nzbone.drawer;

import android.support.annotation.NonNull;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.Subscriptions;

@AutoFactory
public class DrawerPresenter {

    @NonNull private final DrawerView view;
    @NonNull private final DrawerService drawerService;
    @NonNull private Subscription itemsSubscriptions = Subscriptions.empty();

    public DrawerPresenter(@NonNull DrawerView view,
                           @Provided @NonNull DrawerService drawerService) {
        this.view = view;
        this.drawerService = drawerService;
    }

    public void onResume() {
        itemsSubscriptions = drawerService.getItems()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::onModelUpdated);
    }

    public void onPause() {
        itemsSubscriptions.unsubscribe();
    }
}
