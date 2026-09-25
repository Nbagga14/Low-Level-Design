package Command.WOCommand;


class Light {

    public void turnOn() {
        System.out.println("Turning on Light");
    }

    public void turnOff() {
        System.out.println("Turning Off Light");
    }
}

class Remote {

    private Light light;

    public Remote(Light light) {
        this.light = light;
    }

    public void turnOnLight() {
        light.turnOn();
    }

    public void turnOffLight() {
        light.turnOff();
    }
}

public class WOCommand {
    public static void main(String[] args) {

        Light light = new Light();

        Remote remote = new Remote(light); // problem is remote now knows its interacting with light so tomorrow if AC needs to be added there will be too many changes

        remote.turnOnLight();
        remote.turnOffLight();
}
}
