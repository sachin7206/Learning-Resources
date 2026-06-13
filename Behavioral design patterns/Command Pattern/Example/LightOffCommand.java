// Concrete commands for Light ON and OFF
public class LightOffCommand implements Command {
    private Light light;
    LightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
