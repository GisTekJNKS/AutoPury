import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by John on 16.10.2015.
 */
public class TestGoToMaven {

    @BeforeClass
    public void ready(){
        Configuration.browser = System.getProperty("browser", "firefox");
    }

    @Test
    public void goToTutBy(){
        open("http://mvnrepository.com/");
        $("#query").sendKeys("selenide");
        $("#query").pressEnter();
        $(By.xpath("//a[text()='selenide']")).click();
    }

    @AfterClass
    public void finish(){
        close();
    }

}
