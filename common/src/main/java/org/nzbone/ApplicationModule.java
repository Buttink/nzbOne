package org.nzbone;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class ApplicationModule {

    @NonNull private final Context context;

    public ApplicationModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    Realm providesRealm(@NonNull Context context) {
        return Realm.getInstance(
                new RealmConfiguration.Builder(context)
                        .migration(new Migration())
                        .build());
    }

}
