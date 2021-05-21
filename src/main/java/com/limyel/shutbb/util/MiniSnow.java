package com.limyel.shutbb.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MiniSnow {
    private long currentTs;
    private int currentNum;
    private final long[] NUMS = new long[]{1, 2, 3, 4};
    private Random random = new Random();

    public MiniSnow() {
        currentTs = System.currentTimeMillis() / 1000;
        currentNum = 0;
    }

    private long getRangeNum() {
        return NUMS[random.nextInt(NUMS.length)];
    }

    public long nextId() {
        long tmpTs = System.currentTimeMillis() / 1000;
        if (tmpTs == currentTs) {           // 如果同一秒钟，则计数加一
            currentNum += 1;
        } else {
            currentTs = tmpTs;
            currentNum = 1;
        }

        return (getRangeNum() << 41) | (currentTs << 10) | (currentNum);
    }
}
