public class ProjectTest {
    public static void main(String[] args){
        Project project = new Project();
        project.projectIntro();

        Project project2 = new Project("Ernest");
        project2.projectIntro();
        
        Project project3 = new Project("Ernest", "chat box");
        project3.projectIntro();
        
        Project project4 = new Project();
        String elevatorPitch = project4.elevatorPitch("Ernest", "Chatbox");
        System.out.println(elevatorPitch);
        
    }
}