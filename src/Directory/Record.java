package Directory;

import java.io.Serializable;

abstract class Record implements Serializable
{
    protected int category;
    protected String name;
    protected String number;
    
    public Record(String na,  String nu) {
        name = na;
        number = nu;
    }
    
    public String toString() {
        return name + " " + number;
    }
    
    public String getName() {
        return name;
    }
    
    public String getNumber() {
        return number;
    }
    
    public int getCategory() {
        return category;
    }
    
    public void setName(String na) {
        name = na;
    }
    
    public void setNumber(String nu) {
        number = nu;
    }
}
