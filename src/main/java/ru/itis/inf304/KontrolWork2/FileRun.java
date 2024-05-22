package ru.itis.inf304.KontrolWork2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileRun implements Runnable {
    private final File file;
    private final FileWriter writer;

    public FileRun(File file, FileWriter writer) {
        this.file = file;
        this.writer = writer;
    }

    @Override
    public void run() {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file))) {
            int k = inputStream.readInt();
            byte[] bytes = new byte[k];
            inputStream.readFully(bytes);
            String s = new String(bytes, StandardCharsets.UTF_8);
            int d = inputStream.readInt();
            int p = inputStream.readInt();
            if (s.length() != d) {
                writer.write("количество символов в строке не совпадает с контрольным числом");
                return;
            }
            writer.write("Прочитали файл " + file.getName() + " кол-во байт данных: " + k + ", кол-во считанных символов: " + s.length() + ", контрольное число: " + d + ", номер части: " + p);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
