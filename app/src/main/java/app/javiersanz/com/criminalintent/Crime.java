package app.javiersanz.com.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Usuario on 11/06/2016.
 */
public class Crime {

    // Variables

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;

    // Constructor

    public Crime (){
        // Generate unique identifier
        this(UUID.randomUUID());
    }

    // Constructor 2

    public Crime (UUID id){
        mId = id;
        mDate = new Date();
    }

    // Getters and setters

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }
}
