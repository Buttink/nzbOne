package org.nzbone.drawer;

import org.nzbone.drawer.item.DrawerItemPresenter;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DrawerModuleMobile {

    @Provides
    @Singleton
    DrawerAdapter
    provideDrawerAdapter(DrawerItemBinderViewHolderFactory itemFactory,
                         DrawerSeparatorBinderViewHolderFactory separatorFactory) {
        return new DrawerAdapter(itemFactory, separatorFactory);
    }

    @Provides
    @Singleton
    DrawerItemPresenter
    provideDrawerItemPresenter() {
        return new DrawerItemPresenter();
    }

    @Provides
    @Singleton
    DrawerItemBinderViewHolderFactory
    provideDrawerItemBinderViewHolderFactory(Provider<DrawerItemPresenter> presenter) {
        return new DrawerItemBinderViewHolderFactory(presenter);
    }

    @Provides
    @Singleton
    DrawerSeparatorBinderViewHolderFactory
    provideDrawerSeparatorBinderViewHolderFactory() {
        return new DrawerSeparatorBinderViewHolderFactory();
    }
}
