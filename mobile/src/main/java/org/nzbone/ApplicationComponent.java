package org.nzbone;

import org.nzbone.drawer.DrawerFragment;
import org.nzbone.drawer.DrawerModule;
import org.nzbone.drawer.DrawerModuleMobile;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    ApplicationModule.class,
    DrawerModule.class,
    DrawerModuleMobile.class,
})
public interface ApplicationComponent {
    void inject(DrawerFragment fragment);
}
