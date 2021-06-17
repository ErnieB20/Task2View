package com.skyblue;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test2 {

    public static void writeDataLineByLine(String filePath) {
        File file = new File(filePath);
        System.out.println("file path"+file);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            Random rand = new Random();
            String[] arr = {"M", "F"};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            // adding header to csv
            // create a List which contains String array
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[]{"Id", "LastName", "First Name", "Gender", "Dob", "Address"});
            for (int i = 0; i < 100; i++) {
                int id = rand.nextInt(2000 - 1000 + 1) + 1000;
                int dob = rand.nextInt(2010 - 1950 + 1) + 1950;

                data.add(new String[]{Integer.toString(id), "Last Name", "First Name", arr[select], Integer.toString(dob), "Address"});
            }
            writer.writeAll(data);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void copyFile() throws IOException {
        File original = new File(System.getProperty("user.dir")+"/TaskCompleted2/locationA/File1.csv");
        File copied = new File(System.getProperty("user.dir")+"/TaskCompleted2/locationB/File2.csv");
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(original));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(copied))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
        System.out.println("File copied successfully.......");

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String filepath = System.getProperty("user.dir");
        System.out.println("user dire"+System.getProperty("user.dir"));
        writeDataLineByLine(filepath+"/TaskCompleted2/locationA/File1.csv");
        copyFile();

    }
}
