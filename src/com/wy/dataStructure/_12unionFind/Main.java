package com.wy.dataStructure._12unionFind;

import com.wy.dataStructure._00TestUtil.TestTimeUtil;

import java.util.Random;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._12unionFind.Main
 * 用户: _VIEW
 * 时间: 2019/8/12,0:00
 * 描述: 并查集测试类
 */
public class Main {
    public static void main(String[] args) {
        int size = 10000000;
        int m = 100000000;

        UnionFind_1 unionFind_1 = new UnionFind_1(size);
        UnionFind_2 unionFind_2 = new UnionFind_2(size);
        UnionFind_3 unionFind_3 = new UnionFind_3(size);
        UnionFind_4 unionFind_4 = new UnionFind_4(size);
        UnionFind_5 unionFind_5 = new UnionFind_5(size);
        UnionFind_6 unionFind_6 = new UnionFind_6(size);
        System.out.println("UnionFind_1: " + testUF(unionFind_1, m) + " s");
        System.out.println("UnionFind_2: " + testUF(unionFind_2, m) + " s");
        System.out.println("UnionFind_3: " + testUF(unionFind_3, m) + " s");
        System.out.println("UnionFind_4: " + testUF(unionFind_4, m) + " s");
        System.out.println("UnionFind_5: " + testUF(unionFind_5, m) + " s");
        System.out.println("UnionFind_6: " + testUF(unionFind_6, m) + " s");
    }

    private static double testUF(Union union, int m) {
        int size = union.getSize();
        Random random = new Random();
        Runnable runnable = () -> {
            for (int i = 0; i < m; i++) {
                int a = random.nextInt(size);
                int b = random.nextInt(size);
                union.unionElements(a, b);
            }
            for (int i = 0; i < m; i++) {
                int a = random.nextInt(size);
                int b = random.nextInt(size);
                union.isConnected(a, b);
            }
        };
        return TestTimeUtil.getRunTime(runnable);
    }
}
