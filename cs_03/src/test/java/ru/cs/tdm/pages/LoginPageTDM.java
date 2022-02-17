package ru.cs.tdm.pages;

/**
 * При использовании Page Object элементы страниц,
 * а также методы непосредственного взаимодействия с ними,
 * выносятся в отдельный класс.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 /**
 * Класс LoginPageTDM, который будет содержать локацию элементов страницы логина
 * и методы для взаимодействия с этими элементами.
 */
public class LoginPageTDM {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPageTDM(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора поля ввода логина
     */
    //@FindBy(xpath = "//input [contains(@id, 'textfield-1054-inputEl')]")
    @FindBy(xpath = "//span[contains(text(),'Пользователь:')]/ancestor::label/following-sibling::div//input")
    // @FindBy(xpath = "//input[contains(@placeholder,'Пользователь')]")  // Тема 2
    //@FindBy(xpath = "//span[contains(text(),'Пользователь:')]/../../..//input")
    //@FindBy(xpath = "//input [contains(@type, 'text') and contains(@class, 'x-form-field') and contains(@class, 'x-form-required-field')]")
    private WebElement loginField;

    /**
     * определение локатора поля ввода пароля
     */
    //@FindBy(xpath = "//input [contains(@id,'textfield-1055-inputEl')]")
    // @FindBy(xpath = "//input[contains(@placeholder,'Пароль')]")  // Тема 2
    @FindBy(xpath = "//input[contains(@type, 'password')]")   // Тема 1,2
    private WebElement passwdField;

    /**
     * определение кнопки входа
     */
    //@FindBy(xpath = "//*[@id="button-1060"]")
    //@FindBy(xpath = "//span [contains(@id,'button-1060-btnInnerEl')]/ancestor::a")
    @FindBy(xpath = "//span [contains(text(), 'Войти')]/ancestor::a")
    //@FindBy(xpath = "//span [contains(text(), 'Войти')]/../../..")
    private WebElement loginBtn;

    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    /**
     * метод для ввода пароля
     */
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickLoginBtn() {
        loginBtn.click(); }

}
