package org.polachdan.football.jpa.model.event.match;

import org.polachdan.football.jpa.model.person.Player;

import javax.persistence.*;

@Entity
public class Assist {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    private Goal goal;

    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;

    public Long getId() {
        return id;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
