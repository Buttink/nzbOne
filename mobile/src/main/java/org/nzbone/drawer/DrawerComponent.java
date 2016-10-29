package org.nzbone.drawer;

import dagger.Component;
import org.nzbone.ApplicationComponent;

@Component(dependencies = ApplicationComponent.class, modules = {
        DrawerModule.class,
})
public class DrawerComponent {
}
