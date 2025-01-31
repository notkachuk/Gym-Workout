package cs3100_final;

import java.util.ArrayList;
import java.util.Comparator;//for sorting
import java.util.Scanner;

public class GymWorkoutApp {
    private ArrayList<Exercise> exercises = new ArrayList<>();

    // to add an exercise
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        System.out.println("Exercise added: " + exercise);
    }

    //  to remove an exercise by name
    public void removeExercise(String name) {
        exercises.removeIf(exercise -> exercise.getName().equalsIgnoreCase(name));
        System.out.println("Exercise removed: " + name);
    }

    //  to modify an exercise
    public void modifyExercise(String name, Exercise updatedExercise) {
        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getName().equalsIgnoreCase(name)) {
                exercises.set(i, updatedExercise);
                System.out.println("Exercise updated: " + updatedExercise);
                return;
            }
        }
        System.out.println("Exercise not found: " + name);
    }

    // to sort exercises by muscle group
    public void sortExercises() {
        exercises.sort(Comparator.comparing(Exercise::getMuscleGroup));
        System.out.println("Exercises sorted by muscle group.");
        printExercises();
    }

    //  to search for exercises by the name's keyword
    public void searchExercise(String keyword) {
        boolean found = false;
        System.out.println("Search results for keyword: " + keyword);
        for (Exercise exercise : exercises) {
            if (exercise.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(exercise);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No exercises found matching the keyword: " + keyword);
        }
    }


    //  to print all exercises
    public void printExercises() {
        System.out.println("Weekly Gym Workout Plan:");
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }

    // Main method for user interaction
    public static void main(String[] args) {
        GymWorkoutApp app = new GymWorkoutApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Gym Workout Tracker!");
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Exercise");
            System.out.println("2. Remove Exercise");
            System.out.println("3. Modify Exercise");
            System.out.println("4. Sort Exercises");
            System.out.println("5. Search Exercise");
            System.out.println("6. Print Exercises");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // move to newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter muscle group: ");
                    String muscleGroup = scanner.nextLine();
                    System.out.print("Enter duration (minutes): ");
                    int duration = scanner.nextInt();
                    System.out.print("Enter sets: ");
                    int sets = scanner.nextInt();
                    System.out.print("Enter reps: ");
                    int reps = scanner.nextInt();
                    app.addExercise(new Exercise(name, muscleGroup, duration, sets, reps));
                    break;

                case 2:
                    System.out.print("Enter name of exercise to remove: ");
                    String removeName = scanner.nextLine();
                    app.removeExercise(removeName);
                    break;

                case 3:
                    System.out.print("Enter name of exercise to modify: ");
                    String modifyName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new muscle group: ");
                    String newMuscleGroup = scanner.nextLine();
                    System.out.print("Enter new duration (minutes): ");
                    int newDuration = scanner.nextInt();
                    System.out.print("Enter new sets: ");
                    int newSets = scanner.nextInt();
                    System.out.print("Enter new reps: ");
                    int newReps = scanner.nextInt();
                    app.modifyExercise(modifyName, new Exercise(newName, newMuscleGroup, newDuration, newSets, newReps));
                    break;

                case 4:
                    app.sortExercises();
                    break;

                case 5:
                    System.out.print("Enter name of exercise to search: ");
                    String searchName = scanner.nextLine();
                    app.searchExercise(searchName);
                    break;

                case 6:
                    app.printExercises();
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting program. Stay fit!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

