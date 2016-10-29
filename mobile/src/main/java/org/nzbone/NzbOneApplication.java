package org.nzbone;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import org.nzbone.drawer.DrawerModule;

public class NzbOneApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
