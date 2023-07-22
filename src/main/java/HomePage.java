import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class HomePage {


    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    @FindBy(id = "nav-link-accountList")
    private WebElement SignInButton;

    @FindBy(id = "ap_email")
    private WebElement EmailLogInInput;

    @FindBy(id = "continue")
    private WebElement ContinBtn;

    @FindBy(id = "ap_password")
    private WebElement PassLogInInput;

    @FindBy(id = "signInSubmit")
    private WebElement SignInBtn;

    ///////////////////////////////////////////////////

    @FindBy(xpath = "//*[@id=\"nav-xshop\"]/a[1]")
    private WebElement TodayDealBtn;


    @FindBy(xpath = "//*[@id=\"anonCarousel1\"]/ol/li[3]/a")
    private WebElement SecCat;



    @FindBy(xpath = "/html/body/div[1]/div[20]/div/div/div/div[2]/div[3]/div/div[1]/div/div/a")
    private WebElement FirstProduct;


    @FindBy(xpath = "//*[@id=\"octopus-dlp-asin-stream\"]/ul/li[2]/span/div/div[1]/a")
    private WebElement SecItem;

    @FindBy(xpath = "//*[@id=\"a-autoid-0\"]/span")
    private WebElement QuntityDropDownList;

    @FindBy(id = "add-to-cart-button")
    private WebElement AddToCartBtn;

    @FindBy(xpath = "//*[@id=\"sw-gtc\"]/span/a")
    private WebElement GotoCart;


    @FindBy(xpath = "//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")
    private WebElement CloseTab;


    // asseration elements
    @FindBy(xpath = "//*[@id=\"sc-active-c5c5c92b-789f-414e-9306-191784e9d4a2\"]/div[4]/div/div[2]/ul/li[1]/span/a/span[1]")
    private WebElement PName;

    @FindBy(xpath = "//*[@id=\"sc-active-fbfe07ba-36ee-4ebb-962e-097d3aa07e59\"]/div[4]/div/div[2]/ul/div/div/div[1]/p/span")
    private WebElement Price;

    @FindBy(xpath = "//*[@id=\"a-autoid-0\"]")
    private WebElement Quntity;

    @FindBy(xpath = "//*[@id=\"quantity_1\"]")
    private WebElement ChooseQty;

    @FindBy(xpath = "//*[@id=\"sc-subtotal-amount-activecart\"]/span")
    private WebElement SubTotal;



    // scenrio 3


    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]")
    private WebElement HoverdBtn;

    @FindBy(xpath = "//*[@id=\"nav-al-your-account\"]/a[1]")
    private WebElement Account;

    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a")
    private WebElement YourOrders;

    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[6]/div[1]/div/div/ul/li[1]/span/a")
    private WebElement YourAdress;

    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[5]/div[1]/a")
    private WebElement YourLists;

    public void NotRegisterdLog(){
        SignInButton.click();
        EmailLogInInput.clear();
        EmailLogInInput.sendKeys("hello@gmail.com");
        ContinBtn.click();
        PassLogInInput.clear();
        PassLogInInput.sendKeys("123456");
        SignInBtn.click();
    }


    public void VerifyItemsAddedToCart(){

        CloseTab.click();
        TodayDealBtn.click();
        SecCat.click();
        FirstProduct.click();
        SecItem.click();
        QuntityDropDownList.click();
        ChooseQty.click();
        AddToCartBtn.click();
        GotoCart.click();
    }

    public void AssertTrueProductValues(String ProductName,String ProductPrice,String ProductQty,String ProductSubTotal)
    {
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(PName.getText(),ProductName);
            softAssert.assertEquals(Price.getText(),ProductPrice);
            softAssert.assertEquals(Quntity.getText(),ProductQty);
            softAssert.assertEquals(SubTotal.getText(),ProductSubTotal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void VerifyOrders(){
        SoftAssert softAssert = new SoftAssert();
        Actions action = new Actions(driver);
        action.moveToElement(HoverdBtn).perform();
        Account.click();
        YourOrders.click();
        softAssert.assertEquals(driver.getTitle(),"Amazon Sign-In");
    }

    public void VerifyAdress(){
        SoftAssert softAssert = new SoftAssert();
        Actions action = new Actions(driver);
        action.moveToElement(HoverdBtn).perform();
        Account.click();
        YourAdress.click();
        softAssert.assertEquals(driver.getTitle(),"Amazon Sign-In");
    }

    public void VerifyLists(){
        SoftAssert softAssert = new SoftAssert();
        Actions action = new Actions(driver);
        action.moveToElement(HoverdBtn).perform();
        Account.click();
        YourLists.click();
        softAssert.assertEquals(driver.getTitle(),"Your List");
    }





}
