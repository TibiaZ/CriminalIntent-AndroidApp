package app.javiersanz.com.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Locale;

/**
 * Created by Usuario on 11/06/2016.
 */
public class CrimeFragment extends Fragment {

    // Variables

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    // onCreate

    @Override
    public void onCreate (Bundle savedInstance){
        super.onCreate(savedInstance);
        mCrime = new Crime();
    }

    // onCreateView
    // It inflates the fragment's view by calling LoyoutInflater

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        // Title Field reference to the EditText and add a listener
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Intentionally left blank
            }
        });

        // Refering dateButton to the widget and getting the current date for it

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        mDateButton.setText(DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH).format(mCrime.getDate()).toString());
        mDateButton.setEnabled(false);

        // Refering mSolvedCheckBox to the widget,
        // We'll add a listener that will update the mSolved field of the Crime

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Set the crime's solved property
                mCrime.setSolved(isChecked);
            }
        });
        return v;






    }
}
