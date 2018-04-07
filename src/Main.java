import java.io.*;

/**
 * Created by Konstantin2 on 03.04.2018.
 */
public class Main {


    public static void main(String[] args) {

        File file = new File("E:\\Downloads");
        File file2 = new File("E:\\filetree.txt");



        String hierarchy = "";


        Thread writeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                writeFileTree(file, hierarchy);
            }
        });

        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                readFileTree(file2);

            }
        });

        writeThread.start();
        readThread.start();



    }


    public synchronized static void writeFileTree(File file, String s) {


        try {


            if (file.isDirectory())

            {
                File child[] = file.listFiles();

                for (int i = 0; i < child.length; i++) {

                    int numberOfSpaces = 0;


                    FileWriter writer = new FileWriter("E:\\filetree.txt", true);
                    writer.write(child[i].getAbsolutePath() + System.lineSeparator());
                    writer.flush();
                    writer.close();
                    writeFileTree(child[i], s);

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


}



