package org.polachdan.football.jpa.model.club;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stadium_generator")
    @SequenceGenerator(name = "stadium_generator", sequenceName = "stadium_seq")
    @Column(name = "stadium_id")
    private Long id;

    @Column(name = "stadium_name")
    private String name;

    private Integer capacity;

    @Column(name = "stadium_city")
    private String city;

    @OneToMany(mappedBy = "stadium")
    private Set<Club> clubs;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }
}
