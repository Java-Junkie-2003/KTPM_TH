package ProjectTaskManagement;

public class ProjectTaskDemo {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager("Project Manager", "manager@example.com");

        // Tạo dự án
        Project project = new Project("Phát triển ứng dụng di động", manager);

        TeamMember developer1 = new TeamMember("Trần Văn A", "Developer", "dev1@example.com");
        TeamMember developer2 = new TeamMember("Lê Thị B", "Developer", "dev2@example.com");
        TeamMember tester = new TeamMember("Phạm Văn C", "Tester", "tester@example.com");

        project.addTeamMember(developer1);
        project.addTeamMember(developer2);
        project.addTeamMember(tester);

        Task task1 = new Task(" 1", "Thiết kế giao diện", TaskStatus.TODO);
        Task task2 = new Task(" 2", "Xây dựng API", TaskStatus.TODO);
        Task task3 = new Task(" 3", "Kiểm thử", TaskStatus.TODO);

        project.addTask(task1);
        project.addTask(task2);
        project.addTask(task3);

        System.out.println("\n--- Phân công công việc ---");
        project.assignTaskToMember(" 1", developer1);
        project.assignTaskToMember(" 2", developer2);
        project.assignTaskToMember(" 3", tester);

        System.out.println("\n--- Cập nhật trạng thái công việc ---");
        project.updateTaskStatus(" 1", TaskStatus.IN_PROGRESS);

        System.out.println("\n--- Hoàn thành công việc và chuyển sang kiểm thử ---");
        project.updateTaskStatus(" 1", TaskStatus.REVIEW);

        System.out.println("\n--- Chuyển công việc sang người khác ---");
        project.assignTaskToMember(" 1", developer2);

        System.out.println("\n--- Kiểm thử và hoàn thành công việc ---");
        project.updateTaskStatus(" 1", TaskStatus.TESTING);
        project.updateTaskStatus(" 1", TaskStatus.DONE);
    }
}
