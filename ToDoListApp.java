import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Welcome to the To-Do List Application!");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Task
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task due date: ");
                    String dueDate = scanner.nextLine();
                    Task newTask = new Task(title, description, dueDate);
                    taskList.add(newTask);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    // Mark Task as Complete
                    System.out.print("Enter the index of the task to mark as complete: ");
                    int completeIndex = scanner.nextInt();
                    if (completeIndex >= 0 && completeIndex < taskList.size()) {
                        taskList.get(completeIndex).markComplete();
                        System.out.println("Task marked as complete!");
                    } else {
                        System.out.println("Invalid index. Task not found.");
                    }
                    break;
                case 3:
                    // View Tasks
                    if (taskList.isEmpty()) {
                        System.out.println("No tasks in the list.");
                    } else {
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.println("Task " + i + ": " + taskList.get(i));
                        }
                    }
                    break;
                case 4:
                    // Remove Task
                    System.out.print("Enter the index of the task to remove: ");
                    int removeIndex = scanner.nextInt();
                    if (removeIndex >= 0 && removeIndex < taskList.size()) {
                        taskList.remove(removeIndex);
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("Invalid index. Task not found.");
                    }
                    break;
                case 5:
                    // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean isComplete;

    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }

    public void markComplete() {
        isComplete = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Description: " + description + ", Due Date: " + dueDate + ", Status: " + (isComplete ? "Complete" : "Incomplete");
    }
}