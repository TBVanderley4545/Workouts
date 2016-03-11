package com.tbvanderleystudios.workouts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends android.app.Fragment {

    private long mWorkoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Must get a reference to the root view of the fragment.
        View view = getView();
        if(view != null) {
            TextView title = (TextView) view.findViewById(R.id.workoutTitleTextView);
            TextView description = (TextView) view.findViewById(R.id.workoutDescriptionTextView);

            Workout workout = Workout.workouts[(int) mWorkoutId];

            title.setText(workout.getName());
            description.setText(workout.getDescription());
        }
    }

    public void setWorkoutId(long workoutId) {
        mWorkoutId = workoutId;
    }
}
