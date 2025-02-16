package im.engure.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 1*1=1      ... 1
 * 9*9=81     ... 8+1
 * 10*10=100  ... 10+0
 * 36*36=1296 ... 1+29+6
 */

public class PunishmentNumber2698 {

    public static void main(String[] args) {
        PunishmentNumber2698 o = new PunishmentNumber2698();
        int n = 1000;
        for (int i = 1; i <= n; i++) {
            List<List<String>> papa = o.partitions(String.valueOf(i * i), 0, i);
//            System.out.printf("%d -> %s\n", i * i, papa);
            for (List<String> pa : papa) {
                int sum = 0;
                for (String p : pa) {
                    sum += Integer.parseInt(p);
                }
                if (i == sum) {
//                    System.out.printf("hit: %d * %d = %d ... %s\n", i, i, i * i, pa);
                    break;
                }
            }
        }
    }

    // 复杂度：较高
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            List<List<String>> papa = partitions(String.valueOf(i * i), 0, i);
//            System.out.printf("%d -> partitions: %s\n", i, papa);
            for (List<String> pa : papa) {
                int sum = 0;
                for (String p : pa) {
                    sum += Integer.parseInt(p);
                }
                if (i == sum) {
//                    System.out.printf("hit: %d * %d = %d ... %s\n", i, i, i * i, pa);
                    res += (i * i);
                    break;
                }
            }
        }
        return res;
    }

    public List<List<String>> partitions(String num, int idx, Integer baseValue) {
        if (idx == num.length() - 1) {
            return List.of(List.of(String.valueOf(num.charAt(idx))));
        }

        List<List<String>> res = new ArrayList<>();
        String s = String.valueOf(num.charAt(idx));

        List<List<String>> papa = partitions(num, idx + 1, baseValue);
        for (List<String> pa : papa) {
            String first = pa.getFirst();
            ArrayList<String> s1 = new ArrayList<>(pa);
            s1.addFirst(s);
            res.add(s1);

            ArrayList<String> s2 = new ArrayList<>(pa);
            String ff = s + first;
            // 剪枝
            if (Integer.parseInt(ff) <= baseValue) {
                s2.set(0, ff);
                res.add(s2);
            }
        }
        return res;
    }
}
