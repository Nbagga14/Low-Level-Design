package Extras.CommandPattern.ObserverPattern.WithoutObserver;

class Device{
    protected int temp;

    public void updateTemperature(int temp)
    {
        this.temp=temp;
    }

}

class MobileDevice extends Device{
    public void showTemp()
    {
        System.out.println(" Mobile device shows temperature: " + temp);
    }
}

class TV extends Device{
    public void showTemp()
    {
        System.out.println(" TV device shows temperature: " + temp);
    }
}


public class WOObserver {

    private int temp;
    public void updateTemperature(int temp)
    {
        this.temp=temp;
        notifyDevices();
    }
    MobileDevice mobileDevice = new MobileDevice(); // problematic code as later can be more devices. Also we might want to unsubsrcibe so this mpl has to be changed.
    TV tv = new TV();

    public void notifyDevices()
    {
        mobileDevice.updateTemperature(temp);
        mobileDevice.showTemp();
        tv.updateTemperature(temp);
        tv.showTemp();
    }

}


