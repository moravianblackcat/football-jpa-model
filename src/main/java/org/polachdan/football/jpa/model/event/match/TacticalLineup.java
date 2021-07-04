package org.polachdan.football.jpa.model.event.match;

public enum TacticalLineup {

    FOURFOURTWO("4-4-2"),
    FIVEFOURONE("5-4-1"),
    FOURFIVEONE("4-5-1");

    private final String name;

    TacticalLineup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
