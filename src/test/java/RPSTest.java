import org.junit.*;
import static org.junit.Assert.*;

public class RPSTest {

  @Test
  public void checkWinner_returnsTrueIfRockBeatsScissors_winner() {
    RPS rpsTest = new RPS();
    assertEquals("You win!", rpsTest.checkWinner("Rock", "Scissors"));
  }

  @Test
  public void checkWinner_returnsTrueIfScissorsBeatsPaper_winner() {
    RPS rpsTest = new RPS();
    assertEquals("You win!", rpsTest.checkWinner("Scissors", "Paper"));
  }

  @Test
  public void checkWinner_returnsTrueIfPaperBeatsRock_winner() {
    RPS rpsTest = new RPS();
    assertEquals("You win!", rpsTest.checkWinner("Paper", "Rock"));
  }

  @Test
  public void checkWinner_returnsTieIfPlayerAndCompChooseTheSameThing_itsATie() {
    RPS rpsTest = new RPS();
    assertEquals("You tie", rpsTest.checkWinner("Paper", "Paper"));
  }

  @Test
  public void compChoice_shouldBeAString_true(){
    RPS rpsTest = new RPS();
    String result = rpsTest.compChoice();
    assertEquals(true, result instanceof String);
  }

  @Test
  public void twoPlayer_returnsTrueifRockBeatsScissors_win() {
    RPS rpsTest = new RPS();
    assertEquals("Player 1 wins", rpsTest.twoPlayer("Rock", "Scissors"));
  }
}









//Rock & Rock, Rock & Paper, Rock & Scissors
//Paper & Paper, Paper & Scissors
//Scissors & Scissors
