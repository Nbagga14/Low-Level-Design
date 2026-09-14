package Extras.CommandPattern.ObserverPattern.WithObserver;

class Device{
    protected int temp;

    public void updateTemperature(int temp)
    {
        this.temp=temp;
    }

}

class MobileDevice extends Device {
    public void showTemp()
    {
        System.out.println(" Mobile device shows temperature: " + temp);
    }

}

class TV extends Device {
    public void showTemp()
    {
        System.out.println(" TV device shows temperature: " + temp);
    }
}