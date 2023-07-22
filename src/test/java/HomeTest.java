
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.nio.file.Files;

public class HomeTest {

    private WebDriver driver;
    private HomePage HomePageObj;

    String Link = "https://www.amazon.com/";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Link);
    }

    @Test(priority = 1)
    public void NotRegisterdLogin() {
        HomePageObj = new HomePage(driver);
        HomePageObj.NotRegisterdLog();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Amazon Sign-In");
    }


    @Test(priority = 2)
    public void VerifyItemsAdded(){
        HomePageObj = new HomePage(driver);
        HomePageObj.VerifyItemsAddedToCart();
        HomePageObj.AssertTrueProductValues("Instant Vortex Plus 6-Quart Air Fryer Oven, Quiet Cooking, From the Makers of Instant Pot with ClearCook Cooking Window, Digital Touchscreen, App with over 100 Recipes, Single Basket, Black",
                "$89.95",
                "2",
                "$179.90");
    }

    @Test(priority = 3)
    public void Verify(){
        HomePageObj = new HomePage(driver);
        HomePageObj.VerifyOrders();
        driver.get(Link);
        HomePageObj.VerifyAdress();
        driver.get(Link);
        HomePageObj.VerifyLists();

//        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        Files.copy(f , new File("F:\\atask\\AmazonTest\\amazonScreenshot.jpg"));
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
