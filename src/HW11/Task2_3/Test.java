package HW11.Task2_3;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/*
-Right click on start button -> modify run config -> cli args: [src file] [dest file]
-If copying to unexisting file, after program executing refresh files folder
*/
public class Test {
    public static void main(String[] args) {
        checkArgsAmount(args);
        checkFileTypes(args);
        File srcFile = new File("files/", args[0]);
        File destFile = new File("files/", args[1]);
        checkFileReadWriteAbility(srcFile, destFile);
        BufferedReader br;
        BufferedWriter bw;
        try {
            br = new BufferedReader(new FileReader(srcFile));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: You try to copy data from an unexisting file");
            return;
        }
        try {
            bw = new BufferedWriter(new FileWriter(destFile));
        } catch (IOException e) {
            System.out.println("ERROR: You are trying to write data into directory");
            return;
        }

        br.lines().forEach(x -> {

            try {
                bw.write(x + "\n");
            } catch (IOException e) {
                System.out.println("Unexpected error occurred");
            }
        });

        try {
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
        }
    }

    private static void checkFileReadWriteAbility(File srcFile, File destFile) {
        if (!srcFile.canRead()) {
            System.out.println("Source file " + srcFile.getName() + " can not be read");
            System.exit(1);
        }
        if (!destFile.canWrite() && destFile.exists()) {
            System.out.println("Destination file " + destFile.getName() + " is read-only");
            System.exit(1);
        }
    }

    private static void checkFileTypes(String[] args) {
        List<String> allowedFileTypes = Arrays.asList("txt", "doc", "docx");
        int allowedFileAmount = (int) Arrays.stream(args)
                .map(x -> x.split("\\.").length == 2 ? x.split("\\.")[1] : null)
                .filter(allowedFileTypes::contains)
                .count();

        if (allowedFileAmount != 2) {
            System.out.println("ERROR: You used inappropriate file type. (.txt, .doc(x) allowed)");
            System.exit(1);
        }
    }

    private static void checkArgsAmount(String[] args) {
        if (args.length != 2) {
            System.out.println("ERROR: Invalid arguments amount. Needed 2, got - " + args.length);
            System.exit(1);
        }
    }
}
