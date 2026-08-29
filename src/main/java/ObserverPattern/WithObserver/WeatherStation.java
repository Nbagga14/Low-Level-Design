package ObserverPattern.WithObserver;

import ch.qos.logback.classic.joran.sanity.IfNestedWithinSecondPhaseElementSC;

import javax.sound.midi.VoiceStatus;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observer{

    private int temp;

    private List<Device> devices = new ArrayList<>();

    public void setTemp(int temp)
    {
        this.temp=temp;
        notifyDevices(devices);
    }

    public void setDevices(List<Device> deviceList)
    {
        devices=deviceList;
    }

    @Override
    public void updateTemp(int temp) {
          this.temp=temp;
          notifyDevices(devices);
    }

    @Override
    public void notifyDevices(List<Device> deviceList) {
        for(Device device:deviceList)
        {
            device.updateTemperature(temp);
        }
    }

    @Override
    public void removeDevice(Device device) {
        devices.remove(device);
    }

    @Override
    public void showDevices() {

        for (Device device : devices) {
            System.out.print(device + " ");
        }
    }


}
