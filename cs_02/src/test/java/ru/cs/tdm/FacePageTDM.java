package ru.cs.tdm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * После авторизации мы попадаем на морду TDM365.
 * Т.к. это уже другая страница, в соответствии с идеологией Page Object
 * нам понадобится отдельный класс для ее описания.
 * Создадим класс FacePage, в котором определим локаторы для имени пользователя
 * (как показателя успешного входа в учетную запись), а также кнопки выхода из аккаунта.
 * Помимо этого, напишем методы, которые будут получать имя пользователя и нажимать на кнопку выхода.
 */
public class FacePageTDM {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public FacePageTDM(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора меню пользователя
     * #button-1098
     * //*[@id="button-1098"]
     */

    @FindBy(xpath = "//a[@id='button-1098']")
    private WebElement userMenu;
    /**
     * определение локатора кнопки (пункта меню) выхода из аккаунта
     */
    @FindBy(xpath = "//span[text()='Выход']//parent::a")
    private WebElement logoutBtn;
    /**
     * метод для получения имени пользователя из меню пользователя
     * //*[@id="root"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/div[1]/div/span/text()
     * //span[@id="button-1098-btnInnerEl"]
     */
    @FindBy(xpath = "//span[@id='button-1098-btnInnerEl']")
    //@FindBy(xpath = "//a[@id='button-1098']/span//span//span[2]")
    private WebElement userAccountName;
    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        String userName = userAccountName.getText();
        return userName; }
    /**
     * Интересный момент: в метод getUserName() пришлось добавить еще одно ожидание,
     * т.к. страница «тяжелая» и загружалась довольно медленно.
     * В итоге тест падал, потому что метод не мог получить имя пользователя.
     * Метод getUserName() с ожиданием:
     */
    public String getUserName_Wait() {

        //WebDriverWait wait = new WebDriverWait(driver, 10);  //Deprecate 3.14
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // New 4.1.2

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By
        // .xpath("//*[contains(@class, 'account__name_hasAccentLetter')]")));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By
       //         .xpath("//*[contains(@class, 'personal-info-login__text personal-info-login__text_decorated')]")));
        String userName = userAccountName.getText();
        return userName;

    }


    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        userMenu.click(); }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click(); }

}

/**  https://stackoverflow.com/questions/58993667/webdriverwait-is-deprecated-in-selenium-4
 *          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 *         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
 *         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
 */
