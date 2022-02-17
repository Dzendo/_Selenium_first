package ru.cs.tdm365.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

/**
 * При использовании Page Object элементы страниц,
 * а также методы непосредственного взаимодействия с ними,
 * выносятся в отдельный класс.
 */
/**
 * Класс LoginPageTDM, который будет содержать локацию элементов страницы логина
 * и методы для взаимодействия с этими элементами.
 */
class LoginPageTDM(driver: WebDriver) {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    init {
        PageFactory.initElements(driver, this)
    }

    /**
     * определение локатора поля ввода логина
     */
    //@FindBy(xpath = "//input [contains(@id, 'textfield-1054-inputEl')]")
    @FindBy(xpath = "//span[contains(text(),'Пользователь:')]/ancestor::label/following-sibling::div//input") // @FindBy(xpath = "//input[contains(@placeholder,'Пользователь')]")  // Тема 2
    //@FindBy(xpath = "//span[contains(text(),'Пользователь:')]/../../..//input")
    //@FindBy(xpath = "//input [contains(@type, 'text') and contains(@class, 'x-form-field') and contains(@class, 'x-form-required-field')]")
    private val loginField: WebElement? = null

    /**
     * определение локатора поля ввода пароля
     */
    //@FindBy(xpath = "//input [contains(@id,'textfield-1055-inputEl')]")
    // @FindBy(xpath = "//input[contains(@placeholder,'Пароль')]")  // Тема 2
    @FindBy(xpath = "//input[contains(@type, 'password')]") // Тема 1,2
    private val passwdField: WebElement? = null

    /**
     * определение кнопки входа
     */
    //@FindBy(xpath = "//*[@id="button-1060"]")
    //@FindBy(xpath = "//span [contains(@id,'button-1060-btnInnerEl')]/ancestor::a")
    @FindBy(xpath = "//span [contains(text(), 'Войти')]/ancestor::a") //@FindBy(xpath = "//span [contains(text(), 'Войти')]/../../..")
    private val loginBtn: WebElement? = null


    /**
     * метод для ввода логина
     */
    fun inputLogin(login: String?) {
        loginField!!.sendKeys(login)
    }

    /**
     * метод для ввода пароля
     */
    fun inputPasswd(passwd: String?) {
        passwdField!!.sendKeys(passwd)
    }

    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    fun clickLoginBtn() {
        loginBtn!!.click()
    }
}