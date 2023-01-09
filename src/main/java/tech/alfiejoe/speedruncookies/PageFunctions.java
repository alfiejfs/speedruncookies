package tech.alfiejoe.speedruncookies;

import org.openqa.selenium.JavascriptExecutor;

public final class PageFunctions {

  private PageFunctions() {
  }

  public static final String RULES_SCRIPT = "rules();";
  public static final String START_SCRIPT = "start();";
  public static final String RESTART_SCRIPT = "restart();";

  public static void startFromBeginning(JavascriptExecutor executor) {
    executor.executeScript(RULES_SCRIPT);
    executor.executeScript(START_SCRIPT);
  }

  public static void restart(JavascriptExecutor executor) {
    executor.executeScript(RESTART_SCRIPT);
  }

}
