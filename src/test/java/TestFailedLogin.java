import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by John on 06.10.2015.
 */
public class TestFailedLogin {

    @BeforeClass
    public void ready(){
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.startMaximized=true;
    }

    @Test
    public void loginWithEmptyFields(){
        open("http://purity_test_ws.andersenlab.com/");
        $("#show-login-form-btn").click();
        $(".btn.btn-primary.sign-btn").click();
        $(By.xpath("//p[text()='Email cannot be blank.']")).shouldBe(exist).shouldBe(visible);
        $(By.xpath("//p[text()='Password cannot be blank.']")).shouldBe(exist).shouldBe(visible);
    }

    @Test
    public void loginWithIncorrectPassword() {
        open("http://purity_test_ws.andersenlab.com/");
        $("#show-login-form-btn").click();
        $("#loginform-email").sendKeys("admin@gmail.com");
        $("#loginform-password").sendKeys("sdgsefs");
        $(".btn.btn-primary.sign-btn").click();
        $(By.xpath("//p[contains(text(),'Incorrect username or password.')]")).shouldBe(exist).shouldBe(visible);
    }

    @Test
    public void loginWithIncorrectEmail(){
        open("http://purity_test_ws.andersenlab.com/");
        $("#show-login-form-btn").click();
        $("#loginform-email").sendKeys("admin@@gmail.com");
        $("#loginform-password").click();
        $(By.xpath("//p[contains(text(),'Email is not a valid email address.')]")).shouldBe(exist).shouldBe(visible);
    }

    @AfterClass
    public void finish(){
        close();
    }


//    @Test
//    public void sefe () throws InterruptedException {
//        $("#dropdownMenu1").click();
//        $("#dropdownMenu2").click();
//        $(By.xpath("//a[text()='distributor']")).click();
//        Thread.sleep(3000);
//    }

//    @Test
//    public void sefe2 () throws InterruptedException {
//        $("#dropdownMenu1").click();
//        $("#dropdownMenu2").click();
//        $(By.xpath("//a[text()='user']")).click();
//        Thread.sleep(3000);
//    }

}
