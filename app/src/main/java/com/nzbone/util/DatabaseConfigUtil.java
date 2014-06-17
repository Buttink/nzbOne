package com.nzbone.util;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.nzbone.data.DatabaseHelper;

import java.io.File;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
  public static void main(String[] args) throws Exception {
    writeConfigFile(new File("app/src/main/res/ormlite_config.txt"), DatabaseHelper.persistedTypes);
  }
}
