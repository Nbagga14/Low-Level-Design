package Prototype;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        NetworkConnection networkConnection1 = new NetworkConnection("1","2");
        NetworkConnection networkConnection2 = networkConnection1.clone();
        System.out.println(networkConnection1.getIp());
        System.out.println(networkConnection2.getIp());
        System.out.print(networkConnection1);
        System.out.print(networkConnection2);
    }
}
