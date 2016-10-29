package org.nzbone.drawer;

import android.support.annotation.NonNull;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;

@Module
public class DrawerModule {

    @Provides
    @Singleton
    DrawerService provideDrawerService(@NonNull Realm realm) {
        return new DrawerService(realm);
    }

    @Provides
    @Singleton
    DrawerPresenterFactory provideDrawerPresenterFactory(Provider<DrawerService> service) {
        return new DrawerPresenterFactory(service);
    }
}
