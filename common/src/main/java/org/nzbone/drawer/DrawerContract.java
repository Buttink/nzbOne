package org.nzbone.drawer;

import org.nzbone.drawer.item.model.DrawerItemModel;

import java.util.List;

/**
 * Created by stockingd on 10/26/16.
 */
public interface DrawerContract {

    interface Presenter {

    }

    interface View {
        void onModelUpdated(List<DrawerItemModel> model);
    }
}
