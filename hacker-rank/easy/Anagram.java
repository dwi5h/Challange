import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        if(s.length() % 2 > 0) {
            return -1;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        int mid = s.length() / 2;
        String s1 = s.substring(0, mid);
        String s2 = s.substring(mid, s.length());

        for(char c : s2.toCharArray()) {
            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
        }

        int anagram = 0;
        for(char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
            if(s2Map.containsKey(c) && s1Map.get(c) > s2Map.get(c)) {
                anagram++;
            }
            else if(!s2Map.containsKey(c)) {
                anagram++;
            }
        }

        return anagram;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

// https://www.hackerrank.com/challenges/anagram