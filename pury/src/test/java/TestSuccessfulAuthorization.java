import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by John on 07.10.2015.
 */
public class TestSuccessfulAuthorization {


    @BeforeClass
    public void ready(){
        Configuration.browser = System.getProperty("browser", "firefox");
        open("http://purityIT:HardPassword@purity_ws.andersenlab.com");
//        $("#show-login-form-btn").click();
        getWebDriver().findElement(By.id("show-login-form-btn")).click();

    }


    @Test
    public void correctLogin (){
        $("#loginform-email").clear();
        $("#loginform-email").sendKeys("admin@gmail.com");
        $("#loginform-password").sendKeys("admin");
        $(".btn.btn-primary.sign-btn").click();
        $("h1").shouldHave(text("Dashboard"));
    }

    @AfterClass
    public void finish(){
        close();
    }
}
