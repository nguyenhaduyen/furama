package util;

import models.facility.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteVilla {
    public static Map<Villa, Integer> readFileVilla(String path) {
        Map<Villa, Integer> villaMap = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                villaMap.put(new Villa(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
                        Integer.parseInt(arr[3]), arr[4], arr[5],arr[6], Double.parseDouble(arr[7]),
                        Integer.parseInt(arr[8])), Integer.parseInt(arr[9]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villaMap;
    }

    public static void writeFileVilla(Map<Villa, Integer> villaMap, String path, boolean append) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Villa> villas = villaMap.keySet();
            for (Villa v : villas) {
                bufferedWriter.write(v.getInfoToCSVVilla()+","+villaMap.get(v));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
