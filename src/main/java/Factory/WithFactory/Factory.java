package Factory.WithFactory;

// Logistics Interface
interface Logistics {
    void send();
}

// Class implementing the Logistics Interface
class Road implements Factory.WithFactory.Logistics {
    @Override
    public void send() {
        System.out.println("Sending by road logic");
    }
}

// Class implementing the Logistics Interface
class Air implements Factory.WithFactory.Logistics {
    @Override
    public void send() {
        System.out.println("Sending by air logic");
    }
}

class Train implements Factory.WithFactory.Logistics {
    @Override
    public void send() {
        System.out.println("Sending by train logic");
    }
}

class LogisticsFactory {
    public static Logistics getLogistics(String mode){
        if(mode=="Air")
         return new Air();
        else if(mode=="Road")
         return new Road();
        else if(mode=="Train")
         return new Train();
        else
        throw new IllegalArgumentException("Invalid mode of transport");
    }
}

// Class implementing Logistics Service
class LogisticsService {
    public void send(String mode) {
       Logistics logistics = LogisticsFactory.getLogistics(mode);
       logistics.send();
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        Factory.WithFactory.LogisticsService service = new Factory.WithFactory.LogisticsService();
        service.send("Air");
        service.send("Road");
        service.send("Train");
    }
}
