package model;

public class Id {
    private long machineId;
    private long sequence;
    private long time;
    private long genMethod;
    private long type;
    private long version;

    public Id(long machineId, long sequence, long time, long genMethod, long type, long version) {
        this.machineId = machineId;
        this.sequence = sequence;
        this.time = time;
        this.genMethod = genMethod;
        this.type = type;
        this.version = version;
    }

    public Id() {
    }

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getGenMethod() {
        return genMethod;
    }

    public void setGenMethod(long genMethod) {
        this.genMethod = genMethod;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Id{" +
                "machineId=" + machineId +
                ", sequence=" + sequence +
                ", time=" + time +
                ", genMethod=" + genMethod +
                ", type=" + type +
                ", version=" + version +
                '}';
    }
}
