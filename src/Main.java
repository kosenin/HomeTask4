import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Konstantin2 on 03.04.2018.
 */
public class Main {


    public static void main(String[] args) {

        File file = new File("C:\\");

        File fileTree = new File("C:\\JavaTest", "fileTree.txt");
        try {
            fileTree.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            showFileTree(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(fileTree);

        }
        catch (IOException i)
        {
            System.out.println("Жопа");
        }

    }


    public static void showFileTree(File file) {

        if (!file.isDirectory()) {
            System.out.println(file.getName());
        }

        if (file.isDirectory()) {
            try {
                System.out.println(file.getCanonicalFile());
                File[] child = file.listFiles();

                for (int i = 0; i < child.length; i++) {
                    System.out.println(child[i].getParent());
                    showFileTree(child[i]);
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
