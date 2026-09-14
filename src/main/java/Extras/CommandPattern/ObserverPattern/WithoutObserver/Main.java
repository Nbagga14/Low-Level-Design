package Extras.CommandPattern.ObserverPattern.WithoutObserver;

public class Main {
    public static void main(String[] args) {

        WOObserver observer = new WOObserver();

        observer.updateTemperature(25);
        observer.updateTemperature(30);

    }
}
