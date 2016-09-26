package org.nzbone;

import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    public NzbOneApplication getApplication() {
        return (NzbOneApplication) getActivity().getApplication();
    }

    protected ApplicationComponent getComponent() {
        return getApplication().getComponent();
    }
}
