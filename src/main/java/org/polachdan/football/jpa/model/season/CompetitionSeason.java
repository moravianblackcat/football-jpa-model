package org.polachdan.football.jpa.model.season;

import org.polachdan.football.jpa.model.competition.Competition;
import org.polachdan.football.jpa.model.event.match.Match;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class CompetitionSeason {

    @EmbeddedId
    private CompetitionSeasonKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("seasonId")
    @JoinColumn(name = "season_id")
    private Season season;

    private Integer promotion;

    private Integer playoff;

    private Integer playout;

    private Integer relegation;

    @OneToMany(mappedBy = "competitionSeason")
    private Set<Deduction> deductions;

    @OneToMany(mappedBy = "competitionSeason")
    private Set<Match> matches;

    @Embeddable
    private static class CompetitionSeasonKey implements Serializable {

        @Column(name = "competition_id")
        private Long competitionId;

        @Column(name = "season_id")
        private Long seasonId;

        public Long getCompetitionId() {
            return competitionId;
        }

        public void setCompetitionId(Long competitionId) {
            this.competitionId = competitionId;
        }

        public Long getSeasonId() {
            return seasonId;
        }

        public void setSeasonId(Long seasonId) {
            this.seasonId = seasonId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompetitionSeasonKey)) return false;
            CompetitionSeasonKey that = (CompetitionSeasonKey) o;
            return competitionId.equals(that.competitionId) &&
                    seasonId.equals(that.seasonId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(competitionId, seasonId);
        }
    }

}
