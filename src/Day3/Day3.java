package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) {
        ArrayList<int[]> params = new ArrayList<>();
        params.add(new int[] {1, 1});
        params.add(new int[] {3, 1});
        params.add(new int[] {5, 1});
        params.add(new int[] {7, 1});
        params.add(new int[] {1, 2});
        int[] results = new int[params.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = solve(params.get(i));
        }
        BigInteger result = Arrays.stream(results).mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();

        System.out.printf("Result part 1: %d", solve(new int[] {3, 1}));
        System.out.printf("\nResult part 2: %d", result);




    }

    /**
     * Solves the number of trees based on the parameters as the route taken by the traversal.
     * @param params configuration parameters for the traversal of the map e.g [1,1] means right 1 down 1
     * @return number of trees encountered while traversing route
     */

    public static int solve(int[] params){
        File file = new File("./src/Day3/data.txt");
        try {
            Scanner sc = new Scanner(file);
            /*
              rather than creating a very large grid containing all locations of trees and free spaces in the puzzle space.
              We can simply use the modulo operator on the length of the map segment. as it repeats infinitely to the right.
              after each movement down can simply move to the next line from the scanner and keep track of the x position( movements to the right)
            */
            int mod = 31;
            int treeCount = 0;
            int currentX = 0;
            sc.nextLine();
            while(sc.hasNextLine()){
                currentX = (currentX + params[0]) % mod;
                String down = sc.nextLine();
                if (params[1] == 2){
                    down = sc.nextLine();
                }
                if (down.charAt(currentX) == '#'){
                    treeCount ++;
                }
            }
            return treeCount;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
