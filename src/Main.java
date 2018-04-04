import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Konstantin2 on 03.04.2018.
 */
public class Main {


    public static void main(String[] args) {

        File file = new File("E:\\AndroidSDK");

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



    }


    public static void showFileTree(File file) {

        if (!file.isDirectory()) {


            try {
                FileWriter writer = new FileWriter("E:\\filetree.txt",true);
                writer.write(file.getName());
                writer.append(System.lineSeparator() + " ");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.isDirectory()) {
            try {

                File[] child = file.listFiles();

                for (int i = 0; i < child.length; i++) {
                    FileWriter writer = new FileWriter("E:\\filetree.txt",true);
                    writer.write(file.getName());
                    writer.append(System.lineSeparator());
                    writer.flush();
                    writer.close();
                    showFileTree(child[i]);
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
