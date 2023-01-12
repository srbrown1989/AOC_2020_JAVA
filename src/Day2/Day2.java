package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        try {
            File file = new File("./src/Day2/data.txt");
            Scanner sc = new Scanner(file);

            int count = 0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(":");
                String[] parts1 = parts[0].split("[- ]");
                int min = Integer.parseInt(parts1[0]);
                int max = Integer.parseInt(parts1[1]);
                String ch = parts1[2];
                String str = parts[1];
                //PART 1
//                int occurrences = str.length() - str.replace(""+ch, "").length();
//                if(occurrences >= min && occurrences <= max){
//                    count++;
//                }
                //Part 2
                //using XOR as ch should only be either in position min or position max, not both and not none.
                if(str.charAt(min) == ch.charAt(0) ^ str.charAt(max) == ch.charAt(0)){
                    count++;
                }
            }
            System.out.println("The number of lines that meet the condition is: " + count);

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
