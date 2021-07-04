package org.polachdan.football.jpa.model.content;

import org.polachdan.football.jpa.model.competition.Competition;
import org.polachdan.football.jpa.model.club.Team;
import org.polachdan.football.jpa.model.event.match.Match;
import org.polachdan.football.jpa.model.person.Person;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
    @SequenceGenerator(name = "article_generator", sequenceName = "article_seq")
    @Column(name = "article_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany
    private Set<Tag> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    private Match match;

    // TODO: fix security issues, db saving and find better entity
//    private Principal author;

    @Column(name = "lead_paragraph")
    private String leadParagraph;

    private String body;

    @Column(name = "datetime_of_publication")
    private OffsetDateTime datetimeOfPublication;

    @Column(name = "datetime_of_creation")
    private OffsetDateTime datetimeOfCreation;

    @ManyToMany
    private Set<Person> persons;

    @ManyToMany
    private Set<Competition> competitions;

    @ManyToMany
    private Set<Team> teams;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public String getLeadParagraph() {
        return leadParagraph;
    }

    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public OffsetDateTime getDatetimeOfPublication() {
        return datetimeOfPublication;
    }

    public void setDatetimeOfPublication(OffsetDateTime datetimeOfPublication) {
        this.datetimeOfPublication = datetimeOfPublication;
    }

    public OffsetDateTime getDatetimeOfCreation() {
        return datetimeOfCreation;
    }

    public void setDatetimeOfCreation(OffsetDateTime datetimeOfCreation) {
        this.datetimeOfCreation = datetimeOfCreation;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

}
