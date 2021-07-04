package org.polachdan.football.jpa.model.club;

import org.polachdan.football.jpa.model.person.Country;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_seq")
    @SequenceGenerator(name = "club_generator", sequenceName = "club_seq")
    @Column(name = "club_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    private Integer founded;

    @Column(name = "club_icon_url")
    private String iconUrl;

    @Column(name = "club_city")
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    private Stadium stadium;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @OneToMany(mappedBy = "club")
    private Set<Team> teams = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Team> getTeams() {
        return teams;
    }

}
