package org.nzbone.drawer;

import org.nzbone.drawer.item.model.DrawerItemModel;

import java.util.List;

public interface DrawerView {

    void onModelUpdated(List<DrawerItemModel> model);
}
