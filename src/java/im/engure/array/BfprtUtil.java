package im.engure.array;

/*

notes/array.md
算法原理：https://www.youtube.com/watch?v=PY7YiJQa3Lc
算法实现：https://zhuanlan.zhihu.com/p/31498036

 */


/**
 * @author engure
 */
public class BfprtUtil {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 6};
        System.out.println(BfprtUtil.bfprt(arr, 0, arr.length - 1, 1));
        System.out.println(BfprtUtil.bfprt(arr, 0, arr.length - 1, 2));
        System.out.println(BfprtUtil.bfprt(arr, 0, arr.length - 1, 3));
        System.out.println(BfprtUtil.bfprt(arr, 0, arr.length - 1, 4));
        System.out.println(BfprtUtil.bfprt(arr, 0, arr.length - 1, 5));
        System.out.println(BfprtUtil.bfprt(arr, 0, arr.length - 1, 6));
        System.out.println(BfprtUtil.bfprt(arr, 0, arr.length - 1, 7));
    }

    /**
     * 计算 a[l...r] 中第 k 小的数
     *
     * @param a array
     * @param l left bound, inclusive
     * @param r right bound, inclusive
     * @param k
     * @return
     */
    static int bfprt(int[] a, int l, int r, int k) {
        if (l > r || k > r - l + 1) {
            throw new RuntimeException("bound exception");
        }

        //寻找中位数的中位数
        int p = findMid(a, l, r);
        int i = partition(a, l, r, p);

        int m = i - l + 1;
        if (m == k) {
            return a[i];
        } else if (m > k) {
            return bfprt(a, l, i - 1, k);
        } else {
            return bfprt(a, i + 1, r, k - m);
        }
    }

    /**
     * 进行划分过程
     */
    static int partition(int[] a, int l, int r, int p) {
        swap(a, p, l);
        int i = l;
        int j = r;
        int pivot = a[l];
        while (i < j) {
            while (a[j] >= pivot && i < j) {
                j--;
            }
            a[i] = a[j];
            while (a[i] <= pivot && i < j) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }

    private static void insertSort(int[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            if (a[i - 1] > a[i]) {
                int t = a[i];
                int j = i;
                while (j > l && a[j - 1] > t) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = t;
            }
        }
    }

    /**
     * 寻找中位数的中位数
     */
    static int findMid(int a[], int l, int r) {
        if (l == r) {
            return l;
        }
        int i = 0;
        int n = 0;
        for (i = l; i < r - 5; i += 5) {
            insertSort(a, i, i + 4);
            n = i - l;
            swap(a, l + n / 5, i + 2);
        }

        //处理剩余元素
        int num = r - i + 1;
        if (num > 0) {
            insertSort(a, i, i + num - 1);
            n = i - l;
            swap(a, l + n / 5, i + num / 2);
        }
        n /= 5;
        if (n == l) {
            return l;
        }
        return findMid(a, l, l + n);
    }

    private static void swap(int[] arr, int t, int i) {
        int k = arr[t];
        arr[t] = arr[i];
        arr[i] = k;
    }
}
