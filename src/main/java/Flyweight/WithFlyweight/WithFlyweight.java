package Flyweight.WithFlyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tree{
    private int height;
    private int weight;
    private TreeType treeType;

    public Tree(int height,int weight,TreeType treeType)
    {
        this.height=height;
        this.weight=weight;
        this.treeType=treeType;
    }

    public void draw()
    {
        System.out.println("Adding tree with"+height+weight+treeType);
    }

}

class TreeType
{
    private String texture;
    private String color;
    private String name;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }
}


class TreeFactory {

    static Map<String, TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name+color+texture;
        if(!treeTypeMap.containsKey(key))
        {
            treeTypeMap.put(key,new TreeType(name,color,texture));
        }
        return treeTypeMap.get(key);
    }
}



class Forest{

    List<Tree> trees = new ArrayList<>();

    public void plantTree(int height,int weight,String texture,String color,String name)
    {
       Tree tree = new Tree(height,weight,TreeFactory.getTreeType(name,color,texture));
       trees.add(tree);
       tree.draw();
    }

}

public class WithFlyweight {
    public static void main(String[] args) {
        Forest forest = new Forest();

        for (int i = 0; i < 100; i++) {
            forest.plantTree(i, i, "Oak", "Green", "Rough");
        }
    }
}
