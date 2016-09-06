package org.nzbone.drawer;

import android.support.annotation.NonNull;

import org.nzbone.account.SickbeardAccount;
import org.nzbone.common.R;
import org.nzbone.drawer.item.DrawerItemType;
import org.nzbone.drawer.item.model.DrawerItemModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

public class DrawerService {

    @NonNull private final Realm realm;

    public DrawerService(@NonNull Realm realm) {
        this.realm = realm;
    }

    public Observable<List<DrawerItemModel>> getItems() {
        return realm.where(SickbeardAccount.class)
                .findAllAsync()
                .asObservable()
                .filter(RealmResults::isLoaded)
                .map(accounts -> {
                    List<DrawerItemModel> model = new ArrayList<>();
                    for (SickbeardAccount account : accounts) {
                        model.add(DrawerItemModel.create(
                                account.getId(),
                                DrawerItemType.ACCOUNT,
                                "Sickbeard",
                                R.drawable.ic_android_black_24dp,
                                R.color.green500));
                    }
                    model.add(DrawerItemModel.create(
                                -1,
                                DrawerItemType.SEPERATOR,
                                "",
                                0,
                                0));
                    model.add(DrawerItemModel.create(
                            -2,
                            DrawerItemType.ADD_ACCOUNT,
                            "Add Account",
                            R.drawable.ic_add_circle_black_24dp,
                            0));
                    return model;
                });
    }
}
