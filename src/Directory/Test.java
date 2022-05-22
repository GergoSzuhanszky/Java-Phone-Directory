package Directory;

import org.junit.After;
import org.junit.Before;
import java.io.OutputStream;
import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Test
{
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;
    
    public Test() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
    }
    
    @org.junit.Test
    public void testGetName() {
        Person x = new Person("a", "a", "a", "a");
        Assert.assertEquals("getName result", x.getName(), "a");
    }
    
    @org.junit.Test
    public void testGetNumber() {
        Person x = new Person("a", "a", "a", "a");
        Assert.assertEquals("getNumber result", x.getNumber(), "a");
    }
    
    @org.junit.Test
    public void testToString1() {
        Person x = new Person("a", "a", "a", "a");
        Assert.assertEquals("toString result", x.toString(), "a a a a");
    }
    
    @org.junit.Test
    public void testToString2() {
        Service x = new Service("a", "a", "a");
        Assert.assertEquals("toString result", x.toString(), "a a a");
    }
    
    @org.junit.Test
    public void testToString3() {
        WorkPlace x = new WorkPlace("a", "a", "a");
        Assert.assertEquals("toString result", x.toString(), "a a a");
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    @org.junit.Test
    public void testStandardOutput1() {
        Person p = new Person("a", "a", "a", "a");
        System.out.println(p);
        Assert.assertEquals("a a a a", outputStreamCaptor.toString().trim());
    }
    
    @org.junit.Test
    public void testStandardOutput2() {
        Person p = new Person("a", "a", "a", "a");
        p.setName("b");
        System.out.println(p);
        Assert.assertNotEquals("a a a a", outputStreamCaptor.toString().trim());
        Assert.assertEquals("b a a a", outputStreamCaptor.toString().trim());
    }
    
    @org.junit.Test
    public void testStandardOutput3() {
        Collection arr = new Collection();
        arr.addRecord();
        String[] x = outputStreamCaptor.toString().trim().split("\n");
        String exp1 = "Choose category:\n";
        String exp2 = "Person\t\t\t-\t\t1\n";
        Assert.assertEquals(exp1.trim(), x[0].trim());
        Assert.assertEquals(exp2.trim(), x[1].trim());
    }
    
    @org.junit.Test
    public void testSave1() {
        Collection x = new Collection();
        x.addRecord();
        x.save();
        x.removeRecord();
        x.load();
        x.listCollection();
        String[] out = outputStreamCaptor.toString().trim().split("\n");
        String exp = "a a a a";
        Assert.assertEquals(exp.trim(), out[16].trim());
    }
    
    @org.junit.Test
    public void testModify() {
        Collection x = new Collection();
        x.addRecord();
        x.modifyRecord();
        x.listCollection();
        String[] out = outputStreamCaptor.toString().trim().split("\n");
        String exp = "b a a a";
        Assert.assertEquals(exp.trim(), out[15]);
    }
    
    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}

