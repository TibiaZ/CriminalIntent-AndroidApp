package app.javiersanz.com.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Usuario on 17/06/2016.
 */
public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
