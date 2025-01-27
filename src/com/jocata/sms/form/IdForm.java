package com.jocata.sms.form;

import java.io.*;

public class IdForm implements Serializable {
    private static Long uniqueId = loadCounter();
    private String id;

    public IdForm() {
        this.id = generatingId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String generatingId(){
        uniqueId++;
        saveCounter(uniqueId);
        return "ID"+uniqueId;
    }

    private static long loadCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\GfgBackend\\SMS\\IdFile.txt"))) {
            return Long.parseLong(reader.readLine());
        } catch (Exception e) {
                System.err.println("Error reading IdFile.txt: " + e.getMessage());
        }
        return 87876;
    }

    private static void saveCounter(long counter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("IdFile.txt"))) {
            writer.write(Long.toString(counter));
        } catch (IOException e) {
            System.err.println("Error writing to IdFile.txt: " + e.getMessage());
        }
    }
}

