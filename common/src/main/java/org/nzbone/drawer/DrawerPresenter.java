package org.nzbone.drawer;

import android.support.annotation.NonNull;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.Subscriptions;

import javax.inject.Inject;

@AutoFactory
public class DrawerPresenter implements DrawerContract.Presenter {

    @NonNull private final DrawerContract.View view;
    @NonNull private final DrawerService drawerService;
    @NonNull private Subscription itemsSubscriptions = Subscriptions.empty();

    @Inject
    public DrawerPresenter(@NonNull DrawerContract.View view,
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
