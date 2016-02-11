import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RPS {
  public static void main(String[] args) {
    staticFileLocation("/public");
//Home page
    get("/home", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
//Computer v Player results page
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

//Multiplayer page
    get("/twoplayer", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/twoplayer.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
//Two player result page
    get("/resultstwoplayer", (request, response) -> {
      HashMap model = new HashMap();

      String player1 = request.queryParams("player1");
      String player2 = request.queryParams("player2");
      String resultstwoplayer = twoPlayer(player1, player2);
      model.put("player1", player1);
      model.put("player2", player2);
      model.put("resultstwoplayer", resultstwoplayer);
      model.put("template", "templates/resultstwoplayer.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
  }
//Computer vs Player logic
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

//Multiplayer logic
  public static String twoPlayer(String player1, String player2){
    if (player1.equals(player2)){
      return "Player 1 and Player 2 tie";
    } else if (player1.equals("Rock") && player2.equals("Scissors")){
      return "Player 1 wins";
    } else if (player1.equals("Scissors") && player2.equals("Paper")) {
      return "Player 1 wins";
    } else if (player1.equals("Paper") && player2.equals("Rock")) {
      return "Player 1 wins";
    } else {
      return "Player 2 wins";
    }
  }


}
