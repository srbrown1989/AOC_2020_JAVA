package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        int target = 2020;
        HashMap<Integer, Integer> map = new HashMap<>();
        try {
            File file = new File("./src/Day1/data.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                int num = Integer.parseInt(sc.nextLine());
                for (int key : map.keySet()) {
                    int rem = target - num - key;
                    if (rem > 0 && map.containsKey(rem)) {
                        System.out.println("The three numbers that sum to " + target + " are: " + key + " , " + rem + " and " + num);
                        System.out.println("Answer is : " + num * key * rem);
                        return;
                    }
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
