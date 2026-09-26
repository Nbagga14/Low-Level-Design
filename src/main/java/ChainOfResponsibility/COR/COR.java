package ChainOfResponsibility.COR;


abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler)
    {
        this.nextHandler=nextHandler;
    }

    public abstract void HandleRequest(String requestType);

}

class GeneralSupport extends SupportHandler {

    @Override
    public void HandleRequest(String requestType) {
        if (requestType.equals("general")) {
            System.out.println("Handling general request");
        } else {
            nextHandler.HandleRequest(requestType);
        }
    }
}

class TechnicalSupport extends SupportHandler {

    @Override
    public void HandleRequest(String requestType) {
        if (requestType.equals("technical")) {
            System.out.println("Handling Technical request");
        } else {
            nextHandler.HandleRequest(requestType);
        }
    }
}

class Delivery extends SupportHandler {

    @Override
    public void HandleRequest(String requestType) {
        if (requestType.equals("delivery")) {
            System.out.println("Handling Delivery request");
        } else if (nextHandler != null) {
            nextHandler.HandleRequest(requestType);
        } else {
            System.out.println("DeliverySupport: No handler found for request");
        }
    }
}

public class COR {
    public static void main(String[] args) {
        GeneralSupport generalSupport = new GeneralSupport();
        TechnicalSupport technicalSupport = new TechnicalSupport();
        Delivery delivery = new Delivery();

        generalSupport.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(delivery);
        generalSupport.HandleRequest("delivery");
        generalSupport.HandleRequest("unknown"); // No handler foudn for this request wil be printed
        generalSupport.HandleRequest("general");
        generalSupport.HandleRequest("technical");
    }
}
