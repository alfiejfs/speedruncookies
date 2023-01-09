package tech.alfiejoe.speedruncookies;

import java.util.Set;

public final class PageButtons {

  private PageButtons() {
  }

  public static final Set<String> OPEN_PREFERENCES_BUTTONS = Set.of(
      "Settings",
      "Customise choices",
      "No, Customise ",
      "Cookie Settings",
      "More Options",
      "Learn More",
      "Details",
      "Set your cookie preferences ",
      "Purposes",
      "Manage Settings",
      "Configure Preferences",
      "Configure Prefences",
      "Preferences",
      "Configure",
      "Manage Cookies",
      "Manage my cookies"
  );

  public static final String TAB_ITEM = "tabItem";
  public static final String TAB_INPUT_LOCATION = ".//input[@type='checkbox']";

  public static final String MARKETING_TAB = "Marketing";
  public static final String PERFORMANCE_TAB = "Performance";
  public static final String STATISTICS_TAB = "Statistics";

  public static final Set<String> ENABLE_STARTS = Set.of(
      "Disallow",
      "Disable",
      "Do not",
      "Close"
  );

  public static final String RESET_START = "Reset";

  public static final Set<String> FINISH_BUTTONS = Set.of(
      "Confirm Selection Only",
      "Accept only selected",
      "Save cookie settings",
      "Save",
      "Confirm my choices",
      "Submit Preferences ",
      "Save & Exit"
  );

}
