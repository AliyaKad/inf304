package ru.itis.inf304.KontrolWork;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\HP\\IdeaProjects\\lab01\\src\\main\\java\\ru\\itis\\inf304\\KontrolWork\\schedule.txt"));
        List<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();

        // вывод считанного файла
        System.out.println(Arrays.toString(list.toArray()));

        // заполнение Map
        Map<String, List<Program>> l1 = new HashMap<>();
        String currentChanel = null;
        List<Program> l2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("#")) {
                currentChanel = list.get(i);
            }
            if (list.get(i).startsWith("1") || list.get(i).startsWith("2") || list.get(i).startsWith("3") || list.get(i).startsWith("4") || list.get(i).startsWith("5") || list.get(i).startsWith("6") || list.get(i).startsWith("6") || list.get(i).startsWith("8") || list.get(i).startsWith("9") || list.get(i).startsWith("0")) {
                String currentTime = list.get(i);
                Program currentProgram = new Program(currentChanel, list.get(i + 1));
                l2.add(currentProgram);
                if (l1.containsKey(currentTime)) {
                    l1.get(currentTime).add(currentProgram);
                } else {
                    l1.put(currentTime, new ArrayList<>(List.of(currentProgram)));
                }
                if (i >= list.size()) {
                    break;
                }
                i++;
            }
        }
    }
    // вывести все программы, которые идут сейчас
    public static void findByTime(String timeNow, Map<String, List<Program>> program) {
        System.out.println(program.get(timeNow));
    }

    //  найти все программы по некоторому названию
    public static  void findByName(String str, List<Program> programs) {
        List<Program> findedProgramms = new ArrayList<>();
        for(Program program: programs){
            if (program.getProgramName().startsWith(str)){
                findedProgramms.add(program);
            }
        }
        System.out.println(Arrays.toString(findedProgramms.toArray()));
    }

    // найти все программы определенного канала, которые идут сейчас
    public static void findByChanelName(String timeNow, String chanel, Map<String, List<Program>> program) {
        List<Program> findedProgramms = new ArrayList<>();
        if (program.get(timeNow).getProgramName() == chanel) {
            findedProgramms.add(program.get(timeNow).getProgramName());
        }
        System.out.println(Arrays.toString(findedProgramms.toArray()));
    }

}
