package Shared.Domain.Creator;

/**
 * Created by beniamino on 25/02/16.
 */
public interface ICreator {
    public String getIdType();
    public void setIdType(String idType);
    public String getName();
    public void setName(String name);
    public String getDescription();
    public void setDescription(String description);
}
