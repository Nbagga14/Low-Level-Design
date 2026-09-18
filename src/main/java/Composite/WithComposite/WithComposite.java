package Composite.WithComposite;

import java.util.ArrayList;
import java.util.List;

interface Cart{
    double getTotal();
}

class Product implements Cart {
    private String name;
    private double price;

    Product(String name, double price)
    {
        this.name=name;
        this.price=price;
    }

    @Override
    public double getTotal() {
     return price;
    }
}

class ProductBundle implements Cart{
    private String bundleName;
    private List<Cart> items = new ArrayList<>();

    public void addItem(Cart product)
    {
        items.add(product);
    }

    @Override
    public double getTotal() {
        double total=0;
        for(Cart item:items)
        {
            total += item.getTotal();
        }
        return total;
    }
}

public class WithComposite {

   public static void main(String[] args) {

       Cart phone = new Product("iPhone 15", 10000);
       Cart earbuds = new Product("AirPods", 2000);
       Cart charger = new Product("20W Charger", 1000);

       ProductBundle iphoneCombo = new ProductBundle();
       iphoneCombo.addItem(phone);
       iphoneCombo.addItem(earbuds);
       iphoneCombo.addItem(charger);

       List<Cart> cart = new ArrayList<>();
       cart.add(iphoneCombo);

       double total=0;

       for(Cart item:cart)
       {
           total=total+item.getTotal();
       }
       System.out.println("\nTotal: ₹" + total);
    }
}
