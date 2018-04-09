import java.io.*;

import static java.lang.Thread.State.*;

/**
 * Created by Konstantin2 on 03.04.2018.
 */
public class Main {


    public static void main(String[] args) {

        File file = new File("C:\\dell");
        File file2 = new File("C:\\filetree.txt");





        Thread writeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                writeFileTree(file);
            }
        });

        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                readFileTree(file2);

            }
        });

        writeThread.start();
       if (writeThread.getState()==RUNNABLE)
           readThread.start();


    }


    public synchronized static void writeFileTree(File file) {


        try {


            if (file.isDirectory())

            {
                File child[] = file.listFiles();

                for (int i = 0; i < child.length; i++) {

                    int numberOfSpaces = 0;


                    FileWriter writer = new FileWriter("c:\\filetree.txt", true);

                    String space = child[i].getAbsolutePath();

                    for (char c : space.toCharArray()) {
                        if (c == '\\')
                            numberOfSpaces++;
                    }


                    writer.write(spaces(numberOfSpaces) + child[i].getAbsolutePath() + System.lineSeparator());
                    writer.flush();
                    writer.close();


                    writeFileTree(child[i]);

                }


            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    public synchronized static void readFileTree(File file) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.lines().iterator().hasNext()) {
                String s = reader.readLine();
                System.out.println(s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String spaces(int numberOfSpaces) {
        String spaces = "";


        for (int i = 0; i < numberOfSpaces; i++) {
            spaces += " ";

        }

        return spaces;
    }

}



