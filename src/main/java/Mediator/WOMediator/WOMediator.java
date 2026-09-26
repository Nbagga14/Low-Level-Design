package Mediator.WOMediator;


class Airplane {

    private String name;
    private Airplane otherPlane;

    public Airplane(String name) {
        this.name = name;
    }

    /*
     * NAIVE APPROACH
     *
     * Direct communication between planes:
     *
     *      Plane A  <---------------->  Plane B
     *         |                           |
     *         | knows about               | knows about
     *         |                           |
     *         +---------------------------+
     *
     * A ko B ka reference chahiye
     * B ko A ka reference chahiye
     */

    public void setOtherPlane(Airplane otherPlane) {
        this.otherPlane = otherPlane;
    }

    public void requestLanding() {

        System.out.println(name + " requested landing.");

        // Plane A directly Plane B ko inform kar raha hai
        otherPlane.inform();
    }

    public void inform() {
        System.out.println(name + " is informed.");
    }
}


public class WOMediator {

    public static void main(String[] args) {

        Airplane planeA = new Airplane("Plane A");
        Airplane planeB = new Airplane("Plane B");

        /*
         * Direct references:
         *
         *      Plane A  <-------->  Plane B
         *
         * A knows B
         * B knows A
         */

        planeA.setOtherPlane(planeB);
        planeB.setOtherPlane(planeA);

        planeA.requestLanding();
    }
}

