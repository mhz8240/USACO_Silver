import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("reststops.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int distance = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int johnSpeed = Integer.parseInt(st.nextToken());
        int trainerSpeed = Integer.parseInt(st.nextToken());
        int speedDifference = johnSpeed - trainerSpeed;
        ArrayList<Rest> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            al.add(new Rest(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())) );

        }
        Collections.sort(al);
        long count = 0;
        int currentDistance = 0;
        for (int i = 0; i < n; i++) {
            if (al.get(i).distance > currentDistance) {
                 count += (long)al.get(i).tastiness * speedDifference * (al.get(i).distance - currentDistance);
                 currentDistance = al.get(i).distance;
            }
        }
        pw.print(count);
        br.close();
        pw.close();
    }
}

class Rest implements Comparable<Rest>{
    public int distance;
    public Integer tastiness;

    public Rest(int distance, int tastiness) {
        this.distance = distance;
        this.tastiness = tastiness;
    }

    @Override
    public int compareTo(Rest o) {
        return tastiness.compareTo(o.tastiness) * -1;
    }
}