import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;


public class annotationOrder {
    @BeforeSuite
    public void test01(){
        System.out.println("1");

    }
    @BeforeTest
    public void test02(){
        System.out.println("2");
    }
    @BeforeClass
    public void test03(){
        System.out.println("3");
    }
    @BeforeGroups
    public void test04(){
        System.out.println("4");
    }
    @BeforeMethod
    public void test05(){
        System.out.println("5");
    }
    @Test
    public void test06(){
        System.out.println("6");
    }
    @AfterMethod
    public void test07(){
        System.out.println("7");
    }
    @AfterGroups
    public void test08(){
        System.out.println("8");
    }
    @AfterClass
    public void test09(){
        System.out.println("9");
    }
    @AfterTest
    public void test10(){
        System.out.println("10");
    }
    @AfterSuite
    public void test11(){
        System.out.println("11");
    }


}
