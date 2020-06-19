package service.impl;

import intf.IdPopulated;
import model.Id;
import service.bean.IdMeta;
import service.bean.IdType;
import util.TimeUtils;

import java.util.concurrent.locks.ReentrantLock;

public class LockPopulated implements IdPopulated {

    private long sequence = 0;
    private long lastTimestamp = -1;
    private ReentrantLock lock = new ReentrantLock();
    public void populated(Id id, IdMeta idMeta) {
        lock.lock();
        long timestamp = TimeUtils.genTime(IdType.parse(id.getType()));
        TimeUtils.validateTimestamp(lastTimestamp,timestamp);
        if (timestamp == lastTimestamp) {
            sequence++;
            sequence = sequence & idMeta.getSeqBitsMask();
            if (sequence == 0) {
                timestamp = TimeUtils.tillNextTimeUnit(lastTimestamp,IdType.parse(id.getType()));
            }
        } else {
            lastTimestamp = timestamp;
            sequence = 0;
        }
        id.setSequence(sequence);
        id.setTime(timestamp);
        lock.unlock();
    //
    }
}
