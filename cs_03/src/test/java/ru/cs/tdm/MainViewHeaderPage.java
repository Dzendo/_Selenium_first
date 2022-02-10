package ru.cs.tdm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/** Создадим класс MainViewHeaderPage, в котором определим локаторы для меню пользователя
 * TDMSWeb РАБОЧИЙ СТОЛ  ОБЪЕКТЫ ПОЧТА СПРАВКА Найти Сообщения Пользователь (Сменить пароль настройки выход).
 * Помимо этого, напишем методы, которые будут получать имя пользователя и нажимать на кнопку выхода.
 */
public class MainViewHeaderPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public MainViewHeaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    /**
     * метод для нажатия кнопки TDMSWeb
     */
    public void ClickTDMSWeb() {
        //    tdmsWebBtn.click();
    }
    /**
     * метод для нажатия кнопки РАБОЧИЙ СТОЛ
     */
    public void ClickDesktop() {
        //    desktopBtn.click();
    }
    /**
     * метод для нажатия кнопки ОБЪЕКТЫ
     */
    public void ClickObjects() {
        //    objectsBtn.click();
    }
    /**
     * метод для нажатия кнопки ПОЧТА
     */
    public void ClickMail() {
        //    mailBtn.click();
    }
    /**
     * метод для нажатия кнопки СПРАВКА
     */
    public void ClickHelp() {
        //    helpBtn.click();
    }
    /**
     * метод для нажатия кнопки Найти
     */
    public void ClickSearch() {
        //    SearchInput.click();
    }
    /**
     * метод для нажатия кнопки Сообщения
     */
    public void ClickMessages() {
        //    мessagesBtn.click();
    }
    /**
     * определение локатора и метод для нажатия кнопки меню пользователя
     */
    //@FindBy(xpath = "//*[@id='button-1089']")  // кандинский - Справка
    @FindBy(xpath = "//a[@id='button-1098']")   // SYSADMIN
    private WebElement userMenu;

    public void entryMenu() {
        userMenu.click();
    }
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
     * метод для получения первого имени пользователя из меню пользователя
     */
    public String getFirstUserName() {
        String userName = userAccountName.getText();
        userName = userName.contains(" ") ? userName.split(" ")[0] : userName;
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
     * определение локатора и метод для нажатия кнопки (пункта меню) выхода из аккаунта
     */
    //@FindBy(xpath = "//*[@id='menuitem-1103-textEl']")
    @FindBy(xpath = "//span[text()='Выход']//parent::a")
    private WebElement logoutBtn;
    public void userLogout() {
            logoutBtn.click();
    }
}
