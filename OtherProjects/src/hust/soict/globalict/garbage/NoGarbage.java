package src.hust.soict.globalict.garbage;

public class NoGarbage {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("garbage");
        }

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }
}