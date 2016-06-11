package app.javiersanz.com.criminalintent;

import java.util.UUID;

/**
 * Created by Usuario on 11/06/2016.
 */
public class Crime {

    // Variables

    private UUID mId;
    private String mTitle;

    // Constructor

    public Crime (){
        // Generate unique identifier
        mId = UUID.randomUUID();
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

    
}
