package ru.itis.inf304.KR;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\HP\\IdeaProjects\\lab01\\src\\main\\java\\ru\\itis\\inf304\\KR\\schedule.txt"));
        List<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();


        System.out.println(Arrays.toString(list.toArray()));
        Map<String, List<Program>> l1 = new HashMap<>();
        String currentChanel = null;
        List<Program> l2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).charAt(0) == '#') {
                String currentChannel = list.get(i);
                i++;
                while (list.get(i).charAt(0) != '#'){
                    Program currentProgram = new Program(currentChannel, new BroadcastsTime(list.get(i)), list.get(i + 1));
                    l2.add(currentProgram);
                    if (l1.containsKey(currentChannel)){
                        l1.get(currentChannel).add(currentProgram);
                    }
                    else{
                        l1.put(currentChannel, new ArrayList<>(List.of(currentProgram)));
                    }
                    i = i + 2;
                    if (i >= list.size()){
                        break;
                    }
                }
                i = i - 1;
            }
        }
    }
}
