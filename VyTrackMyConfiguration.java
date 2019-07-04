package com.HomeAssignments;

import com.Utlities.BrowserFactory;
import com.day4.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrackMyConfiguration {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        vyTrackConfiguration();

    }

    public static void vyTrackConfiguration(){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://qa2.vytrack.com/user/login");
        //List<String> list = Arrays.asList("salesmanager270", "salesmanager271");
       // String password = "UserUser123";
        //for(String users : list ) {
            driver.findElement(By.name("_username")).sendKeys("user174");
            driver.findElement(By.name("_password")).sendKeys("UserUser123");
            driver.findElement(By.id("_submit")).click();

            library.sleep(2);
            driver.findElement(By.cssSelector("[class='dropdown user-menu-dropdown'] a")).click();
           library.sleep(2);
            driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[2]/a")).click();
            library.sleep(1);
            String nameOnTitle = driver.getTitle();

            String nameOnMenu = driver.findElement(By.linkText("Alex Jones")).getText();


            if(nameOnTitle.contains(nameOnMenu)){

                System.out.println("Passed");
                System.out.println("Name on the top right " + nameOnMenu);
                System.out.println("Name on title: " + nameOnTitle);
            }else{
                System.out.println("Failed");
                System.out.println("Name on the top right " + nameOnMenu);
                System.out.println("Name on title: " + nameOnTitle);

            }
            library.sleep(4);
            //System.out.println(" TST");
            driver.findElement(By.linkText("Logout")).click();




        driver.close();
    }
}
