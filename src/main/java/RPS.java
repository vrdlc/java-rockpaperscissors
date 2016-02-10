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
      String results = checkWinner(player, comp);
      model.put("player", player);
      model.put("comp", comp);
      model.put("results", results);
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
  }

  public static String checkWinner(String player, String comp){
    if (player.equals(comp)){
      return "You tie";
    } else if (player.equals("Rock") && comp.equals("Scissors")) {
      return "You win!";
    } else if (player.equals("Scissors") && comp.equals("Paper")) {
      return "You win!";
    } else if (player.equals("Paper") && comp.equals("Rock")) {
      return "You win!";
    } else {
      return "You Lose";
    }
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
