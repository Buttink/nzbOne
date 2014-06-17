package com.nzbone;

import android.accounts.AccountManager;
import android.content.Context;

import com.nzbone.authenticator.BootstrapAuthenticatorActivity;
import com.nzbone.authenticator.LogoutService;
import com.nzbone.core.TimerService;
import com.nzbone.ui.BootstrapTimerActivity;
import com.nzbone.ui.MainActivity;
import com.nzbone.ui.CheckInsListFragment;
import com.nzbone.ui.NavigationDrawerFragment;
import com.nzbone.ui.NewsActivity;
import com.nzbone.ui.NewsListFragment;
import com.nzbone.ui.UserActivity;
import com.nzbone.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                MainActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NavigationDrawerFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }
)
public class BootstrapModule {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
