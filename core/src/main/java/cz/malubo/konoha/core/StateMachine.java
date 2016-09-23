package cz.malubo.konoha.core;

import com.badlogic.gdx.ApplicationListener;
import cz.malubo.konoha.state.State;

public interface StateMachine extends ApplicationListener {
    public State getCurrentState();
    public boolean isStateChangeImminent();
}
