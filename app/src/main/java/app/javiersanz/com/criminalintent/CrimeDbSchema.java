package app.javiersanz.com.criminalintent;

/**
 * Created by TibiaZ on 26/06/2016.
 * This class will contain the schema of our Database
 */
public class CrimeDbSchema {
    public static final class CrimeTable{

        // Variables -> Table definition
        public static final String NAME = "crimes";

        public static final class Cols{

            // Variables -> Cols' names

            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
            public static final String SUSPECT = "suspect";
        }
    }
}
