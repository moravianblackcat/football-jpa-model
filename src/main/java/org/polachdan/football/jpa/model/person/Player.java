package org.polachdan.football.jpa.model.person;

import org.polachdan.football.jpa.model.event.match.Assist;
import org.polachdan.football.jpa.model.event.match.Card;
import org.polachdan.football.jpa.model.event.match.Goal;
import org.polachdan.football.jpa.model.season.RosterPlayer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player extends Person {

    @Enumerated(EnumType.STRING)
    private PlayerPosition playerPosition;

    @Enumerated(EnumType.STRING)
    private Foot foot;

    private Integer height;

    private Integer weight;

    @OneToMany(mappedBy = "scorer")
    private Set<Goal> goals;

    @OneToMany(mappedBy = "player")
    private Set<Assist> assists;

    @OneToMany(mappedBy = "player")
    private Set<Card> cards;

    @OneToMany(mappedBy = "player")
    private Set<RosterPlayer> rosters;

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Foot getFoot() {
        return foot;
    }

    public void setFoot(Foot foot) {
        this.foot = foot;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    public Set<Assist> getAssists() {
        return assists;
    }

    public void setAssists(Set<Assist> assists) {
        this.assists = assists;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<RosterPlayer> getRosters() {
        return rosters;
    }

    public void setRosters(Set<RosterPlayer> rosters) {
        this.rosters = rosters;
    }

}
