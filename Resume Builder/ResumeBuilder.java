import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ResumeBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Online Resume Builder");
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your contact information: ");
        String contactInfo = scanner.nextLine();

        System.out.print("Enter your education: ");
        String education = scanner.nextLine();

        System.out.print("Enter your work experience: ");
        String workExperience = scanner.nextLine();

        System.out.print("Enter your Technical skills: ");
        String technicalskills = scanner.nextLine();

        System.out.print("Enter your Soft skills: ");
        String softskills = scanner.nextLine();

        System.out.print("Enter your languages: ");
        String language = scanner.nextLine();

        System.out.println("\nGenerating Resume...");
        System.out.println("----------------------------");
        System.out.println("Name: " + fullName);
        System.out.println("Contact: " + contactInfo);
        System.out.println("\nEducation:");
        System.out.println(education);
        System.out.println("\nWork Experience:");
        System.out.println(workExperience);
        System.out.println("\nTechnical skills:");
        System.out.println(technicalskills);
        System.out.println("\nSoft skills:");
        System.out.println(softskills);
        System.out.println("\nLanguages:");
        System.out.println(language);

        System.out.println("----------------------------");

        System.out.println("\nResume Generated!");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?characterEncoding=latin1", "root", "")) {
            String insertQuery = "INSERT INTO resumegenerated  VALUES (?, ?, ?, ?, ?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, contactInfo);
            preparedStatement.setString(3, education);
            preparedStatement.setString(4, workExperience);
            preparedStatement.setString(5, technicalskills);
            preparedStatement.setString(6, softskills);
            preparedStatement.setString(7, language);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
