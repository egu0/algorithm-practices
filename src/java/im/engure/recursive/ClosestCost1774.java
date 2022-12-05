package im.engure.recursive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 暴力类型题目
 */
public class ClosestCost1774 {

    public static void main(String[] args) {
        System.out.println(new ClosestCost1774().closestCost(new int[]{3, 10}, new int[]{2, 5}, 9));
        System.out.println(new ClosestCost1774().closestCost(new int[]{2, 3}, new int[]{3}, 10));
    }

    private int best = (int) 1e9;
    private int target;

    public int closestCost(int[] b, int[] t, int target) {
        this.target = target;

        for (int j : b) {
            dfs(t, 0, j);
        }
        return best;
    }

    //暴力递归（数据量很小，枚举每个选择就可以）
    private void dfs(int[] arr, int idx, int total) {
        int sign = Math.abs(best - target) - Math.abs(total - target);
        if (sign > 0 || (sign == 0 && total < best)) {
            best = total;
        }

        //剪枝，如果当前的成本已经大于total，没有必要再往后就行选择
        //或者已经遍历完，结束
        if (total >= target || idx == arr.length) {
            return;
        }

        //每个配料可以选0，1，2份
        for (int k = 0; k < 3; k++) {
            dfs(arr, idx + 1, total + arr[idx] * k);
        }

    }

    /***************************** another solution *************************************/

    int[] toppingCosts;
    Set<Integer> set = new HashSet<>();

    /**
     * bruteForce, 66ms -> 33ms -> 25ms（优化分支）
     *
     * @param baseCosts    length m
     * @param toppingCosts length n
     * @param target
     * @return
     */
    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            if (baseCost == target) {
                return target;
            }
        }

        int[] nums = new int[1 + (int) Math.pow(3, toppingCosts.length)];
        this.toppingCosts = toppingCosts;

        // nums[0] record counter
        nums[0] = 1;

        // list all the possibilities of topping combination
        setAll(nums, 0, 0);
        Arrays.sort(nums, 1, nums.length);

        //计算最合适的相对值
        int rel = Integer.MAX_VALUE;

        for (int p1 : baseCosts) {

            //两个极端情况
            int maxTarget = nums[nums.length - 1] + p1;
            int minTarget = nums[1] + p1;

            if (minTarget > target) {
                if (minTarget - target < Math.abs(rel)) {
                    rel = minTarget - target;
                }
                continue;
            } else if (maxTarget < target) {
                if (target - maxTarget < Math.abs(rel)) {
                    rel = maxTarget - target;
                }
                continue;
            }

            //剩下的情况 minTarget <= target <= maxTarget
            for (int j = 1; j < nums.length; j++) {
                int newTarget = p1 + nums[j];
                if (newTarget == target) {
                    return newTarget;
                } else {
                    rel = compareAndReturn(newTarget, rel, target);
                }

                //去除无用的升区间
                if (newTarget > target) {
                    break;
                }
            }
        }

        return rel + target;
    }

    public int compareAndReturn(int newTarget, int oldRel, int target) {
        if (set.contains(newTarget)) {
            return oldRel;
        }
        set.add(newTarget);
        int relative = Math.abs(newTarget - target);
        int r0 = Math.abs(oldRel);
        if (relative < r0) {
            return newTarget - target;
        } else if (r0 == relative && newTarget < target) {
            return newTarget - target;
        } else {
            return oldRel;
        }
    }

    private void setAll(int[] nums, int idx, int sum) {
        if (idx == toppingCosts.length) {
            nums[nums[0]++] = sum;
            return;
        }
        for (int i = 0; i < 3; i++) {
            setAll(nums, idx + 1, sum + toppingCosts[idx] * i);
        }
    }

}





