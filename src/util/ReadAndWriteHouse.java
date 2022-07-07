package util;

import models.facility.House;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteHouse {
    public static Map<House,Integer> readFileHouse(String path) {
        Map<House,Integer> houseMap = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line ="";
            while ((line = bufferedReader.readLine())!=null) {
                String [] arr = line.split(",");
                houseMap.put(new House((arr[0]),Double.parseDouble(arr[1]),Double.parseDouble(arr[2]),
                        Integer.parseInt(arr[3]),arr[4],arr[5],arr[6],Integer.parseInt(arr[7])),Integer.parseInt(arr[8]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseMap;
    }
    public static void writeFileHouse(String path, Map<House,Integer> houseMap,boolean append) {
        File file = new File (path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<House> houseSet = houseMap.keySet();
            for (House h: houseSet) {
                bufferedWriter.write(h.getInfoToCSVHouse()+","+houseMap.get(h));
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
