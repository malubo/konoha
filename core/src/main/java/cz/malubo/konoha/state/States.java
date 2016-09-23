package cz.malubo.konoha.state;

public enum States {
    SPLASH("SPLASH"),
    MAIN_MENU("MAIN_MENU"),
    IN_GAME("IN_GAME");

    private String name;

    private States(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}