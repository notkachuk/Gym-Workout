package cs3100_final;

public class Exercise {
    private String name;
    private String muscleGroup;
    private int duration; 
    private int sets;
    private int reps;

    // Constructor
    public Exercise(String name, String muscleGroup, int duration, int sets, int reps) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.duration = duration;
        this.sets = sets;
        this.reps = reps;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    // toString method for easy display
    
    public String toString() {
        return name + " (" + muscleGroup + ") - " + sets + " sets of " + reps + " reps, " + duration + " mins.";
    }
}
