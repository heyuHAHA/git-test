package service.IdConverter;

import model.Id;
import service.bean.IdMeta;
import service.bean.IdMetaFactory;
import service.bean.IdType;

public class IdConverterImpl implements IdConverter {

    private IdMeta idMeta;

    public IdConverterImpl() {
    }

    public IdConverterImpl(IdType idType) {
        this(IdMetaFactory.getIdMeta(idType));
    }
    public IdConverterImpl(IdMeta idMeta) {
        this.idMeta = idMeta;
    }

    public long convert(Id id) {
        return doConvert(id,idMeta);
    }

    private long doConvert(Id id, IdMeta idMeta) {
        long ret = 0L;
        ret |= id.getMachineId();
        ret |= id.getSequence() << idMeta.getSeqBitsStartPos();
        ret |= id.getTime() << idMeta.getTimeBitsStartPos();
        ret |= id.getGenMethod() << idMeta.getGenMethodBitsStartPos();
        ret |= id.getType() << idMeta.getTypeBitsStartPos();
        ret |= id.getVersion() << idMeta.getVersionBitsStartPos();
        return ret;
    }

    public Id convert(long id) {
        return doConvert(id,idMeta);
    }

    private Id doConvert(long id,IdMeta idMeta) {
        Id ret = new Id();
        ret.setMachineId(id & idMeta.getMachineBitsMask());
        ret.setSequence((id >>> idMeta.getSeqBitsStartPos()) & idMeta.getSeqBitsMask());
        ret.setTime((id >>> idMeta.getTimeBitsStartPos()) & idMeta.getTimeBitsMask());
        ret.setGenMethod((id >>> idMeta.getGenMethodBitsStartPos()) & idMeta.getGenMethodBitsMask());
        ret.setType((id >>> idMeta.getTypeBitsStartPos()) & idMeta.getTypeBitsMask());
        ret.setVersion((id >>> idMeta.getVersionBitsStartPos()) & idMeta.getVersionMask());
        return ret;
    }
}
