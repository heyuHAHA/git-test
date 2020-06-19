package service.IdConverter;

import model.Id;

public interface IdConverter {
    public long convert(Id id);
    public Id convert(long id);
}
