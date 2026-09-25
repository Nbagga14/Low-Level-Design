package AbstractFactory;

// =====================================================
// Product Interface
// =====================================================

interface Logistics {
    void send();
}


// =====================================================
// INDIA PRODUCTS
// =====================================================

class IndianRoad implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by Indian Road logic");
    }
}

class IndianAir implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by Indian Air logic");
    }
}

class IndianTrain implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by Indian Train logic");
    }
}


// =====================================================
// USA PRODUCTS
// =====================================================

class USARoad implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by USA Road logic");
    }
}

class USAAir implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by USA Air logic");
    }
}

class USARail implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by USA Rail logic");
    }
}

// =====================================================
// CANADA PRODUCTS
// =====================================================
class CanadaRoad implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by CANADA Road logic");
    }
}

class CanadaAir implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by CANADA Air logic");
    }
}

class CanadaRail implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by CANADA Rail logic");
    }
}

// =====================================================
// ABSTRACT FACTORY
// =====================================================

interface LogisticsFactory {

    Logistics createRoad();

    Logistics createAir();

    Logistics createTrain();
}


// =====================================================
// INDIA CONCRETE FACTORY
// =====================================================

class IndiaLogisticsFactory implements LogisticsFactory {

    @Override
    public Logistics createRoad() {
        return new IndianRoad();
    }

    @Override
    public Logistics createAir() {
        return new IndianAir();
    }

    @Override
    public Logistics createTrain() {
        return new IndianTrain();
    }
}


// =====================================================
// USA CONCRETE FACTORY
// =====================================================

class USALogisticsFactory implements LogisticsFactory {

    @Override
    public Logistics createRoad() {
        return new USARoad();
    }

    @Override
    public Logistics createAir() {
        return new USAAir();
    }

    @Override
    public Logistics createTrain() {
        return new USARail();
    }
}

// =====================================================
// CANADA CONCRETE FACTORY
// =====================================================

class CANADALogisticsFactory implements LogisticsFactory {

    @Override
    public Logistics createRoad() {
        return new CanadaRoad();
    }

    @Override
    public Logistics createAir() {
        return new CanadaAir();
    }

    @Override
    public Logistics createTrain() {
        return new CanadaRail();
    }
}



// =====================================================
// CLIENT / SERVICE
// =====================================================

class LogisticsService {

    private LogisticsFactory factory;

    public LogisticsService(LogisticsFactory factory) {
        this.factory = factory;
    }

    public void sendByRoad() {
        Logistics logistics = factory.createRoad();
        logistics.send();
    }

    public void sendByAir() {
        Logistics logistics = factory.createAir();
        logistics.send();
    }

    public void sendByTrain() {
        Logistics logistics = factory.createTrain();
        logistics.send();
    }
}


// =====================================================
// MAIN
// =====================================================

public class LogisticsAbstractFactory {

    public static void main(String[] args) {

        // India
        LogisticsFactory indiaFactory =
                new IndiaLogisticsFactory();

        LogisticsService indiaService =
                new LogisticsService(indiaFactory);

        indiaService.sendByRoad();
        indiaService.sendByAir();
        indiaService.sendByTrain();


        System.out.println("----------------");


        // USA
        LogisticsFactory usaFactory =
                new USALogisticsFactory();

        LogisticsService usaService =
                new LogisticsService(usaFactory);

        usaService.sendByRoad();
        usaService.sendByAir();
        usaService.sendByTrain();

        System.out.println("----------------");

        //Canada
        LogisticsFactory canadaFactory =
                new CANADALogisticsFactory();

        LogisticsService canadaService =
                new LogisticsService(canadaFactory);

        canadaService.sendByRoad();
        canadaService.sendByAir();
        canadaService.sendByTrain();
    }
}