package util;

import models.Booking;

import java.io.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndWriteBooking {
    public static Set<Booking> readFileBooking (String path) {
        Set <Booking> bookingSet = new TreeSet<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null) {
                String [] arr = line.split(",");
                bookingSet.add(new Booking(arr[0], LocalDate.parse(arr[1]),LocalDate.parse(arr[2]),arr[3],arr[4],arr[5]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingSet;
    }
    public static void writeFileBooking (String path, Set <Booking> bookingSet, boolean append) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking b: bookingSet) {
                bufferedWriter.write(b.getInfoToCSVBooking());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
