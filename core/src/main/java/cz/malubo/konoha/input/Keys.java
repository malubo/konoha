package cz.malubo.konoha.input;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Keys {

	public ArrayList<Key> keyList = new ArrayList<Key>();
	public HashMap<Integer, Key> keyMap = new HashMap<Integer, Key>();

	public final Key UP = new Key(Input.Keys.UP, Input.Keys.W);
	public final Key DOWN = new Key(Input.Keys.DOWN, Input.Keys.S);
	public final Key RIGHT = new Key(Input.Keys.RIGHT, Input.Keys.D);
	public final Key LEFT = new Key(Input.Keys.LEFT, Input.Keys.A);

	public final Key EXIT = new Key(Input.Keys.ESCAPE);
	public final Key CONFIRM = new Key(Input.Keys.ENTER);
	public final Key SHOOT = new Key(Input.Keys.SPACE);
	public final Key USE = new Key(Input.Keys.C);
	
	public final Key CTRL = new Key(Input.Keys.CONTROL_LEFT, Input.Keys.CONTROL_RIGHT);
	public final Key ALT = new Key(Input.Keys.ALT_LEFT, Input.Keys.ALT_RIGHT);
	public final Key SHIFT = new Key(Input.Keys.SHIFT_LEFT, Input.Keys.SHIFT_RIGHT);
	
	public final Key F = new Key(Input.Keys.F);

	public Keys() {
		this.keyList.add(this.UP);
		this.keyList.add(this.DOWN);
		this.keyList.add(this.RIGHT);
		this.keyList.add(this.LEFT);

		this.keyList.add(this.EXIT);
		this.keyList.add(this.CONFIRM);
		this.keyList.add(this.SHOOT);

		this.keyList.add(this.F);

		for (Key key : this.keyList) {
			for (Integer keyCode : key.getKeyCodes()) {
				this.keyMap.put(keyCode, key);
			}
		}
	}

	public void updateKeys() {
		for (Key key : this.keyMap.values()) {
			for(int i = 0; i < key.getKeyCodes().size(); i++) {
				if(Gdx.input.isKeyPressed(key.getKeyCodes().get(i))) {
					key.press();
					break;
				}
				if(key.isDown() && i == key.getKeyCodes().size() -1) {
					key.release();
				}
			}
		}
	}

	public void resetKeys() {
		for (Key key : this.keyList) {
			key.reset();
		}
	}

}
