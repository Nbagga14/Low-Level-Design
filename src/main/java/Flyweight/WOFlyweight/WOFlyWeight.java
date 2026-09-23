package Flyweight.WOFlyweight;

import java.util.ArrayList;
import java.util.List;

class Tree{
    private int height;
    private int weight;
    private String color;
    private String texture;
    private String name;

    public Tree(int height,int weight,String color,String texture,String name)
    {
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.texture = texture;
        this.name = name;
    }
    public void draw()
    {
        System.out.println("Planting tree with "+height+weight+color+texture+name);
    }
}

class Forest{
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int height,int weight,String color,String texture,String name)
    {
        Tree tree = new Tree(height,weight,color, texture,name);
        trees.add(tree);
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}

public class WOFlyWeight {
    public static void main(String[] args) {
     Forest forest = new Forest();

     for(int i=0;i<100;i++)
     {
         forest.plantTree(i,i,"Green","Rough","OAK");
         forest.draw();
     }

    }
}
