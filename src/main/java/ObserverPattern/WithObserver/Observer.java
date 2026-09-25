package ObserverPattern.WithObserver;

import java.util.List;

public interface Observer {

    public void updateTemp(int temp);

    public void notifyDevices(List<Device> deviceList);

    public void removeDevice(Device device);

    public void showDevices();

}
