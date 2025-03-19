package ProjectTaskManagement;

import java.util.ArrayList;
import java.util.List;

public class TeamMember implements Observer{
    private String name;
    private String role;
    private String email;
    private List<Task> assignedTasks;

    public TeamMember(String name, String role, String email){
        this.name = name;
        this.role = role;
        this.email = email;
        this.assignedTasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void assignTask(Task task){
        if(!assignedTasks.contains(task)){
            assignedTasks.add(task);
            task.setAssignee(this);
            task.registerObserver(this);
        }
    }

    @Override
    public void update(Task task) {
        System.out.println("Team member " + name + " received notification: Task #"
                + task.getId() + "(" + task.getTitle() + ") is updated: " + task.getStatus());
    }
}
