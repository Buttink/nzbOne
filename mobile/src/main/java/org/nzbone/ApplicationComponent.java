package org.nzbone;

import android.content.Context;
import dagger.Component;
import dagger.Subcomponent;
import io.realm.Realm;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        ApplicationModule.class,
})
public interface ApplicationComponent {
    Context providesContext();
    Realm providesRealm();
}
