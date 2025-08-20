package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class XpathPart_III {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://localhost:59579/");

    }
    @Test
    public void XpathPart_III() {

    }
    @Test
    public void test01() {
        driver.get("https://automationfc.github.io/basic-form/");

        List<WebElement> text01 = driver.findElements(By.xpath("//h5[text()='Michael Jackson']"));

        for (int i = 0; i < text01.size(); i++) {
            text01.get(i).isDisplayed();
            System.out.println(text01.get(i).getText());
        }
        WebElement text02 = driver.findElement(By.xpath("//p[contains(text(), 'Mail Personal or Business Check')]"));
        System.out.println(text02.getText());
        List<WebElement> text03 = driver.findElements(By.xpath("//h5[@id='nine']/p"));
        for (int i = 0; i < text03.size(); i++) {
            text03.get(i).isDisplayed();
            System.out.println(text03.get(i).getText());
        }
        // Truyền text vào locator để hiển thị: display

        String text04 = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();
        Assert.assertTrue(text04.contains("Mail Personal or Business Check, Cashier's Check or money order to:"));

        List<WebElement> text05 = driver.findElements(By.xpath("//h5[contains(text(), 'Michael Jackson')]"));
        for (int i = 0; i < text05.size(); i++) {
            text05.get(i).isDisplayed();
            System.out.println("Contains text()"+ text05.get(i).getText());
        }

        List<WebElement> text06 = driver.findElements(By.xpath("//h5[contains(string(), 'Michael Jackson')]"));
        for (int i = 0; i < text06.size(); i++) {
            text06.get(i).isDisplayed();
            System.out.println("Contains string()" + i + " : "+ text06.get(i).getText());
        }
        List<WebElement> text07 = driver.findElements(By.xpath("//h5/span[contains(text(), \"(Ignore Me)\")]"));
        for (int i = 0; i < text07.size(); i++) {
            text07.get(i).isDisplayed();
            System.out.println(text07.get(i).getText());
        }
        String text08 = driver.findElement(By.xpath("//h5[@id='nested']")).getText();
        Assert.assertEquals(text08, "Hello World! (Ignore Me) @04:45 PM");

        // 1. Locator xấu, code khó đọc.
        String text09 = driver.findElement(By.xpath("//span[text()=concat('Hello \"', 'John', '\", What', \"'\", 's happened?')]")).getText();
        System.out.println("Contains text()"+ text09);

        String text10 = driver.findElement(By.xpath("//span[@class='concat']")).getText();
        System.out.println("Xpath class"+ text10);

        Assert.assertEquals(text10, "Hello \"John\", What's happened?");

        // Kĩ thuật And và Or
        WebElement text11 = driver.findElement(By.xpath("//input[@type='email' and @id='email']"));
        text11.sendKeys("phungthilien@gmail.com");

        WebElement text12 = driver.findElement(By.xpath("//input[not(@type='text')]"));
        System.out.println("Not:: "+ text12);
    }

    @Test
    public void test02(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        WebElement text01 = driver.findElement(By.xpath("//div[not(@style='display: none;')]/div[@class='raDiv']"));
        text01.isDisplayed();
        System.out.println(text01.getText());
    }
    @Test
    public void test03() throws Exception {

        driver.get("https://automationfc.github.io/jquery-selectable/");
        // Insite parent: cùng nằm trong một thẻ cha, có thể đánh thứ tự index
        WebElement text01 = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
        text01.isDisplayed();
        System.out.println("parent:: index:: " + text01.getText());
        Thread.sleep(1000);

    }

    @Test
    public void test04(){
        driver.get("http://live.techpanda.org/index.php/mobile.html");
        //Outsite parent: không cùng nằm trong một thẻ cha
        List<WebElement> text02 = driver.findElements(By.xpath("//a[@class='product-image']/img[1]"));
        for (int i = 0; i < text02.size(); i++) {
            text02.get(i).isDisplayed();
            System.out.println("Element:: " + i + " :: "+text02.get(i).getText());
        }
        WebElement text03 = driver.findElement(By.xpath("//div[@class='category-products']/ul/li[1]"));
        System.out.println(text03.getText());

        WebElement text04 = driver.findElement(By.xpath("(//a[@class='product-image']/img)[1]"));
        System.out.println("Bọc locator:: "+ text04.getText());
        //Khi vị trí index thay đổi sẽ  sai
    }

    @Test
    public void test05(){
        //Axes: Khi thêm bớt sản phẩm, xpath không được fail
        driver.get("http://live.techpanda.org/index.php/mobile.html");
        WebElement text01 = driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2"));
        //Lấy ông cụ ki, cả bao gồm cha
        //parent lấy từ đời cha trở lên 1 node còn child lấy  từ đời con tr xuống 1 node
        // ancestor từ đời cha trở lên lấy toàn bộ, descendent lấy toàn bộ đời con trở xuống
        List<WebElement> text02 = driver.findElements(By.xpath("//a[text()='Sony Xperia']/parent::h2/ancestor::div"));
        WebElement text03 = driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/ancestor::div[@class='category-products']"));
        WebElement text04 = driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/ancestor::div[@class='product-info']/child::h2"));
        WebElement text05 = driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']"));
       System.out.println("following-sibling:: "+ text05.getText());

        WebElement text06 = driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/button"));
//        text06.click();

        WebElement text07 = driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div/ancestor::*/li/child::*/following-sibling::div/div/p/parent::div"));
        System.out.println(text07.getText());
    }
    @Test
    public void test06(){
        driver.get("http://live.techpanda.org/index.php/mobile.html");
        String locatorValue = "//a[text()='%s']/parent::h2/ancestor::div[@class='%s']";
        WebElement text03 = driver.findElement(By.xpath(this.buttonClick(locatorValue, "Sony Xperia", "category-products" )));
        System.out.println(text03.getText());
    }

    @Test
    public void testUploadFiles() throws Exception{
        driver.get("https://www.file.io/");
        uploadMultipleFiles(driver, "Da Nang.jpg");
        Thread.sleep(2000);

        uploadMultipleFiles(driver, new String[]{"Da Nang.jpg", "Ha Giang.jpg"});
        Thread.sleep(2000);

        System.out.println("");
    }

    public void uploadMultipleFiles(WebDriver driver, String ... fileNames) throws IOException {

        String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
        String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;

        String fullFileName = "";
        for (String file: fileNames) {
            fullFileName = fullFileName + UPLOAD_PATH + file + "\n";

        }
        fullFileName = fullFileName.trim();
        driver.findElement(By.cssSelector("input[id='upload-button']")).sendKeys(fullFileName);

        System.out.println(fullFileName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String buttonClick(String locatorValue, String ... key){
        System.out.println("Before");
        locatorValue = String.format(locatorValue, (Object[]) key);
        return  locatorValue;
    }
}
