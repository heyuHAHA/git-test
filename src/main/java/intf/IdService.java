package intf;

import model.Id;

import java.util.Date;

public interface IdService {

    long genId();
    Id parseId(long id);
    Date transTime(long time);
}
