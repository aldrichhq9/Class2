import org.testng.annotations.*;

public class TestNgAnnotations extends Base{
    @Test
    public void testCase3(){
        System.out.println("test case 1");
    }

    @Test
    public void testCase2(){
        System.out.println("test case 2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTes");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }
}
