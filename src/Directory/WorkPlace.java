package Directory;

import java.io.Serializable;

public class WorkPlace extends Record implements Serializable
{
    private String streetname;
    
    public WorkPlace(String na, String nu, String st) {
        super(na, nu);
        category = 2;
        streetname = st;
    }
    
    public String toString() {
        return super.toString() + " " + streetname;
    }
    
    public void setStreetname(String str) {
        streetname = str;
    }
}
