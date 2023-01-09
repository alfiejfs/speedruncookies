package tech.alfiejoe.speedruncookies;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.Remotable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpeedrunCookies {

  private static final String PAGE_URL = "https://cookieconsentspeed.run/";

  private SpeedrunCookies() {
    WebDriver driver = new ChromeDriver();

    driver.get(PAGE_URL);

    JavascriptExecutor executor = (JavascriptExecutor) driver;
    PageFunctions.startFromBeginning(executor);

    performRun(driver);
  }

  public void performRun(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

    for (String buttonText : PageButtons.OPEN_PREFERENCES_BUTTONS) {
      List<WebElement> elements = driver.findElements(By.xpath("//*[text()='" + buttonText + "']"));
      if (!elements.isEmpty()) {
        elements.get(0).click();
        break;
      }
    }

    handleSection(driver, wait, PageButtons.MARKETING_TAB, false);
    handleSection(driver, wait, PageButtons.PERFORMANCE_TAB, true);
    handleSection(driver, wait, PageButtons.STATISTICS_TAB, true);

    for (String buttonText : PageButtons.FINISH_BUTTONS) {
      List<WebElement> elements = driver.findElements(By.xpath("//*[text()='" + buttonText + "']"));
      if (!elements.isEmpty()) {
        elements.get(0).click();
        break;
      }
    }
  }

  private void handleSection(WebDriver driver, WebDriverWait wait, String name, boolean needsClick) {
    WebElement tab = driver.findElement(By.xpath("//*[text()='" + name + "']"))
        .findElement(By.xpath("./.."));

    if (needsClick) {
      tab.click();
    }

    handleTab(tab, wait);
  }

  private void handleTab(WebElement tab, WebDriverWait wait) {
    List<WebElement> tabItems = tab.findElements(By.className(PageButtons.TAB_ITEM));
    for (WebElement tabItem : tabItems) {
      // Ignore reset buttons
      if (tabItem.getText().startsWith(PageButtons.RESET_START)) {
        continue;
      }

      boolean enabled = false;
      for (String start : PageButtons.ENABLE_STARTS) {
        if (tabItem.getText().startsWith(start)) {
          enabled = true;
          break;
        }
      }

      WebElement checkbox = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
              tabItem,
              By.xpath(PageButtons.TAB_INPUT_LOCATION)
      ));

      if (enabled) {
        if (checkbox.isSelected()) {
          checkbox.click();
        }
      } else {
        if (!checkbox.isSelected()) {
          checkbox.click();
        }
      }
    }
  }

  public static void main(String[] args) {
    new SpeedrunCookies();
  }

}