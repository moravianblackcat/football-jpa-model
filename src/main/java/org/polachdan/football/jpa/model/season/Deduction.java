package org.polachdan.football.jpa.model.season;

import org.polachdan.football.jpa.model.club.Team;

import javax.persistence.*;

@Entity
public class Deduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deduction_generator")
    @SequenceGenerator(name = "deduction_generator", sequenceName = "deduction_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "competition_id", referencedColumnName = "competition_id"),
            @JoinColumn(name = "season_id", referencedColumnName = "season_id")
    })
    private CompetitionSeason competitionSeason;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    private Integer points;

    public Long getId() {
        return id;
    }

    public CompetitionSeason getCompetitionSeason() {
        return competitionSeason;
    }

    public void setCompetitionSeason(CompetitionSeason competitionSeason) {
        this.competitionSeason = competitionSeason;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
