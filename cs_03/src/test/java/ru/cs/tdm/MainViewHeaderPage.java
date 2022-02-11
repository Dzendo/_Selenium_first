package ru.cs.tdm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
     *
     * в body вложена панель меню сверху  //div[@id="mainView_header"]
     * Потом два вложения  //div[@id="mainView_header-innerCt"]//div[@id="mainView_header-targetEl"]
     * и третье вложение 8 сестринских
     * //div[@id="mainHeaderText"] -  внутри TDMSWeb //*[@id="mainHeaderText"]/span/b/a
     * //div[@id="container-1061"] - Остальные пункты меню
     *  вглубь два div и там:
     *          //а[@id="button-1104"] - раб стол
     *          //a[@id="button-1105"] - объекты
     *          //a[@id="button-1106"] - почта
     *          //a[@id="button-1107"] - справка
     * //div[@id="tdmsClipboardText"] - рамка вокруг меню
     * //div[@id="tdmsClipboardText"] - Найти
     *      //input[@id="tdmsSearch-1064-inputEl"] - найти
     *      //a[@id="button-1096"] - найти
     *      здесь еще лупа
     *      здесь еще стрелочка для вызлва подменю ::after flex
     * //a[@id="button-1097"] - колокольчик
     * //а[@id="button-1098"] - имя пользователя и раскрывающееся меню с выходо
     *          //span[@id="button-1098-btnInnerEl"]
     *
     * Сильно ниже div для подменю и в нем
     *  //*[@id="menuitem-1103-textEl"] - выход
     */

    /**
     * метод для нажатия кнопки TDMSWeb
     */
    @FindBy(xpath = "//a[contains(text(),'TDMS Web')]")
    private WebElement tdmsWebBtn;
    public Boolean ClickTDMSWeb() {
        System.out.println("нажатия кнопки TDMSWeb");
            tdmsWebBtn.click();
        if (!tdmsWebBtn.isSelected()) {  // class aria-pressd = true/false
      //      System.out.println("NOT tdmsWebBtn.isSelected()");
        }
        return tdmsWebBtn.isSelected();
    }
    /**
     * метод для нажатия кнопки РАБОЧИЙ СТОЛ
     */
    @FindBy(xpath = "//a[contains(@href,'#desktop')]")
    //@FindBy(xpath = "//b[contains(text(),'РАБОЧИЙ СТОЛ')]/ancestor::a")
    //@FindBy(xpath = "//b[contains(text(),'РАБОЧИЙ СТОЛ')]/../../../..")
    //@FindBy(xpath = "//a[contains(@href,'#desktop')] and //b[contains(text(),'РАБОЧИЙ СТОЛ')]/ancestor::a") NO
    private WebElement desktopBtn;
    public Boolean ClickDesktop() {
        System.out.println("нажатия кнопки РАБОЧИЙ СТОЛ");
            desktopBtn.click();
        if (!desktopBtn.isSelected()) {   // class aria-pressd = true/false
        //    System.out.println("NOT desktopBtn.isSelected()");
        }
        return desktopBtn.isSelected();
    }
    /**
     * метод для нажатия кнопки ОБЪЕКТЫ
     */
    //@FindBy(xpath = "//a[contains(@href,'#objects')]") NO 27
    @FindBy(xpath = "//b[contains(text(),'ОБЪЕКТЫ')]/ancestor::a")
    //@FindBy(xpath = "//b[contains(text(),'ОБЪЕКТЫ')]/../../../..")
    //@FindBy(xpath = "//a[contains(@href,'#objects')] and //b[contains(text(),'ОБЪЕКТЫ')]/ancestor::a") NO
    private WebElement objectsBtn;
    public Boolean ClickObjects() {
        System.out.println("нажатия кнопки ОБЪЕКТЫ");
            objectsBtn.click();
            return objectsBtn.isSelected();
    }
    /**
     * метод для нажатия кнопки ПОЧТА
     */
    @FindBy(xpath = "//a[contains(@href,'#mail')]")
    //@FindBy(xpath = "//b[contains(text(),'ПОЧТА')]/ancestor::a")
    //@FindBy(xpath = "//b[contains(text(),'ПОЧТА')]/../../../..")
    //@FindBy(xpath = "//a[contains(@href,'#mail')] and //b[contains(text(),'ПОЧТА')]/ancestor::a") NO
    private WebElement mailBtn;
    public Boolean ClickMail() {
        System.out.println("нажатия кнопки ПОЧТА");
            mailBtn.click();
            return mailBtn.isSelected();
    }
    /**
     * метод для нажатия кнопки СПРАВКА
     */
    @FindBy(xpath = "//a[contains(@href,'#help')]")
    //@FindBy(xpath = "//b[contains(text(),'ПОЧТА')]/ancestor::a")
    //@FindBy(xpath = "//b[contains(text(),'ПОЧТА')]/../../../..")
    //@FindBy(xpath = "//a[contains(@href,'#mail')] and //b[contains(text(),'ПОЧТА')]/ancestor::a") NO
    private WebElement helpBtn;
    public Boolean ClickHelp() {
        System.out.println("нажатия кнопки СПРАВКА");
            helpBtn.click();
            return helpBtn.isSelected();
    }
    /**
     * метод для нажатия кнопки Найти
     */
    @FindBy(xpath = "//input[contains(@placeholder,'Найти')]")
    private WebElement SearchInput;
    public Boolean ClickSearch() {
        System.out.println("нажатия кнопки Найти");
        SearchInput.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        return true;
    }
    public Boolean InputSearch(String search) {
        System.out.println("Ввод в InputSearch " + search);
            SearchInput.sendKeys(search);
            return true;
    }

    /**
     * метод для нажатия кнопки Сообщения
     */
    @FindBy(xpath = "//*[@id='button-1097']")
    private WebElement мessagesBtn;
    public Boolean ClickMessages() {
        System.out.println("нажатия кнопки Сообщения");
            мessagesBtn.click();
            return true;
    }
    /**
     * метод закрыть Окно сообщений
     * org.openqa.selenium.ElementClickInterceptedException: element click intercepted:
     * Element <a class="x-btn header-button x-unselectable x-box-item x-btn-default-small" hidefocus="on" unselectable="on"
     * role="button" aria-hidden="false" aria-disabled="false" aria-haspopup="true" aria-owns="menu-1099" id="button-1098"
     * tabindex="-1" style="left: 1790px; margin: 0px; top: 0px;" data-tabindex-value="0" data-tabindex-counter="1">...</a>
     * is not clickable at point (1854, 15).
     * Other element would receive the click:
     * <div role="presentation" class="x-mask x-border-box" style="height: 924px; width: 1920px; z-index: 18996;
     * left: 0px; top: 0px;" id="ext-element-18"></div>
     */
    @FindBy(xpath = "//*[contains(text(),'Окно сообщений')]") // не будет работать
    private WebElement мessagesClose;
    public Boolean CloseMessages() {
        System.out.println("закрыть Окно сообщений");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();
        return true;
    }


    /**
     * определение локатора и метод для нажатия кнопки меню пользователя
     */
    //@FindBy(xpath = "//*[@id='button-1089']")  // кандинский - Справка
    @FindBy(xpath = "//a[@id='button-1098']")   // SYSADMIN
    private WebElement userMenu;
    public void entryMenu() {
        System.out.println("нажатия кнопки меню пользователя");
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
        System.out.println("получения первого имени пользователя из меню пользователя" + userName) ;
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
        System.out.println("нажатия кнопки (пункта меню) выхода из аккаунта");
            logoutBtn.click();
    }
}
