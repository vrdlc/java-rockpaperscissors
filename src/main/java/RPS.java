import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RPS {
  public static void main(String[] args) {

  }
  public static Boolean checkWinner(String player, String comp){
    if (player == "Rock" && comp == "Scissors"){
      return true;
    } else if (player == "Scissors" && comp == "Paper") {
      return true;
    } else if (player == "Paper" && comp == "Rock"){
      return true;
    } else {
      return false;
    }
  }
}
