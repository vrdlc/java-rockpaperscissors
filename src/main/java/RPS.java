import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RPS {
  public static void main(String[] args) {

  }
  public static Boolean checkWinner(String player, String comp){
    if (player == "Rock" && comp == "Scissors") {
      return true;
    } else if (player == "Scissors" && comp == "Paper") {
      return true;
    } else if (player == "Paper" && comp == "Rock") {
      return true;
    } else {
      return false;
    }
  }

  public static String checkTie(String player, String comp){
    String tie = "";
    if (player == "Rock" && comp == "Rock" || player == "Paper" && comp == "Paper" || player == "Scissors" && comp == "Scissors"){
      tie = "It's a tie";
    } return tie;
  }

  public static String compChoice(){
    Random compChoiceGenerator = new Random();
    String[] choices = { "Rock", "Paper", "Scissors" };
    int randomizedWord = compChoiceGenerator.nextInt(3);
    String result = "";
    for (int i = 0; i <= choices.length; i++){
      if (i == randomizedWord){
        result = choices[i];
      }
    }
    return result;
  }
}
