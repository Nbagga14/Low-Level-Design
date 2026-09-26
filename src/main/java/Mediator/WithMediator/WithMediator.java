package Mediator.WithMediator;

import java.util.ArrayList;
import java.util.List;

interface ATC {
    void requestLanding(Airplane airplane);
}

class AirplaneATC implements ATC {

    private final List<Airplane> airplanes = new ArrayList<>();

    public void registerPlane(Airplane airplane) {
        airplanes.add(airplane);
    }

    @Override
    public void requestLanding(Airplane airplane) {

        System.out.println("Requesting landing for" + airplane);

        for (Airplane plane : airplanes) {
            if (plane != airplane)
                plane.inform();
        }
    }
}

class Airplane {

    private String name;
    private ATC atc;

    public Airplane(String name, ATC atc) {
        this.name = name;
        this.atc = atc;
    }

    public String getName() {
        return name;
    }

    public void inform() {
        System.out.println(name + " is informed: Do not land now!");
    }

    public void requestLanding() { atc.requestLanding(this); }

}

public class WithMediator {
    public static void main(String[] args) {

        AirplaneATC atc = new AirplaneATC();

        Airplane planeA = new Airplane("Plane A", atc);
        Airplane planeB = new Airplane("Plane B", atc);
        Airplane planeC = new Airplane("Plane C", atc);

        atc.registerPlane(planeA);
        atc.registerPlane(planeB);
        atc.registerPlane(planeC);
        planeA.requestLanding();
    }
}
