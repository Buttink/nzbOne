package org.nzbone;

import android.app.Application;

import org.nzbone.drawer.DrawerModule;

public class NzbOneApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .drawerModule(new DrawerModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
