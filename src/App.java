import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Customer> cusList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loginChoice;
        do {
            System.out.println("\n*************** Welcome To ToDo List Application ***************");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Select Login Option : ");
            loginChoice = in.nextInt();
            switch (loginChoice) {
                case 1: // Admin Login
                    System.out.print("Enter Username : ");
                    String userName = in.next();
                    System.out.print("Enter Password : ");
                    String password = in.next();
                    if (userName.equals("Admin") && password.equals("Admin@123")) {
                        System.out.println("\nAdmin Login Successful");
                        int adminChoice;
                        do {
                            System.out.println("\n========== ADMIN MENU ==========");
                            System.out.println("1. Add Customer");
                            System.out.println("2. Delete Customer");
                            System.out.println("3. Edit Customer");
                            System.out.println("4. View Customer");
                            System.out.println("5. View All Customers");
                            System.out.println("6. Exit");
                            System.out.print("Enter Choice : ");
                            adminChoice = in.nextInt();
                            switch (adminChoice) {
                                case 1: // Add Customer
                                    Customer c = new Customer();
                                    System.out.print("Enter Customer ID : ");
                                    int id = in.nextInt();
                                    in.nextLine();
                                    System.out.print("Enter Customer Name : ");
                                    String name = in.nextLine();
                                    System.out.print("Enter Username : ");
                                    String username = in.nextLine();
                                    System.out.print("Enter Password : ");
                                    String cusPassword = in.nextLine();
                                    c.setId(id);
                                    c.setName(name);
                                    c.setUsername(username);
                                    c.setPassword(cusPassword);
                                    cusList.add(c);
                                    System.out.println("Customer Added Successfully.");
                                    break;
                                case 2: // Delete Customer
                                    System.out.print("Enter Customer ID to Delete : ");
                                    int dcid = in.nextInt();
                                    boolean deleted = false;
                                    for (int i = 0; i < cusList.size(); i++) {
                                        if (cusList.get(i).getId() == dcid) {
                                            cusList.remove(i);
                                            deleted = true;
                                            System.out.println("Customer Deleted Successfully.");
                                            break;
                                        }
                                    }
                                    if (!deleted) {
                                        System.out.println("Customer Not Found.");
                                    }
                                    break;
                                case 3: // Edit Customer
                                    System.out.print("Enter Customer ID to Edit : ");
                                    int ecid = in.nextInt();
                                    boolean found = false;
                                    for (Customer customer : cusList) {
                                        if (customer.getId() == ecid) {
                                            found = true;
                                            System.out.println("1. Edit Name");
                                            System.out.println("2. Edit Username");
                                            System.out.println("3. Edit Password");
                                            int editChoice = in.nextInt();
                                            in.nextLine();
                                            switch (editChoice) {
                                                case 1: // Edit name
                                                    System.out.print("Enter New Name : ");
                                                    customer.setName(in.nextLine());
                                                    break;
                                                case 2: // Edit UserName
                                                    System.out.print("Enter New Username : ");
                                                    customer.setUsername(in.nextLine());
                                                    break;
                                                case 3: // Edit Password
                                                    System.out.print("Enter New Password : ");
                                                    customer.setPassword(in.nextLine());
                                                    break;
                                                default:
                                                    System.out.println("Invalid Choice.");
                                            }
                                            System.out.println("Customer Updated Successfully.");
                                            break;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Customer Not Found.");
                                    }
                                    break;
                                case 4: // View Customer
                                    System.out.print("Enter Customer ID : ");
                                    int vcid = in.nextInt();
                                    boolean exist = false;
                                    for (Customer customer : cusList) {
                                        if (customer.getId() == vcid) {
                                            System.out.println(customer);
                                            exist = true;
                                            break;
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("Customer Not Found.");
                                    }
                                    break;
                                case 5: // View All Customers
                                    if (cusList.isEmpty()) {
                                        System.out.println("No Customers Available.");
                                    } else {
                                        for (Customer customer : cusList) {
                                            System.out.println(customer);
                                            System.out.println("----------------------------");
                                        }
                                    }
                                    break;
                                case 6: // Exit
                                    System.out.println("Exiting Admin Menu...");
                                    break;
                                default:
                                    System.out.println("Invalid Choice.");
                            }
                        } while (adminChoice != 6);
                    } else {
                        System.out.println("Invalid Username or Password.");
                    }
                    break;
                case 2: // Customer Login
                    System.out.print("Enter Username : ");
                    String uname = in.next();

                    System.out.print("Enter Password : ");
                    String pass = in.next();

                    Customer loggedCustomer = null;

                    for (Customer customer : cusList) {

                        if (customer.getUsername().equals(uname)
                                && customer.getPassword().equals(pass)) {

                            loggedCustomer = customer;
                            break;
                        }
                    }

                    if (loggedCustomer == null) {

                        System.out.println("Invalid Username or Password.");
                        break;
                    }

                    System.out.println("Customer Login Successful");

                    int customerChoice;

                    do {

                        System.out.println("\n========== CUSTOMER MENU ==========");
                        System.out.println("1. Add Task");
                        System.out.println("2. View Tasks");
                        System.out.println("3. Update Task");
                        System.out.println("4. Mark Task Completed");
                        System.out.println("5. Delete Task");
                        System.out.println("6. Logout");

                        System.out.print("Enter Choice : ");
                        customerChoice = in.nextInt();

                        switch (customerChoice) {
                            case 1:// Add Task
                                Task task = new Task();
                                System.out.print("Enter Task ID : ");
                                task.setTaskId(in.nextInt());
                                in.nextLine();
                                System.out.print("Enter Task Name : ");
                                task.setTaskName(in.nextLine());
                                task.setCompleted(false);
                                loggedCustomer.getTaskList().add(task);
                                System.out.println("Task Added Successfully.");
                                break;

                            case 2:// View Tasks
                                if (loggedCustomer.getTaskList().isEmpty()) {
                                    System.out.println("No Tasks.");
                                } else {
                                    for (Task t : loggedCustomer.getTaskList()) {
                                        System.out.println(t);
                                        System.out.println("------------------");
                                    }
                                }
                                break;

                            case 3:// Update Task
                                System.out.print("Enter Task ID to Update : ");
                                int utid = in.nextInt();
                                in.nextLine();
                                boolean taskFound = false;
                                for (Task t : loggedCustomer.getTaskList()) {
                                    if (t.getTaskId() == utid) {
                                        taskFound = true;
                                        System.out.println("Current Task : " + t.getTaskName());
                                        System.out.print("Enter New Task Name : ");
                                        String newTask = in.nextLine();
                                        t.setTaskName(newTask);
                                        System.out.println("Task Updated Successfully.");
                                        break;
                                    }
                                }
                                if (!taskFound) {
                                    System.out.println("Task Not Found.");
                                }
                                break;

                            case 4:// Mark Completed
                                System.out.print("Enter Task ID : ");
                                int ctid = in.nextInt();
                                in.nextLine();
                                boolean completed = false;
                                for (Task t : loggedCustomer.getTaskList()) {
                                    if (t.getTaskId() == ctid) {
                                        t.setCompleted(true);
                                        System.out.println("Task Marked as Completed.");
                                        completed = true;
                                        break;
                                    }
                                }
                                if (!completed) {
                                    System.out.println("Task Not Found.");
                                }
                                break;

                            case 5:// Delete Task
                                System.out.print("Enter Task ID : ");
                                int deleteId = in.nextInt();
                                in.nextLine();
                                boolean removed = false;
                                for (int i = 0; i < loggedCustomer.getTaskList().size(); i++) {
                                    if (loggedCustomer.getTaskList().get(i).getTaskId() == deleteId) {
                                        loggedCustomer.getTaskList().remove(i);
                                        System.out.println("Task Deleted Successfully.");
                                        removed = true;
                                        break;
                                    }
                                }
                                if (!removed) {
                                    System.out.println("Task Not Found.");
                                }
                                break;
                            case 6:
                                System.out.println("Logged Out");
                                break;

                            default:
                                System.out.println("Invalid Choice");
                        }

                    } while (customerChoice != 6);

                    break;
                case 3: // Exit
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Login Choice.");
            }
        } while (loginChoice != 3);
        in.close();
    }
}