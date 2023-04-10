import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Lab_12_File_Away {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        String fileName;
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        // set the chooser to the current directory
        chooser.setCurrentDirectory(new File("."));

        // show the open file dialog
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            fileName = selectedFile.getName();

            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                System.out.println("Summary Report:");
                System.out.println("File Name: " + fileName);
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Error");
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected!");
        }
    }
}
