package com.wy.dataStructure._00TestUtil;

/**
 * 名称: JavaDataStructure.com.wy.dataStructure._00TestUtil.TestTimeUtil
 * 用户: _VIEW
 * 时间: 2019/8/6,21:23
 * 描述: 粗略计算程序执行所需时间
 */
public class TestTimeUtil {
    public static float getRunTime(Runnable runnable){
        long startTime=System.nanoTime();
        runnable.run();
        long endTime=System.nanoTime();
        return (float) ((endTime-startTime)/1000000000.0);
    }
}
