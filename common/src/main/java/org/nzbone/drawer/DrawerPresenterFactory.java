package org.nzbone.drawer;

import android.support.annotation.NonNull;

public class DrawerPresenterFactory {

    @NonNull private final DrawerService drawerService;

    public DrawerPresenterFactory(@NonNull DrawerService drawerService) {
        this.drawerService = drawerService;
    }

    public DrawerPresenter build(DrawerView view) {
        return new DrawerPresenter(view, drawerService);
    }
}
