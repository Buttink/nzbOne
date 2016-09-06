package org.nzbone.drawer;

import android.support.annotation.NonNull;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class DrawerPresenter {

    @NonNull private final DrawerView view;
    @NonNull private final DrawerService drawerService;
    @NonNull private Subscription itemsSubscriptions = Subscriptions.empty();

    public DrawerPresenter(@NonNull DrawerView view,
                           @NonNull DrawerService drawerService) {
        this.view = view;
        this.drawerService = drawerService;
    }

    public void onResume() {
        itemsSubscriptions = drawerService.getItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::onModelUpdated);
    }

    public void onPause() {
        itemsSubscriptions.unsubscribe();
    }
}
