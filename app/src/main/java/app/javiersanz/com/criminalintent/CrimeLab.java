package app.javiersanz.com.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Usuario on 17/06/2016.
 */
public class CrimeLab {

    // Variables

    private static CrimeLab sCrimeLab;
    private List <Crime> mCrimes;

    // Get method: if the instance already exists, then get() simply returns the instance
    // If the instance does not exist yet, then get()  will cal the constructor to create it

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    // Setting up the list of Crime objects

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        // Generating crimes and adding them to the list mCrimes:
        for(int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + (i + 1));
            crime.setSolved(i % 2 == 0); // Every other one
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime (UUID id){
        for(Crime crime : mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }

}
