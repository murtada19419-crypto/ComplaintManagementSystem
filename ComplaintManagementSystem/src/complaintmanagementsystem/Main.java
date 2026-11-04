package complaintmanagementsystem;
import java.util.ArrayList;
import java.util.Scanner;

class Complaint {
    int id;
    String name;
    String category;
    String description;
    String status;

    Complaint(int id, String name, String category,
              String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.status = "Pending";
    }

    void display() {
        System.out.println("------------------------------");
        System.out.println("Complaint ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
    }
}

public class Main {

    static ArrayList<Complaint> complaints =
            new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   COMPLAINT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Complaint");
            System.out.println("2. View All Complaints");
            System.out.println("3. Search Complaint");
            System.out.println("4. Update Complaint Status");
            System.out.println("5. Delete Complaint");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addComplaint();
                    break;

                case 2:
                    viewComplaints();
                    break;

                case 3:
                    searchComplaint();
                    break;

                case 4:
                    updateStatus();
                    break;

                case 5:
                    deleteComplaint();
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    static void addComplaint() {

        System.out.println("\n--- Add New Complaint ---");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        Complaint c = new Complaint(
            nextId++, name, category, description
        );

        complaints.add(c);

        System.out.println(
            "Complaint submitted successfully!");
        System.out.println("Your Complaint ID: " + c.id);
    }

    static void viewComplaints() {

        System.out.println("\n--- All Complaints ---");

        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        for (Complaint c : complaints) {
            c.display();
        }
    }

    static void searchComplaint() {

        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Complaint c : complaints) {
            if (c.id == id) {
                System.out.println("Complaint Found:");
                c.display();
                return;
            }
        }

        System.out.println("Complaint not found.");
    }

    static void updateStatus() {

        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Complaint c : complaints) {

            if (c.id == id) {

                System.out.println("1. Pending");
                System.out.println("2. In Progress");
                System.out.println("3. Resolved");

                System.out.print("Select New Status: ");
                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        c.status = "Pending";
                        break;
                    case 2:
                        c.status = "In Progress";
                        break;
                    case 3:
                        c.status = "Resolved";
                        break;
                    default:
                        System.out.println("Invalid status!");
                        return;
                }

                System.out.println(
                    "Status updated successfully!");
                return;
            }
        }

        System.out.println("Complaint not found.");
    }

    static void deleteComplaint() {

        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Complaint c : complaints) {

            if (c.id == id) {
                complaints.remove(c);
                System.out.println(
                    "Complaint deleted successfully!");
                return;
            }
        }

        System.out.println("Complaint not found.");
    }
}