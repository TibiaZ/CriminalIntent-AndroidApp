package app.javiersanz.com.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static app.javiersanz.com.criminalintent.CrimeDbSchema.*;

/**
 * Created by Usuario on 17/06/2016.
 */
public class CrimeLab {

    // Variables

    private static CrimeLab sCrimeLab;
    private Context mContext;
    private SQLiteDatabase mDataBase;

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
        mContext = context.getApplicationContext();
        mDataBase = new CrimeBaseHelper(mContext)
                .getWritableDatabase();
    }

    // Adding a new crime with the plus menu button

    public void addCrime(Crime c){
        ContentValues values = getContentValues(c);

        mDataBase.insert(CrimeTable.NAME, null, values);
    }

    // Updating a crime

    public void updateCrime(Crime crime){
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);

        mDataBase.update(CrimeTable.NAME, values,
                CrimeTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    // Picking up a crime from the DB

    public List<Crime> getCrimes(){
        List<Crime> crimes = new ArrayList<>();
        CrimeCursorWrapper cursor = queryCrimes(null, null);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return crimes;
    }

    private static ContentValues getContentValues(Crime crime){
        ContentValues values = new ContentValues();
        values.put(CrimeTable.Cols.UUID, crime.getId().toString());
        values.put(CrimeTable.Cols.TITLE, crime.getTitle());
        values.put(CrimeTable.Cols.DATE, crime.getDate().getTime());
        values.put(CrimeTable.Cols.SOLVED, crime.isSolved() ? 1 : 0);
        values.put(CrimeTable.Cols.SUSPECT, crime.getSuspect());

        return values;
    }

    // Querying for Crimes

    private CrimeCursorWrapper queryCrimes (String whereClause, String[] whereArgs){
        Cursor cursor = mDataBase.query(
                CrimeTable.NAME,
                null, // Colums - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );

        return new CrimeCursorWrapper(cursor);
    }

    public Crime getCrime (UUID id){
        CrimeCursorWrapper cursor = queryCrimes(
                CrimeTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );

        try{
            if(cursor.getCount() == 0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getCrime();
        } finally {
            cursor.close();
        }
    }

    // getPhotoFile
    // It return File objects that point to the right locations

    public File getPhotoFile(Crime crime){
        File externalFilesDir = mContext
                .getExternalFilesDir( Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null){
            return null;
        }
        return new File(externalFilesDir, crime.getPhotoFilename());
    }

}
