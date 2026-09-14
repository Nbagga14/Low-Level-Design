package Decorator.WithDecorator;

interface Burger{
    int getCost();
}


class PlainBurger implements Burger{
   protected int cost;

   public PlainBurger(int cost)
   {
       this.cost=cost;
   }

    @Override
    public int getCost() {
     return cost;
    }

}

abstract class BurgerDecorator implements Burger{

    protected Burger burger;
    public BurgerDecorator(Burger burger)
    {
        this.burger=burger;
    }
}

class CheeseBurger extends BurgerDecorator{

    public CheeseBurger(Burger burger) {
        super(burger);
    }

    @Override
    public int getCost() {
        return burger.getCost() + 20;
    }

}


public class Decorator {

    public static void main(String[] args) {

        Burger plainBurger = new PlainBurger(100);
        plainBurger.getCost();
        System.out.println("Plain burger cost is " + plainBurger.getCost());

        Burger cheeseBurger = new CheeseBurger(plainBurger);
        System.out.println("Cheese burger cost is "+ cheeseBurger.getCost());

    }
}
