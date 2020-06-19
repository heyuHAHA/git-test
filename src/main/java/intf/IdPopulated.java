package intf;

import model.Id;
import service.bean.IdMeta;

public interface IdPopulated {

    void populated(Id id, IdMeta idMeta);
}
