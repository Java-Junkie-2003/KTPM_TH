package ProjectTaskManagement;

public enum TaskStatus {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    REVIEW("Review"),
    TESTING("Testing"),
    DONE("Done");

    private final String displayName;
    TaskStatus(String displayName) {
        this.displayName = displayName;
    }
}
