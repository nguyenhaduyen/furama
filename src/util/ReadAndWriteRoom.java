package util;

import models.facility.Room;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteRoom {
    public static Map<Room, Integer> readFileRoom(String path) {
        Map<Room, Integer> roomMap = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null) {
                String [] arr = line.split(",");
                roomMap.put(new Room((arr[0]),Double.parseDouble(arr[1]),Double.parseDouble(arr[2]),Integer.parseInt(arr[3]),
                        arr[4],arr[5],arr[6]),Integer.parseInt(arr[7]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomMap;
    }
    public static void writeFileRoom (String path, Map<Room,Integer> roomMap,boolean append) {
        File file = new File (path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Room> roomSet = roomMap.keySet();
            for (Room r: roomSet) {
                bufferedWriter.write(r.getInfoToCSVRoom()+","+roomMap.get(r));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
