package com.tbvanderleystudios.workouts;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends android.app.Fragment {

    // Number of seconds displayed on the stopwatch
    private int mMilliseconds = 0;

    // Is the stopwatch running?
    private boolean mRunning;
    private boolean mWasRunning;

    // Set up tags to be reused.
    private String mSavedSecondsTag = "SECONDS";
    private String mRunningTag = "RUNNING";
    private String mWasRunningTag = "WAS RUNNING";

    public StopwatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mMilliseconds = savedInstanceState.getInt(mSavedSecondsTag);
            mRunning = savedInstanceState.getBoolean(mRunningTag);
            mWasRunning = savedInstanceState.getBoolean(mWasRunningTag);

            if(mWasRunning) {
                mRunning = true;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the View for this fragment.
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);

        runTimer(layout);

        return layout;
    }

    @Override
    public void onPause() {
        super.onPause();

        mWasRunning = mRunning;
        mRunning = false;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(mWasRunning) {
            mRunning = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(mSavedSecondsTag, mMilliseconds);
        outState.putBoolean(mRunningTag, mRunning);
        outState.putBoolean(mWasRunningTag, mWasRunning);
    }

    public void onClickStart (View view) {
        mRunning = true;
    }

    public void onClickStop (View view) {
        mRunning = false;
    }

    public void onClickReset(View view) {
        mRunning = false;
        mMilliseconds = 0;
    }

    private void runTimer(View view) {
        final TextView mTimerTextView = (TextView) view.findViewById(R.id.timerTextView);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int minutes = (mMilliseconds / 6000);
                int seconds = (mMilliseconds % 6000) / 100;
                int milliseconds = mMilliseconds % 100;

                String time = String.format("%02d:%02d:%02d", minutes, seconds, milliseconds);
                mTimerTextView.setText(time);
                if (mRunning) {
                    mMilliseconds +=1;
                }

                handler.postDelayed(this, 1);
            }
        });
    }
}
