package Directory;

import java.io.Serializable;

public class Service extends Record implements Serializable
{
    private String type;
    
    public Service(String na, String nu, String ty) {
        super(na, nu);
        category = 1;
        type = ty;
    }
    
    public String toString() {
        return super.toString() + " " + type;
    }
    
    public void setType(String ty) {
        type = ty;
    }
}