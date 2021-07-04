package org.polachdan.football.jpa.model.season;

import org.polachdan.football.jpa.model.person.Staff;
import org.polachdan.football.jpa.model.person.StaffRole;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class RosterStaff {

    @Id
    private RosterStaffKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rosterId")
    @JoinColumn(name = "roster_id")
    private Roster roster;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("staffId")
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Enumerated(EnumType.STRING)
    @Column(name = "roster_staff_role")
    private StaffRole role;

    @Column(name = "staff_season_start")
    private LocalDate start;

    @Column(name = "staff_season_end")
    private LocalDate end;

    public RosterStaffKey getId() {
        return id;
    }

    public void setId(RosterStaffKey id) {
        this.id = id;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public StaffRole getRole() {
        return role;
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Embeddable
    private static class RosterStaffKey implements Serializable {

        @Column(name = "roster_id")
        private Long rosterId;

        @Column(name = "staff_id")
        private Long staffId;

        public Long getRosterId() {
            return rosterId;
        }

        public void setRosterId(Long rosterId) {
            this.rosterId = rosterId;
        }

        public Long getStaffId() {
            return staffId;
        }

        public void setStaffId(Long staffId) {
            this.staffId = staffId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof RosterStaffKey)) return false;
            RosterStaffKey that = (RosterStaffKey) o;
            return rosterId.equals(that.rosterId) &&
                    staffId.equals(that.staffId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rosterId, staffId);
        }

    }

}
