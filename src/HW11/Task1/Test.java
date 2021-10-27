package HW11.Task1;

import java.io.*;

/*
-Right click on start button -> modify run config -> cli args: [src file] [dest file]
-If copying to unexisting file, after program executing refresh files folder
*/
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("files/" + args[0]));
        File file = new File("files", args[1]);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bf.lines().forEach(x -> {
            try {
                bw.write(x + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bf.close();
        bw.flush();
        bw.close();
    }
}
