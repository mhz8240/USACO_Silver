import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mountains.out"));
        int n = Integer.parseInt(br.readLine());
        Mountain[] mA = new Mountain[n];
        for (int i = 0; i < mA.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mA[i] = new Mountain(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(mA);
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (mA[j].y - mA[i].y >= Math.abs(mA[j].x - mA[i].x)) {
                    count--;
                    break;
                }
            }
        }
        pw.print(count);
        br.close();
        pw.close();
    }
}

class Mountain implements Comparable<Mountain> {
    public int x;
    public int y;

    public Mountain(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Mountain m) {
//        if (this.y < m.y) {
//            return 1;
//        }
//        else if (this.y > (m).y) {
//            return -1;
//        }
//        else {
//            return 0;
//        }
        return ((Integer)this.y).compareTo( (Integer)m.y ) * -1;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}