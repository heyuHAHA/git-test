package util;

import service.bean.IdType;

public class TimeUtils {
    private static final long EPOCH = 1420041600000L;

    public static void validateTimestamp(long lastTimestamp, long timestamp) {
        //如果本时间戳小于上次时间戳，则报错
        if (timestamp < lastTimestamp) {
            throw new IllegalStateException(
                    String.format(
                            "Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                            lastTimestamp - timestamp));

        }
    }

    public static long tillNextTimeUnit(final long lastTimestamp, final IdType idType) {
        long timestamp = TimeUtils.genTime(idType);
        while (lastTimestamp >= timestamp) {
            timestamp = TimeUtils.genTime(idType);
        }
        return timestamp;
    }

    public static long genTime(final IdType idType) {
        if (idType == IdType.MAX_PEAK) {
            return (System.currentTimeMillis() - TimeUtils.EPOCH) / 1000;
        } else if (idType == IdType.MIN_GRANULARITY) {
            return (System.currentTimeMillis() - TimeUtils.EPOCH);
        }
        return (System.currentTimeMillis() - TimeUtils.EPOCH) / 1000;
    }
}
