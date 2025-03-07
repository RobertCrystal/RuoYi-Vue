package com.yjnb.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {

    // 自增序列号，保证在同一毫秒内生成的ID不重复
    private static final AtomicInteger sequence = new AtomicInteger(1);

    // 用于格式化时间戳，去掉'-'和':'，并截取后几位数字
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 生成18位的唯一ID
     * @return 返回生成的18位长整型ID
     */
    public static long generateUniqueId() {
        // 获取当前时间戳，并格式化
        String timestamp = sdf.format(new Date());
        // 截取时间戳的最后部分，确保总长度不会超过18位
        if (timestamp.length() > 14) {
            timestamp = timestamp.substring(timestamp.length() - 14);
        }

        // 获取自增序列号，填充至3位数
        int seq = sequence.getAndIncrement();
        if (seq > 999) { // 如果序列号超过了三位数，则重置
            synchronized (sequence) {
                if (sequence.get() > 999) {
                    sequence.set(1); // 防止多线程环境下同时重置的问题
                }
                seq = sequence.getAndIncrement();
            }
        }
        String sequenceStr = String.format("%03d", seq);

        // 组合时间戳和序列号，确保总共18位
        String uniqueIdStr = timestamp + sequenceStr;
        return Long.parseLong(uniqueIdStr);
    }

    public static void main(String[] args) {
        System.out.println(generateUniqueId());
    }
}