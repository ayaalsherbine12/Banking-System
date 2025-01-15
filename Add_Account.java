/*
                                                 - No Edit -
1.Add Valid New Account with Mega Configuration
2.Add Valid New Account without Mega Configuration

*/
package Accounts;
import Base_Test.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Add_Account {
    WebDriver driver;
    public WebDriverSetup webDriverSetup;

    @BeforeClass
    public void PreConditions() throws InterruptedException {
//Pre_Conditions
        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.initializeDriver();
        webDriverSetup.performLogin(driver);
//Tabs
        WebElement Accounts_Tab = driver.findElement(By.cssSelector("p.menuItem > a[data-flexmenu='flexmenu1']"));
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(Accounts_Tab).perform();
        Thread.sleep(1000);
        WebElement Add_Account = driver.findElement(By.xpath("//*[@id=\"flexmenu1\"]/li[3]/a"));
        actions.moveToElement(Add_Account).perform();
        Add_Account.click();
        Thread.sleep(1000);
        }

//Test_Cases
        @Test(priority = 1)
    public void With_Valid_Mega_Configuration() throws InterruptedException {
            Actions actions = new Actions(driver);
            String Location_Id = "9999";
            driver.findElement(By.id("addPOS:locationID")).sendKeys(Location_Id);
            Thread.sleep(1000);
            System.out.println("Location id: " + Location_Id);

            WebElement dropdown_Csp = driver.findElement(By.id("addPOS:cspList"));
            Select select_dropdown_Csp = new Select(dropdown_Csp);
            select_dropdown_Csp.selectByVisibleText("FAWRYRTL");
            Thread.sleep(1000);
            System.out.println("CSP: FAWRYRTL");

            String Customer_Profile = "1233445";
            driver.findElement(By.cssSelector("input[id=\"addPOS:menu1\"]")).sendKeys(Customer_Profile);
            Thread.sleep(1000);
            System.out.println("Customer Profile: " + Customer_Profile);

            WebElement body = driver.findElement(By.cssSelector("td[width=\"5%\"]"));
            actions.moveToElement(body).click().perform();
            Thread.sleep(1000);


                WebElement dropdown_Usage = driver.findElement(By.id("addPOS:usageList"));
                Select select_dropdown_Usage = new Select(dropdown_Usage);
                select_dropdown_Usage.selectByVisibleText("MARK - Market");
                Thread.sleep(1000);
                 System.out.println("Usage: MARK");

            String Description = "Fawry";
            driver.findElement(By.id("addPOS:textareaDescription1")).sendKeys(Description);
            Thread.sleep(1000);
            System.out.println("Description: " +Description);


                WebElement dropdown_AccountClass = driver.findElement(By.id("addPOS:accountClassList"));
                Select select_dropdown_AccountClass = new Select(dropdown_AccountClass);
                select_dropdown_AccountClass.selectByVisibleText("CLASS A ACCOUNT");
            Thread.sleep(1000);
            System.out.println("Account Class: CLASS A");



                WebElement dropdown_AccountGroup = driver.findElement(By.id("addPOS:accountGroupList"));
                Select select_dropdown_AccountGroup = new Select(dropdown_AccountGroup);
                select_dropdown_AccountGroup.selectByVisibleText("Agent");
            Thread.sleep(1000);
            System.out.println("Account Group: Agent");

//Terminal Page
            driver.findElement(By.id("addPOS:addAcctTerminal")).click();
            Thread.sleep(1000);

            WebElement dropdown_TerminalStatus = driver.findElement(By.id("AddAcctTerminalData:statusList"));
            driver.findElement(By.id("AddAcctTerminalData:statusList")).click();
            Select select_dropdown_TerminalStatus = new Select(dropdown_TerminalStatus);
            select_dropdown_TerminalStatus.selectByVisibleText("ACTV - Active");
            Thread.sleep(1000);

            WebElement dropdown_TerminalType = driver.findElement(By.id("AddAcctTerminalData:TermList"));
            driver.findElement(By.id("AddAcctTerminalData:TermList")).click();
            Select select_dropdown_TerminalType = new Select(dropdown_TerminalType);
            select_dropdown_TerminalType.selectByVisibleText("POS - Point of Sale");
            Thread.sleep(1000);
            System.out.println("Terminal Type: POS - Point of Sale");

            String Profile_Code = "418";
            driver.findElement(By.id("AddAcctTerminalData:profileCode")).sendKeys(Profile_Code);
            Thread.sleep(1000);
            System.out.println("Profile Code: " + Profile_Code);

            String Serial_Number = "233-124-765";
            driver.findElement(By.id("AddAcctTerminalData:textSN1")).sendKeys(Serial_Number);
            Thread.sleep(1000);
            System.out.println("Serial Number : " + Serial_Number);

            String PIN = "1234";
            driver.findElement(By.id("AddAcctTerminalData:textPin1")).sendKeys(PIN);
            Thread.sleep(1000);
            System.out.println("PIN: " + PIN);

            driver.findElement(By.id("AddAcctTerminalData:add")).click();
            Thread.sleep(1000);

            String Daily_Limit = "1000000";
            driver.findElement(By.id("addPOS:textDailyLimit1")).sendKeys(Daily_Limit);
            Thread.sleep(1000);
            System.out.println("Daily_Limit: " + Daily_Limit);

            String Credit_Limit = "1000000";
            driver.findElement(By.id("addPOS:textCreditLimit1")).sendKeys(Credit_Limit);
            Thread.sleep(1000);
            System.out.println("Credit Limit: " + Credit_Limit);

            String Mobile_Number = "01113614110";
            driver.findElement(By.id("addPOS:Mobile")).sendKeys(Mobile_Number);
            Thread.sleep(1000);
            System.out.println("Mobile Number: " + Mobile_Number);

                WebElement dropdown_ProfileId = driver.findElement(By.id("addPOS:profileDataList"));
                Select select_dropdown_ProfileId = new Select(dropdown_ProfileId);
                select_dropdown_ProfileId.selectByVisibleText("PROF1 - PROF1");
                Thread.sleep(1000);
            System.out.println("Profile Id: PROF1");

                WebElement flagBox_Mega = driver.findElement(By.id("addPOS:megaAccount234"));
            try {
                WebElement button = driver.findElement(By.id("addPOS:megaAccount234"));
                button.click();
                Thread.sleep(1000);

                boolean newStatus = flagBox_Mega.isSelected();
                System.out.println("Status of flag box 'Setup Program Accounts': " + (newStatus ? "Checked" : "Unchecked"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            driver.findElement(By.cssSelector("input[id=\"addPOS:button1\"]")).click();
            Thread.sleep(1000);
//Assertions
            WebElement AccountNumberElement = driver.findElement(By.id("AddAccountSuccess:AccountCode"));
            String AccountNumberText = AccountNumberElement.getText();
            System.out.println("New Account Code is: " + AccountNumberText);

            String NewAccount = driver.findElement(By.cssSelector("span[id=\"AddAccountSuccess:CorrectMessage\"]")).getText();
            System.out.println(NewAccount + " With Mega Configuration");
            Thread.sleep(1000);

            driver.findElement(By.id("AddAccountSuccess:okBtn")).click();
            Thread.sleep(1000);
        }

@Test(priority = 2)
        public void Without_Valid_Mega_Configuration() throws InterruptedException {
    Actions actions = new Actions(driver);
    String Location_Id = "9999";
    driver.findElement(By.id("addPOS:locationID")).sendKeys(Location_Id);
    Thread.sleep(1000);
    System.out.println("Location id: " + Location_Id);

    WebElement dropdown_Csp = driver.findElement(By.id("addPOS:cspList"));
    Select select_dropdown_Csp = new Select(dropdown_Csp);
    select_dropdown_Csp.selectByVisibleText("FAWRYRTL");
    Thread.sleep(1000);
    System.out.println("CSP: FAWRYRTL");

    String Customer_Profile = "1233445";
    driver.findElement(By.cssSelector("input[id=\"addPOS:menu1\"]")).sendKeys(Customer_Profile);
    Thread.sleep(1000);
    System.out.println("Customer Profile: " + Customer_Profile);

    WebElement body = driver.findElement(By.cssSelector("td[width=\"5%\"]"));
    actions.moveToElement(body).click().perform();
    Thread.sleep(1000);


    WebElement dropdown_Usage = driver.findElement(By.id("addPOS:usageList"));
    Select select_dropdown_Usage = new Select(dropdown_Usage);
    select_dropdown_Usage.selectByVisibleText("MARK - Market");
    Thread.sleep(1000);
    System.out.println("Usage: MARK");

    String Description = "Fawry";
    driver.findElement(By.id("addPOS:textareaDescription1")).sendKeys(Description);
    Thread.sleep(1000);
    System.out.println("Description: " +Description);


    WebElement dropdown_AccountClass = driver.findElement(By.id("addPOS:accountClassList"));
    Select select_dropdown_AccountClass = new Select(dropdown_AccountClass);
    select_dropdown_AccountClass.selectByVisibleText("CLASS A ACCOUNT");
    Thread.sleep(1000);
    System.out.println("Account Class: CLASS A");



    WebElement dropdown_AccountGroup = driver.findElement(By.id("addPOS:accountGroupList"));
    Select select_dropdown_AccountGroup = new Select(dropdown_AccountGroup);
    select_dropdown_AccountGroup.selectByVisibleText("Agent");
    Thread.sleep(1000);
    System.out.println("Account Group: Agent");

//Terminal Page
    driver.findElement(By.id("addPOS:addAcctTerminal")).click();
    Thread.sleep(1000);

    WebElement dropdown_TerminalStatus = driver.findElement(By.id("AddAcctTerminalData:statusList"));
    driver.findElement(By.id("AddAcctTerminalData:statusList")).click();
    Select select_dropdown_TerminalStatus = new Select(dropdown_TerminalStatus);
    select_dropdown_TerminalStatus.selectByVisibleText("ACTV - Active");
    Thread.sleep(1000);

    WebElement dropdown_TerminalType = driver.findElement(By.id("AddAcctTerminalData:TermList"));
    driver.findElement(By.id("AddAcctTerminalData:TermList")).click();
    Select select_dropdown_TerminalType = new Select(dropdown_TerminalType);
    select_dropdown_TerminalType.selectByVisibleText("POS - Point of Sale");
    Thread.sleep(1000);
    System.out.println("Terminal Type: POS - Point of Sale");

    String Profile_Code = "418";
    driver.findElement(By.id("AddAcctTerminalData:profileCode")).sendKeys(Profile_Code);
    Thread.sleep(1000);
    System.out.println("Profile Code: " + Profile_Code);

    String Serial_Number = "233-124-765";
    driver.findElement(By.id("AddAcctTerminalData:textSN1")).sendKeys(Serial_Number);
    Thread.sleep(1000);
    System.out.println("Serial Number : " + Serial_Number);

    String PIN = "1234";
    driver.findElement(By.id("AddAcctTerminalData:textPin1")).sendKeys(PIN);
    Thread.sleep(1000);
    System.out.println("PIN: " + PIN);

    driver.findElement(By.id("AddAcctTerminalData:add")).click();
    Thread.sleep(1000);

    String Daily_Limit = "1000000";
    driver.findElement(By.id("addPOS:textDailyLimit1")).sendKeys(Daily_Limit);
    Thread.sleep(1000);
    System.out.println("Daily_Limit: " + Daily_Limit);

    String Credit_Limit = "1000000";
    driver.findElement(By.id("addPOS:textCreditLimit1")).sendKeys(Credit_Limit);
    Thread.sleep(1000);
    System.out.println("Credit Limit: " + Credit_Limit);

    String Mobile_Number = "01113614110";
    driver.findElement(By.id("addPOS:Mobile")).sendKeys(Mobile_Number);
    Thread.sleep(1000);
    System.out.println("Mobile Number: " + Mobile_Number);

    WebElement dropdown_ProfileId = driver.findElement(By.id("addPOS:profileDataList"));
    Select select_dropdown_ProfileId = new Select(dropdown_ProfileId);
    select_dropdown_ProfileId.selectByVisibleText("PROF1 - PROF1");
    Thread.sleep(1000);
    System.out.println("Profile Id: PROF1");

        WebElement flagBox_Mega = driver.findElement(By.id("addPOS:megaAccount234"));
                try {
                    Thread.sleep(1000);

                    boolean newStatus = flagBox_Mega.isSelected();
                    System.out.println("Status of flag box 'Setup Program Accounts': " + (newStatus ? "Checked" : "Unchecked"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

    driver.findElement(By.cssSelector("input[id=\"addPOS:button1\"]")).click();
                Thread.sleep(1000);
//Assertions
    WebElement AccountNumberElement = driver.findElement(By.id("AddAccountSuccess:AccountCode"));
    String AccountNumberText = AccountNumberElement.getText();
    System.out.println("New Account Code is: " + AccountNumberText);

    String NewAccount = driver.findElement(By.cssSelector("span[id=\"AddAccountSuccess:CorrectMessage\"]")).getText();
    System.out.println(NewAccount + " Without Mega Configuration");
    Thread.sleep(1000);

    driver.findElement(By.id("AddAccountSuccess:okBtn")).click();
    Thread.sleep(1000);
}

    @AfterClass
    public void quit(){
        webDriverSetup.closeBrowser();

    }
    }