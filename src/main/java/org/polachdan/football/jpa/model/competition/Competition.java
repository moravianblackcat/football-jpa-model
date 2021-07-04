package org.polachdan.football.jpa.model.competition;

import org.polachdan.football.jpa.model.season.CompetitionSeason;
import org.polachdan.football.jpa.model.content.Article;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competition_seq")
    @SequenceGenerator(name = "competition_generator", sequenceName = "competition_seq")
    @Column(name = "competition_id")
    private Long id;

    private String name;

    private Integer level;

    @OneToMany(mappedBy = "competition")
    private Set<CompetitionSeason> seasons;

    @Enumerated(EnumType.STRING)
    private Format format;

    @ManyToMany(mappedBy = "competitions")
    private Set<Article> articles;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Set<CompetitionSeason> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<CompetitionSeason> seasons) {
        this.seasons = seasons;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
