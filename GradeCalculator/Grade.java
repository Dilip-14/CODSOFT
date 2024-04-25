import java.util.Scanner;

public class Grade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int n = scanner.nextInt();

        int totalMarks = 0;

        System.out.println("Enter marks obtained in each subject (out of 100):");
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter marks for subject " + i + ":");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        double Percentage = (double) totalMarks / n;

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + Percentage);

        char grade = calculateGrade(Percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static char calculateGrade(double Percentage) {
        if (Percentage >= 90) {
            return 'A';
        } else if (Percentage >= 80) {
            return 'B';
        } else if (Percentage >= 70) {
            return 'C';
        } else if (Percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
