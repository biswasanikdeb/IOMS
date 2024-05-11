package com.newcommon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Exception;

public class DataManagement {
    private String data[];

    public void addData(String data1, String data2, File newFile) { // add data to file by tab and new line) {

        try {
            newFile.createNewFile();
            FileWriter writer = new FileWriter(newFile, true);
            writer.write(data1 + "\t" + data2 + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] readData(File newFile, Scanner sc) { // reads data by line, has to use in a loop

        try {

            String tempData = sc.nextLine();
            data = tempData.split("\t");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void modifyData(String newData, String OldData, File Datafile, Scanner sc) throws IOException {
        File tmpfile = new File("./tempfile.txt");
        FileWriter writer = new FileWriter(tmpfile);

        while (sc.hasNextLine()) {
            data = readData(Datafile, sc);
            if (data[0].equals(OldData)) {
                data[0] = newData;
            }
            if (data[1].equals(OldData)) {
                data[1] = newData;
            }
            addData(data[0], data[1], tmpfile);
        }
        sc.close();
        writer.close();
        Datafile.delete();
        tmpfile.renameTo(Datafile);

    }

}
