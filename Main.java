package org.example;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("file.txt");
            writer.append("Иванов Иван Иванович 25 Муж \n");
            writer.append("Воробьев Антон Игоревич 20 Муж \n");
            writer.append("Орлова Татьяна Сергевна 24 Жен \n");
            writer.append("Кот Петр Петрович 45 Муж \n");
            writer.append("Петров Иван Степанович 33 Муж \n");
            writer.flush();
            FileReader reader = new FileReader("file.txt");
            String text = "";
            StringBuilder builder = new StringBuilder();
            ArrayList <Integer> index = new ArrayList<>();
            ArrayList <String> firstName = new ArrayList<>();
            ArrayList <String> lastName = new ArrayList<>();
            ArrayList <String> patronyic = new ArrayList<>();
            ArrayList <Integer> years = new ArrayList<>();
            ArrayList <Boolean> sex = new ArrayList<>();

            while(reader.ready()){
                text = builder.append((char)reader.read()).toString();
            }

            String[] data = text.split("\n");

            for (int i = 0; i < data.length; i++) {
                String[] buff = data[i].split(" ");
                index.add(i);
                firstName.add(buff[0]);
                lastName.add(buff[1]);
                patronyic.add(buff[2]);
                years.add(Integer.parseInt(buff[3]));
                sex.add(buff[4].contains("у"));
                System.out.printf("%s %s.%s. %d %s \n",buff[0],buff[1].charAt(0),buff[2].charAt(0),Integer.parseInt(buff[3]),buff[4].charAt(0));
            }

            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(patronyic);
            System.out.println(sex);
            System.out.println(index);
            System.out.println(years);

            index.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return years.get(o1).compareTo(years.get(o2)); //years.get(o1) == years.get(o2)?0:years.get(o1) > years.get(o2)?1:-1;
                }
            });

            System.out.println(index);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}