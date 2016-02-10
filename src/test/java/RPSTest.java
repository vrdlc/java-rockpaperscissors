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
}









//Rock & Rock, Rock & Paper, Rock & Scissors
//Paper & Paper, Paper & Scissors
//Scissors & Scissors
