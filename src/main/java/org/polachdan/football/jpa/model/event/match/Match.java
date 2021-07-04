package org.polachdan.football.jpa.model.event.match;

import org.polachdan.football.jpa.model.content.Article;
import org.polachdan.football.jpa.model.season.CompetitionSeason;
import org.polachdan.football.jpa.model.club.Team;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "match_seq")
    @SequenceGenerator(name = "match_generator", sequenceName = "match_seq")
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private CompetitionSeason competitionSeason;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team home;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team away;

    @Column(name = "datetime_of_start")
    private OffsetDateTime datetimeOfStart;

    private Integer round;

    @Column(name = "home_goals")
    private Integer homeGoals;

    @Column(name = "away_goals")
    private Integer awayGoals;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_the_end")
    private MatchEnd end;

    @OneToOne(
            mappedBy = "match",
            fetch = FetchType.LAZY
    )
    private MatchDetail detail;

    @OneToMany(mappedBy = "match")
    private Set<Article> articles;

    public Long getId() {
        return id;
    }

    public CompetitionSeason getCompetitionSeason() {
        return competitionSeason;
    }

    public void setCompetitionSeason(CompetitionSeason competitionSeason) {
        this.competitionSeason = competitionSeason;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public OffsetDateTime getDatetimeOfStart() {
        return datetimeOfStart;
    }

    public void setDatetimeOfStart(OffsetDateTime datetimeOfStart) {
        this.datetimeOfStart = datetimeOfStart;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public MatchEnd getEnd() {
        return end;
    }

    public void setEnd(MatchEnd end) {
        this.end = end;
    }

    public MatchDetail getDetail() {
        return detail;
    }

    public void setDetail(MatchDetail detail) {
        this.detail = detail;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

}
