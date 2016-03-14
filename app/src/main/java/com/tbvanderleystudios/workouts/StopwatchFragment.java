package com.tbvanderleystudios.workouts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment {

    // Number of seconds displayed on the stopwatch
    private int mSeconds = 0;

    // Is the stopwatch running?
    private boolean mRunning;
    private boolean mWasRunning;

    // Set up tags to be reused.
    private String mSavedSecondsTag = "SECONDS";
    
    public StopwatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mSeconds = savedInstanceState.getInt(mSavedSecondsTag);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stopwatch, container, false);
    }

}
