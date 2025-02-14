package im.engure.unclassified;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.resource.ClassPathResource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import im.engure.priorityqueue.MaxEvents1353;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class MaxEvents1353Test {

    static MaxEvents1353 o;

    @BeforeAll
    static void setUp() {
        o = new MaxEvents1353();
    }

    @Test
    void maxEvents100000() {
        // 讀取大數組測試用例
        FileReader fileReader = FileReader.create(new ClassPathResource("1353.json").getFile());
        String json = fileReader.readString();
        JSONArray jsonArr = JSON.parseArray(json);
        Object[] array = jsonArr.toArray();
        int[][] data = new int[100000][];
        int i = 0;
        for (Object item : array) {
            JSONArray ja = ((JSONArray) item);
            List<Integer> l = ja.toJavaList(int.class);
            data[i] = new int[2];
            data[i][0] = l.get(0);
            data[i++][1] = l.get(1);
        }

        // 統計運行時間
        TimeInterval timer = DateUtil.timer();
        Assertions.assertEquals(100000, o.maxEvents(data));
        System.out.println(timer.intervalMs());

        timer.intervalRestart();
        Assertions.assertEquals(100000, o.maxEventsV1(data));
        System.out.println(timer.intervalMs());
    }

    @Test
    void maxEvents1() {
        int[][] arr = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 2}
        };
        Assertions.assertEquals(4, o.maxEvents(arr));
    }

    @Test
    void maxEvents2() {
        int[][] arr = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
        };
        Assertions.assertEquals(3, o.maxEvents(arr));
    }

    @Test
    void maxEvents3() {
        int[][] arr = new int[][]{
                {1, 2},
        };
        Assertions.assertEquals(1, o.maxEvents(arr));
    }

    @Test
    void maxEvents4() {
        int[][] arr = new int[][]{
                {1, 2},
                {1, 2},
                {1, 2},
        };
        Assertions.assertEquals(2, o.maxEvents(arr));
    }

    @Test
    void maxEvents5() {
        int[][] arr = new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        Assertions.assertEquals(4, o.maxEvents(arr));
    }
}