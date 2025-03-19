package ProjectTaskManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private String name;
    private Map<String, Task> tasks;
    private List<TeamMember> teamMembers;
    private ProjectManager projectManager;

    public Project(String name, ProjectManager manager) {
        this.name = name;
        this.tasks = new HashMap<>();
        this.teamMembers = new ArrayList<>();
        this.projectManager = manager;
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
        task.registerObserver(projectManager);
    }

    public void addTeamMember(TeamMember member){
        teamMembers.add(member);
    }

    public Task getTask(String taskId){
        return tasks.get(taskId);
    }

    public List<TeamMember> getTeamMembers(){
        return new ArrayList<>(teamMembers);
    }
    public void updateTaskStatus(String taskId, TaskStatus newStatus) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setStatus(newStatus);
        } else {
            System.out.println("Không tìm thấy task với ID: " + taskId);
        }
    }

    public void assignTaskToMember(String taskId, TeamMember member) {
        Task task = tasks.get(taskId);
        if (task != null) {
            member.assignTask(task);
        } else {
            System.out.println("Không tìm thấy task với ID: " + taskId);
        }
    }
}
