package com.tbvanderleystudios.workouts;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainter = findViewById(R.id.detailFragmentContainer);

        if(fragmentContainter != null) {

            WorkoutDetailFragment detail = new WorkoutDetailFragment();

            // Open up a Fragment transaction.
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            detail.setWorkoutId(id);
            transaction.replace(R.id.detailFragmentContainer, detail);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

            // Close out the transaction.
            transaction.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}
