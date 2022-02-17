package ru.cs.tdm.kotlingradlejunit5selenium4_22

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

// https://www.jetbrains.com/
class MainPage(driver: WebDriver) {
    @FindBy(css = "a.wt-button_mode_primary")
    lateinit var seeAllToolsButton: WebElement

    // val toolsMenu = element(byXpath("//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']"))
    @FindBy(xpath = "//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']")
    lateinit var toolsMenu: WebElement

    @FindBy(css = "[data-test='site-header-search-action']")
    lateinit var searchButton: WebElement

    init {
        PageFactory.initElements(driver, this)
    }
}
