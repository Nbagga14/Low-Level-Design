package Mediator.WithMediator;
import java.util.ArrayList;
import java.util.List;

interface ATC {
    void requestLanding(Airplane airplane);
}

class AirplaneATC implements ATC {

    private List<Airplane> airplanes = new ArrayList<>();

    public void registerPlane(Airplane airplane) {
        airplanes.add(airplane);
    }

    @Override
    public void requestLanding(Airplane airplane) {
        System.out.println("Requesting landing for " + airplane.getName());
        informOthers(airplane);
    }

    public void informOthers(Airplane plane) {
        for (Airplane airplane : airplanes) {
            if (airplane != plane) {
                System.out.println("Informing " + airplane.getName() + " for landing of " + plane.getName());
            }
        }
    }
}

class Airplane {
    private ATC atc;
    private String name;
    public Airplane(String name,ATC atc) {
        this.atc = atc;
        this.name= name;
    }

    public String getName()
    {
        return name;
    }

}

public class WithMediator {
    public static void main(String[] args) {

        AirplaneATC atc = new AirplaneATC();


        Airplane plane1 = new Airplane("plane1",atc);
        Airplane plane2 = new Airplane("plane2",atc);
        Airplane plane3 = new Airplane("plane3",atc);

        atc.registerPlane(plane1);
        atc.registerPlane(plane2);
        atc.registerPlane(plane3);

        atc.requestLanding(plane1);

    }
}