package org.nzbone;

import android.app.Application;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    public NzbOneApplication getApplication() {
        return (NzbOneApplication) getActivity().getApplication();
    }
}
