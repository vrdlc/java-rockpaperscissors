import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RPS {
  public static void main(String[] args) {
    staticFileLocation("/public");

    get("/home", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      HashMap model = new HashMap();


      String player = request.queryParams("player");
      String comp = compChoice();
      Boolean results = checkWinner(player, comp);
      model.put("player", player);
      model.put("comp", comp);
      model.put("results", results);
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
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
