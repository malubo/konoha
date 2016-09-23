package cz.malubo.konoha.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import cz.malubo.konoha.state.State;
import cz.malubo.konoha.state.States;
import cz.malubo.konoha.state.SplashState;

import java.util.HashMap;

public abstract class AbstractStateMachine implements StateMachine {

    private State activeState;

    private HashMap<States, State> stateMap = new HashMap<>();

    @Override
    public State getCurrentState() {
        return this.activeState;
    }

    @Override
    public boolean isStateChangeImminent() {
        return false;
    }

    @Override
    public void create() {
        SplashState splashState = new SplashState();
        stateMap.put(States.SPLASH, splashState);

        // set initial state
        this.activeState = splashState;
    }

    @Override
    public void render() {
        // clear the previous frame
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float delta = Gdx.graphics.getDeltaTime();

        if(this.activeState != null) {
            this.activeState.render(delta);
        }
    }

    @Override
    public void resize(int width, int height) {
        this.getCurrentState().resize(width, height);
    }

    @Override
    public void pause() {
        this.getCurrentState().pause();
    }

    @Override
    public void resume() {
        this.getCurrentState().resume();
    }

    @Override
    public void dispose() {
        this.getCurrentState().dispose();
    }
}
