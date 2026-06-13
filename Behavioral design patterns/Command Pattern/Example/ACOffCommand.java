// Concrete commands for AC ON and OFF
public class ACOffCommand implements Command {
    private AC ac;
    ACOffCommand(AC ac) {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.off();
    }

    @Override
    public void undo() {
        ac.on();
    }
}
