package cz.malubo.konoha.input;

import java.util.ArrayList;

/**
 * A simple input key class.
 * You create a key for your functionality,
 * let's say fire your weapon.
 * You can associate multiple keys to activate fire weapon
 * event now.
 */
public class Key {

	/*
	 * Indicator of being pressed down.
	 */
	private boolean isDown = false;

	/*
	 * Indicator of being released.
	 */
	private boolean wasDown = false;

	/*
	 * List of registered Input.Keys codes associated with this Key.
	 */
	private ArrayList<Integer> keyCodes;

	public Key(int... keyCodes) {
		this.keyCodes = new ArrayList<Integer>(keyCodes.length);
		for (int keyCode : keyCodes) {
			this.keyCodes.add(new Integer(keyCode));
		}
	}

	public void press() {
		this.isDown = true;
	}

	public ArrayList<Integer> getKeyCodes() {
		return this.keyCodes;
	}

	public boolean isDown() {
		return this.isDown;
	}

	public boolean wasDown() {
		boolean result = this.wasDown;
		this.wasDown = false;
		return result;
	}

	public void release() {
		if (this.isDown) {
			this.isDown = false;
			this.wasDown = true;
		}
	}

	public void reset() {
		this.isDown = false;
		this.wasDown = false;
	}
}
