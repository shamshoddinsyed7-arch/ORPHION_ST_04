package orphiontechintern;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxOptions;
	import org.testng.Assert;
	import org.testng.annotations.*;

	public class CrossBrowserTest {

	    WebDriver driver;

	    @Parameters("browser")
	    @BeforeMethod
	    public void setup(String browser) {

	        if (browser.equalsIgnoreCase("chrome")) {
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--headless=new");
	            options.addArguments("--window-size=1920,1080");
	            driver = new ChromeDriver(options);

	        } else if (browser.equalsIgnoreCase("firefox")) {
	            FirefoxOptions options = new FirefoxOptions();
	            options.addArguments("-headless");
	            driver = new FirefoxDriver(options);
	        }

	        driver.manage().window().maximize();
	    }

	    @Test
	    public void verifyLoginPageTitle() {
	        driver.get("https://www.saucedemo.com/");

	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Swag Labs";

	        Assert.assertEquals(actualTitle, expectedTitle, "Title validation failed!");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

