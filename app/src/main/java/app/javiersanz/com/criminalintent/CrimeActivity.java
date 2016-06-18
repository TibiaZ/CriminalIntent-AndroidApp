package app.javiersanz.com.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class CrimeActivity extends SingleFragmentActivity {

    // Using the abstract class called SingleFragmentActivity

    @Override
    protected Fragment createFragment(){
        return new CrimeFragment();
    }
}
