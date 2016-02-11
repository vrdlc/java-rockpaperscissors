import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/home");
      assertThat(pageSource()).contains("Rock, Paper, Scissors");
  }
  //
  // @Test
  // public void checkWinner() {
  //   goTo("http://localhost:4567/home");
  //   fill("#player").with("Rock");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Player Choice: Rock");
  // }
}
