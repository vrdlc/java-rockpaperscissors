import org.junit.*;
import static org.junit.Assert.*;

public class RPSTest {

  @Test
  public void checkWinner_returnsTrueIfRockBeatsScissors_true() {
    RPS rpsTest = new RPS();
    assertEquals(true, rpsTest.checkWinner("Rock", "Scissors"));
  }

  @Test
  public void checkWinner_returnsTrueIfScissorsBeatsPaper_true() {
    RPS rpsTest = new RPS();
    assertEquals(true, rpsTest.checkWinner("Scissors", "Paper"));
  }

  @Test
  public void checkWinner_returnsTrueIfPaperBeatsRock_true() {
    RPS rpsTest = new RPS();
    assertEquals(true, rpsTest.checkWinner("Paper", "Rock"));
  }

  @Test
  public void checkTie_returnsTieIfPlayerAndCompChooseTheSameThing_itsATie() {
    RPS rpsTest = new RPS();
    assertEquals("It's a tie", rpsTest.checkTie("Paper", "Paper"));
  }

  @Test
  public void compChoice_shouldBeAString_true(){
    RPS rpsTest = new RPS();
    String result = rpsTest.compChoice();
    assertEquals(true, result instanceof String);
  }

}









//Rock & Rock, Rock & Paper, Rock & Scissors
//Paper & Paper, Paper & Scissors
//Scissors & Scissors
