package Composite.WOComposite;


import java.util.ArrayList;
import java.util.List;

class Product{
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ProductBundle {
    String name;
    List<Product> products = new ArrayList<>();

    public ProductBundle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        double total=0;
        for(Product product:products)
        {
            total=total+product.getPrice();
        }
        return total;
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }
}

public class WOComposite {
    public static void main(String[] args) {

      Product iphone = new Product("iphone",100000);
      Product charger = new Product("charger for iphone mobile",1000);

      ProductBundle productBundle =new ProductBundle("iphone bundle");

      productBundle.addProduct(iphone);
      productBundle.addProduct(charger);

      List<Object> cart = new ArrayList<>();

      cart.add(iphone);
      cart.add(charger);
      cart.add(productBundle);

      for(Object item:cart)
      {
          if(item instanceof Product){
              double price = ((Product) item).getPrice();
              System.out.println(price);
          }
          else if(item instanceof ProductBundle){
              double price =  ((ProductBundle) item).getPrice();
              System.out.println(price);
          }
      }

    }
}
