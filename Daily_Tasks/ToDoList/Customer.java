import java.util.ArrayList;

public class Customer {

    private ArrayList<Task> taskList = new ArrayList<>();

    private int id;
    private String name;
    private String username;
    private String password;

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "=====================================\n" +
                "Customer ID   : " + id + "\n" +
                "Customer Name : " + name + "\n" +
                "Username      : " + username + "\n" +
                "Password      : " + password + "\n" +
                "=====================================";
    }
}