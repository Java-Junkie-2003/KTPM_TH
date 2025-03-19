package ProjectTaskManagement;

import ProjectTaskManagement.Observer;

import java.util.ArrayList;
import java.util.List;

public class Task implements Subject {
    private String id;
    private String title;
    private TaskStatus status;
    private TeamMember assignee;
    private List<Observer> observers;

    public Task(String id, String title, TaskStatus taskStatus) {
        this.id = id;
        this.title = title;
        this.status = taskStatus;
        this.observers = new ArrayList<>();
    }

    public void setStatus(TaskStatus status) {
        if (this.status != status) {
            TaskStatus oldStatus = this.status;
            this.status = status;
            System.out.println("Task #" + id + "(" + title + ")" + " status changed from " + oldStatus + " to " + status);
            notifyObservers();
        }
    }

    public void setAssignee(TeamMember assignee) {
        TeamMember oldAssignee = this.assignee;
        this.assignee = assignee;
        if (oldAssignee != assignee) {
            System.out.println("Task #" + id + "(" + title + ")" + " assignee changed from " +
                    (oldAssignee != null ? oldAssignee.getName() : "not assign") + " to " + assignee.getName());
            notifyObservers();
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TeamMember getAssignee() {
        return assignee;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
