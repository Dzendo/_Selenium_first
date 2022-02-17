package ru.cs.tdm.cases;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.cs.tdm.data.ConfProperties;
import ru.cs.tdm.pages.MainViewHeaderPage;

import java.time.Duration;

/**
 * при выходе на http://tdms-srv2a:444/client/#objects/ открывает страницу аутентификации;
 * Пользователь производит ввод валидных логина и пароля;
 * Пользователь удостоверяется в успешной аутентификации — об этом свидетельствует имя пользователя в верхнем правом углу окна;
 * Пользователь осуществляет выход из аккаунта путем нажатия на имя пользователя в верхнем правом углу окна с последующим нажатием на кнопку «Выйти…».
 *
 * Тест считается успешно пройденным в случае, когда пользователю удалось выполнить все вышеперечисленные пункты.
 */

public class LoginTest {
    // объявления статических переменных на созданные ранее классы-страницы
    public static LoginTestIn loginTestIn;
    public static LoginTestOut loginTestOut;
    // Сюда же вынесем переменную для драйвера
    public static WebDriver driver;
    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        // определение пути до драйвера и его настройка (берется из файла)
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        // создание экземпляра драйвера (т.к. он объявлен в качестве переменной):
        driver = new ChromeDriver();

        // Создаем экземпляры классов созданных ранее страниц, и присвоим ссылки на них.
        // В качестве параметра указываем созданный перед этим объект driver,
        // который передается конструкторам класса, созданным ранее:
        loginTestIn = new LoginTestIn(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        // задержка на выполнение теста = 10 сек.
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Deprecate 3.14
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // New 4.1.2
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpageTDM")); }

    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void loginTest() {
        loginTestIn.loginTest();
        //получаем отображаемый логин
        //String user = mainViewHeaderPage.getFirstUserName();   // Халтура - button
        //и сравниваем его с логином из файла настроек
        //Assert.assertEquals(ConfProperties.getProperty("loginTDM"), user);
    }
// В этом методе осуществляется вход в меню пользователя
// и нажатие кнопки «Выйти», чтобы разлогиниться.
    @AfterClass
    public static void tearDown() {

    }
}
/**  https://stackoverflow.com/questions/58993667/webdriverwait-is-deprecated-in-selenium-4
 *          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 *         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
 *         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
 */
