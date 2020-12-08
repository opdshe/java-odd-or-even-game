package game.domain;

public class Status {
    public enum State {
        CONTINUE, TERMINATE;
    }

    private State state;

    public Status(Status.State state) {
        this.state = state;
    }

    public void terminate() {
        this.state = State.TERMINATE;
    }

    public boolean isTerminate() {
        return state.equals(State.TERMINATE);
    }
}
