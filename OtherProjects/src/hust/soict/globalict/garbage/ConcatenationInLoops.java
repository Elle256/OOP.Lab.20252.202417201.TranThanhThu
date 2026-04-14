package src.hust.soict.globalict.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {

        int n = 65536;
        Random r = new Random(123);

        // 1. String (+)
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += r.nextInt(2);
        }
        long end = System.currentTimeMillis();
        System.out.println("String time: " + (end - start) + " ms");

        // 2. StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(r.nextInt(2));
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        // 3. StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(r.nextInt(2));
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}