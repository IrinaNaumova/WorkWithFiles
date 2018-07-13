import java.io.*;
import java.util.Scanner;

public class WorkWithFiles {

    public static void main(String[] args) throws IOException {
        InputStream in;
        OutputStream out;

        try {
            readingWithScanner("File1.txt");
            readingWithScanner("File2.txt");
            //readingWithScanner("File4.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Writing failed!");
        }

        String wantedWord1 = "Java ";
        String wantedWord2 = "Cat ";
        try {
            System.out.println("Слово " + wantedWord1 + "содержится в файле: " +  findWordInFile(wantedWord1, "File3.txt"));
            System.out.println("Слово " + wantedWord2 + " содержится в файле: " +  findWordInFile(wantedWord2, "File3.txt"));
            //System.out.println("Слово " + wantedWord2 + " содержится в файле: " +  findWordInFile(wantedWord2, "File5.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    private static void writingFile(String s) throws IOException {
        FileOutputStream fos = new FileOutputStream("File3.txt", true);
        fos.write(s.getBytes());
        fos.close();
    }

    private static void readingWithScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        while (scanner.hasNext()) {
            writingFile(scanner.nextLine());
        }
    }

    private static boolean findWordInFile(String word, String fileName) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        String curLine;
        while (scanner.hasNext()) {
            curLine = scanner.nextLine();
            if (curLine.contains(word)) return true;
        }
        return false;
    }


}
