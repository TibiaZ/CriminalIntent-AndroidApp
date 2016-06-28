package app.javiersanz.com.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.javiersanz.com.criminalintent.CrimeDbSchema.CrimeTable;

/**
 * Created by TibiaZ on 26/06/2016.
 */
public class CrimeBaseHelper extends SQLiteOpenHelper{

    // Variables

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    // Constructor

    public CrimeBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    // onCreate

    @Override
    public void onCreate(SQLiteDatabase db){

        // Creating the DataBase

        db.execSQL("CREATE TABLE " + CrimeTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    CrimeTable.Cols.UUID + ", " +
                    CrimeTable.Cols.TITLE + ", " +
                    CrimeTable.Cols.DATE + ", " +
                    CrimeTable.Cols.SOLVED +
                    ");"
        );
    }

    // onUpgrade

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
