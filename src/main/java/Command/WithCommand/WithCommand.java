package Command.WithCommand;

interface Command
{
    void execute();
}

class Light{

    public void TurnOn()
    {
        System.out.println("Turning on Light");
    }

    public void TurnOff()
    {
        System.out.println("Turning Off Light");
    }
}

class LightOnCommand implements Command
{
    private Light light;

    public LightOnCommand(Light light)
    {
        this.light=light;
    }
    @Override
    public void execute() {
        light.TurnOn();
    }
}

class AC{

    public void TurnOn()
    {
        System.out.println("Turning on AC");
    }

    public void TurnOff()
    {
        System.out.println("Turning Off AC");
    }
}

class LightOfCommand implements Command
{
    private Light light;

    public LightOfCommand(Light light)
    {
        this.light=light;
    }
    @Override
    public void execute() {
        light.TurnOff();
    }
}


class ACOnCommand implements Command
{
    private AC ac;
    public ACOnCommand(AC ac)
    {
        this.ac=ac;
    }

    @Override
    public void execute() {
        ac.TurnOn();
    }
}


class Remote
{
    private Command command;


    public Remote(Command command)
    {
        this.command=command;
    }

    public void executeCommand(Command command)
    {
        command.execute();
    }

}


public class WithCommand {
   public static void main(String[] args) {

       Light light = new Light();
       Command command1 = new LightOnCommand(light);
       command1.execute();

       Command command2 = new LightOfCommand(light);
       command2.execute();

       AC ac = new AC();

       Command command3 = new ACOnCommand(ac);
       command3.execute();



    }
}
