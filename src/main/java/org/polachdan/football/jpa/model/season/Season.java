package org.polachdan.football.jpa.model.season;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Season {

    @Id
    @Column(name = "season_name")
    private String name;

    @OneToMany(mappedBy = "season")
    private Set<CompetitionSeason> competitions;

    private Boolean actual;

    @OneToMany(mappedBy = "season")
    private Set<Roster> rosters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CompetitionSeason> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<CompetitionSeason> competitions) {
        this.competitions = competitions;
    }

    public Boolean getActual() {
        return actual;
    }

    public void setActual(Boolean actual) {
        this.actual = actual;
    }

    public Set<Roster> getRosters() {
        return rosters;
    }

    public void setRosters(Set<Roster> rosters) {
        this.rosters = rosters;
    }
}
