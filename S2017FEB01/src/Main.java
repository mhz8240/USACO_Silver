import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("helpcross.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            al.add(Integer.parseInt(br.readLine()));
        }
        ArrayList<Cow> cowArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            cowArray.add(new Cow(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()) ));
        }
        Collections.sort(al);
        Collections.sort(cowArray);
//        for (Integer i : al) {
//            System.out.println(i);
//        }
//        for (Cow cow : cowArray) {
//            System.out.println(cow);
//        }
//        al.remove((Object)8);
//        for (Integer i : al) {
//            System.out.println(i);
//        }
        int count = 0;
        for (Cow cow : cowArray) {
            for (int i = 0; i < al.size(); i++) {
                if (al.get(i) > cow.c2) {
                    break;
                }
                else {
                    if (al.get(i) >= cow.c1) {
                        al.remove((Object)al.get(i));
                        count++;
                        break;
                    }
                }
            }
        }
        pw.print(count);
        //
        br.close();
        pw.close();
    }
}

class Cow implements Comparable<Cow> {
    public int c1;
    public Integer c2;
//    public Integer difference;

    public Cow(int c1, int c2) {
        this.c1 = c1;
        this.c2 = c2;
//        this.difference = difference;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "c1=" + c1 +
                ", c2=" + c2 +
                '}';
    }


    @Override
    public int compareTo(Cow o) {
        return c2.compareTo(o.c2);
    }
}
