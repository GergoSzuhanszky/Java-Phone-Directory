package Directory;

import java.io.Serializable;

public class Person extends Record implements Serializable
{
    private String nickname;
    private String hometown;
    
    public Person(String na, String nu, String ni, String ho) {
        super(na, nu);
        category = 0;
        nickname = ni;
        hometown = ho;
    }
    
    public String toString() {
        return super.toString() + " " + nickname + " " + hometown;
    }
    
    public void setNickname(String ni) {
        nickname = ni;
    }
    
    public void setHometown(String ho) {
        hometown = ho;
    }
}
