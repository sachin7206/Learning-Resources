// Concrete commands for AC ON and OFF
public class AConCommand implements Command {
    private AC ac;
    AConCommand(AC ac) {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.on();
    }

    @Override
    public void undo() {
        ac.off();
    }
}
