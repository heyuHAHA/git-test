package service.bean;

public class IdMetaFactory {
    private static IdMeta maxPeak =new IdMeta((byte) 10, (byte) 20, (byte) 30, (byte) 2, (byte) 1, (byte) 1);
    private static IdMeta minGranularity = new IdMeta((byte) 10, (byte) 10, (byte) 40, (byte) 2, (byte) 1, (byte) 1);

    public static IdMeta getIdMeta(IdType idtype) {
        if (IdType.MAX_PEAK.equals(idtype)) {
            return maxPeak;
        } else if (IdType.MIN_GRANULARITY.equals(idtype)) {
            return minGranularity;
        }
        return null;
    }
}
