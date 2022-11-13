package im.engure.testpkg;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author engure
 */
public class T2 {
    public static void main(String[] args) {

        //[0] - 元素，[1] - 位置
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        //3,1,2
        queue.add(new int[]{3, 1});
        queue.add(new int[]{1, 2});
        queue.add(new int[]{2, 3});
        System.out.println(queue.peek()[0]);
    }
}
