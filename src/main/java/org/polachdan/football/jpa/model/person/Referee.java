package org.polachdan.football.jpa.model.person;

import org.polachdan.football.jpa.model.season.MatchReferee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Referee extends Person {

    @Column(name = "referee_city")
    private String city;

    @OneToMany(mappedBy = "referee")
    private Set<MatchReferee> matches;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<MatchReferee> getMatches() {
        return matches;
    }

    public void setMatches(Set<MatchReferee> matches) {
        this.matches = matches;
    }

}
