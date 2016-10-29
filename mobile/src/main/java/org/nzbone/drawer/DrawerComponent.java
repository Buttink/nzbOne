package org.nzbone.drawer;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {
        DrawerModule.class,
})
public interface DrawerComponent {
    void inject(DrawerFragment fragment);
}
