package org.polachdan.football.jpa.model.event.match;

import org.polachdan.football.jpa.model.season.MatchPlayer;
import org.polachdan.football.jpa.model.season.MatchReferee;
import org.polachdan.football.jpa.model.season.MatchStaff;
import org.polachdan.football.jpa.model.club.Stadium;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MatchDetail {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    private Match match;

    @Enumerated(EnumType.STRING)
    @Column(name = "tactical_lineup")
    private TacticalLineup lineup;

    @OneToOne(fetch = FetchType.LAZY)
    private Stadium stadium;

    @OneToMany(mappedBy = "matchDetail")
    private Set<MatchPlayer> players;

    @OneToMany(mappedBy = "matchDetail")
    private Set<MatchStaff> staffs;

    @OneToMany(mappedBy = "matchDetail")
    private Set<Goal> goals;

    @OneToMany(mappedBy = "matchDetail")
    private Set<Card> cards;

    @OneToMany(mappedBy = "matchDetail")
    private Set<MatchReferee> referees;

    public Long getId() {
        return id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public TacticalLineup getLineup() {
        return lineup;
    }

    public void setLineup(TacticalLineup lineup) {
        this.lineup = lineup;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Set<MatchPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<MatchPlayer> players) {
        this.players = players;
    }

    public Set<MatchStaff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<MatchStaff> staffs) {
        this.staffs = staffs;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<MatchReferee> getReferees() {
        return referees;
    }

    public void setReferees(Set<MatchReferee> referees) {
        this.referees = referees;
    }

}
