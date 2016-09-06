package org.nzbone;

import org.nzbone.drawer.DrawerFragment;
import org.nzbone.drawer.DrawerModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        DrawerModule.class,
})
public interface ApplicationComponent {
    void inject(DrawerFragment fragment);
}
