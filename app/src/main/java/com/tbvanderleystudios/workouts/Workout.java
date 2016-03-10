package com.tbvanderleystudios.workouts;

public class Workout {
    private String mName;
    private String mDescription;

    private Workout(String name, String description) {
        mName = name;
        mDescription = description;
    }

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener", "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony", "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special", "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and Length", "500 Meter run\n21 x 1.5 pood kettleball swing\n21 x Pull-ups")
    };

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String toString() {
        return mName;
    }
}
