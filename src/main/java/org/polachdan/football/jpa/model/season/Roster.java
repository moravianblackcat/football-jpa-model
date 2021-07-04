package org.polachdan.football.jpa.model.season;

import org.polachdan.football.jpa.model.club.Team;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Roster {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roster_seq")
    @SequenceGenerator(name = "roster_generator", sequenceName = "roster_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @OneToMany(mappedBy = "roster")
    private Set<RosterPlayer> players;

    @OneToMany(mappedBy = "roster")
    private Set<RosterStaff> staffs;

    public Long getId() {
        return id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<RosterPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<RosterPlayer> players) {
        this.players = players;
    }

    public Set<RosterStaff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<RosterStaff> staffs) {
        this.staffs = staffs;
    }

}
