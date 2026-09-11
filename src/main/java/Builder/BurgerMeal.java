package Builder;

import java.util.ArrayList;
import java.util.List;

public class BurgerMeal {
    private String patty;
    private String bun;

    // option parameters
    private String drink;
    private String side;
    private List<String>toppings;
    private boolean addCheese;

    public BurgerMeal(MealBuilder mealBuilder)
    {
        this.patty=mealBuilder.patty;
        this.bun=mealBuilder.bun;
        this.drink = mealBuilder.drink;
        this.side=mealBuilder.side;
        this.toppings=mealBuilder.toppings;
        this.addCheese=mealBuilder.addCheese;
    }

    public static class MealBuilder{
        private String patty;
        private String bun;

        // optional parameters
        private String drink;
        private String side;
        private List<String>toppings;
        private boolean addCheese;
      public MealBuilder(String patty, String bun){
          this.patty = patty;
          this.bun = bun;
      }

      public MealBuilder addDrink(String drink){
          this.drink = drink;
          return this;
      }
      public MealBuilder addSide(String side)
      {
          this.side=side;
          return this;
      }
      public MealBuilder addToppings(List<String>toppings)
      {
          this.toppings = toppings;
          return this;
      }

      public MealBuilder addCheese(boolean addCheese)
      {
          this.addCheese = addCheese;
          return this;
      }

      public BurgerMeal buildMeal()
      {
          return new BurgerMeal(this);
      }

    }


    public static void main(String[] args) {
          BurgerMeal plainBurger = new MealBuilder("veg","wheat").buildMeal();
          BurgerMeal cheeseBurger =new MealBuilder("veg","wheat").addCheese(true).buildMeal();
          List<String> toppings = new ArrayList<>(List.of("onion","garlic","cucumber"));
          BurgerMeal specialBurger = new MealBuilder("veg","wheat").addCheese(true).addToppings(toppings).buildMeal();

    }

}



