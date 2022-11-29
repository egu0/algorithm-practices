package im.engure.api;

/**
 * @author Administrator
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[2];
        System.arraycopy(a, 0, b, 0, a.length);
        //System.out.println();

        int mod = 10 ^ 3 + 7;
        System.out.println(mod);
    }
}
