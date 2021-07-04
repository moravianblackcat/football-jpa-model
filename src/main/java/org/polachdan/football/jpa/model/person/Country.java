package org.polachdan.football.jpa.model.person;

import org.polachdan.football.jpa.model.club.Club;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Country {

    @Id
    @Column(name = "iso_code")
    private String id;

    @Column(name = "country_name")
    private String name;

    // needs validation here
    @Column(name = "country_icon_url")
    private String iconUrl;

    @OneToMany(mappedBy = "nationality")
    private Set<Person> persons;

    @OneToMany(mappedBy = "country")
    private Set<Club> clubs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

}
