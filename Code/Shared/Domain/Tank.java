package Shared.Domain;

import java.util.UUID;

/**
 * Created by beniamino on 22/03/16.
 */
public class Tank implements ITank {


    public void Tank(){}

    private String id= UUID.randomUUID().toString();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
