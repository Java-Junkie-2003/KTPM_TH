package ProjectTaskManagement;

public class ProjectManager extends TeamMember{
    public ProjectManager(String name,String email) {
        super(name, "Project Manager", email);
    }

    @Override
    public void update(Task task) {
        System.out.println("Notify to PM: " + getName() + " (" + getEmail() + "): Task #" +
                task.getId() + " - " + task.getTitle() +
                " is updated [" + task.getStatus() + "]" +
                (task.getAssignee() != null ? " - Assignee: " + task.getAssignee().getName() : ""));
    }
}
