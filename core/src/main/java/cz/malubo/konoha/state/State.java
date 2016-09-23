package cz.malubo.konoha.state;

import com.badlogic.gdx.Screen;

public abstract class State implements Screen {

    public static States ID;

    public State(States screenID) {
        State.ID = screenID;
    }

    private States stateResult = null;

    public boolean hasStateResult() {
        return this.getStateResult() != null;
    }

    public States getStateResult() {
        return stateResult;
    }

    public void setStateResult(States stateResult) {
        this.stateResult = stateResult;
    }
}
