package org.polachdan.football.jpa.model.club;

import org.polachdan.football.jpa.model.content.Article;
import org.polachdan.football.jpa.model.event.match.Match;
import org.polachdan.football.jpa.model.season.Roster;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    @SequenceGenerator(name = "team_generator", sequenceName = "team_seq")
    @Column(name = "team_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TeamMark mark;

    @ManyToOne(fetch = FetchType.LAZY)
    private Club club;

    @OneToMany(mappedBy = "home")
    private Set<Match> homeMatches;

    @OneToMany(mappedBy = "away")
    private Set<Match> awayMatches;

    @OneToMany(mappedBy = "team")
    private Set<Roster> rosters;

    @ManyToMany(mappedBy = "teams")
    private Set<Article> articles;

    public Long getId() {
        return id;
    }

    public TeamMark getMark() {
        return mark;
    }

    public void setMark(TeamMark mark) {
        this.mark = mark;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Set<Match> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(Set<Match> homeMatches) {
        this.homeMatches = homeMatches;
    }

    public Set<Match> getAwayMatches() {
        return awayMatches;
    }

    public void setAwayMatches(Set<Match> awayMatches) {
        this.awayMatches = awayMatches;
    }

    public Set<Roster> getRosters() {
        return rosters;
    }

    public void setRosters(Set<Roster> rosters) {
        this.rosters = rosters;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

}
