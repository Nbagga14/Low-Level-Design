package ObserverPattern.WithObserver;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MobileDevice mb = new MobileDevice();
        TV tv = new TV();

        List<Device> devices = new ArrayList<>();

        devices.add(mb);
        devices.add(tv);
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.setDevices(devices);


        weatherStation.setTemp(25);
        mb.showTemp();
        tv.showTemp();

//
        weatherStation.updateTemp(30);

        mb.showTemp();
        tv.showTemp();

        weatherStation.showDevices();
        weatherStation.removeDevice(tv);
        weatherStation.showDevices();

    }
}
