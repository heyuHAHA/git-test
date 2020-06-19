package service;

import intf.IdPopulated;
import model.Id;
import service.bean.IdMetaFactory;
import service.bean.IdType;
import service.impl.LockPopulated;

import java.util.concurrent.locks.ReentrantLock;

public class IdServiceImplImpl extends AbstractIdServiceImpl {

    private IdPopulated idPopulated;
    public IdServiceImplImpl() {
        super();
        initPopulated();
    }

    public IdServiceImplImpl(IdType idType) {
        super(idType);
        initPopulated();
    }

    protected void populatedId(Id id) {
        idPopulated.populated(id, IdMetaFactory.getIdMeta(idType));
    }

    private void initPopulated() {
        //暂时只写一种实现方式
        if (idPopulated != null) {

        } else {
            idPopulated = new LockPopulated();
        }
    }

}
