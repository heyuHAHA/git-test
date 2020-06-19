package service.bean;

public enum IdType {
    MAX_PEAK("max_peak"),MIN_GRANULARITY("min_granularity");

    private String name;

    private IdType(String name) {
        this.name = name;
    }

    private  long value() {
        switch (this) {
            case MAX_PEAK:
                return 0;
            case MIN_GRANULARITY:
                return 1;
                default:return 0;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static IdType parse(String name) {
        if ("min_granularity".equals(name)) {
            return MIN_GRANULARITY;
        } else if ("max_peak".equals(name)) {
            return MAX_PEAK;
        }
        return null;

    }

    public static IdType parse(long type) {
        if (type == 0) {
            return MAX_PEAK;
        } else if (type == 1) {
            return MIN_GRANULARITY;
        }
        return null;
    }
}
