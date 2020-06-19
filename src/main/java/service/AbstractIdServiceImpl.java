package service;

import intf.IdConverted;
import intf.IdService;
import model.Id;

import service.bean.IdType;

import java.util.Date;


public abstract class AbstractIdServiceImpl implements IdService {

    protected long machineId;
    protected long genMethod;
    protected long type;
    protected long version;
    protected IdConverted idConverted;
    protected IdType idType;

    public AbstractIdServiceImpl() {
        idType = IdType.MAX_PEAK;
    }
    public AbstractIdServiceImpl(IdType idType) {
        this.idType = idType;
    }
    public long genId() {
        Id id  = new Id();
        id.setMachineId(machineId);
        id.setGenMethod(genMethod);
        id.setType(type);
        id.setVersion(version);

        populatedId(id);

        long ret = idConverted.convert(id);
        return ret;
    }

    protected abstract void populatedId(Id id);
    public Id parseId(long id) {
        return null;
    }

    public Date transTime(long time) {
        return null;
    }
}
