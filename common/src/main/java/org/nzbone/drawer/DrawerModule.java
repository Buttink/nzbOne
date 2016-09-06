package org.nzbone.drawer;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class DrawerModule {

    @Provides
    @Singleton
    DrawerService provideDrawerService(@NonNull Realm realm) {
        return new DrawerService(realm);
    }

    @Provides
    @Singleton
    DrawerPresenterFactory provideDrawerPresenterFactory(DrawerService service) {
        return new DrawerPresenterFactory(service);
    }
}
