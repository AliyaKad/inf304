package ru.itis.inf304.KontrolWork2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogFile {
    public static void main(String[] args) throws Exception {
        int variantNumber = 9;
        File logFile = new File("v9.log");

        try (FileWriter writer = new FileWriter(logFile)) {
            ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            List<File> files = readFiles();

            for (File file : files) {
                executor.execute(new FileRun(file, writer));
            }

            executor.shutdown();
            merge(files);
        }
    }

    private static List<File> readFiles() {
        List<File> files = new ArrayList<>();
        File var = new File("C:\\Users\\HP\\Desktop\\cw2\\v9");

        File[] variantFiles = var.listFiles();
        if (variantFiles != null) {
            for (File file : variantFiles) {
                if (file.isFile()) {
                    files.add(file);
                }
            }
        } else {
            System.out.println("Список пуст");
        }

        return files;
    }

    private static void merge(List<File> files) throws IOException {
        File mergedFile = new File("Itog.txt");
        try (FileWriter writer = new FileWriter(mergedFile)) {
            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                    }
                }
            }
        }
    }
}
