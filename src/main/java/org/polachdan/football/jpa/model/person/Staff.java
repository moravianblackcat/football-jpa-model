package org.polachdan.football.jpa.model.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Staff extends Person {

    @Enumerated(EnumType.STRING)
    @Column(name = "staff_role")
    private StaffRole role;

    public StaffRole getRole() {
        return role;
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }

}
