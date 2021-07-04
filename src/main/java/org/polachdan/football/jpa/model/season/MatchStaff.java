package org.polachdan.football.jpa.model.season;

import org.polachdan.football.jpa.model.event.match.MatchDetail;
import org.polachdan.football.jpa.model.person.Staff;
import org.polachdan.football.jpa.model.person.StaffRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class MatchStaff {

    @EmbeddedId
    private MatchStaffKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("matchDetailId")
    @JoinColumn(name = "match_detail_id")
    private MatchDetail matchDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("staffId")
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_staff_role")
    private StaffRole role;

    public MatchStaffKey getId() {
        return id;
    }

    public void setId(MatchStaffKey id) {
        this.id = id;
    }

    public MatchDetail getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetail matchDetail) {
        this.matchDetail = matchDetail;
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

    @Embeddable
    private static class MatchStaffKey implements Serializable {

        @Column(name = "match_detail_id")
        private Long matchDetailId;

        @Column(name = "staff_id")
        private Long staffId;

        public Long getMatchDetailId() {
            return matchDetailId;
        }

        public void setMatchDetailId(Long matchDetailId) {
            this.matchDetailId = matchDetailId;
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
            if (!(o instanceof MatchStaffKey)) return false;
            MatchStaffKey that = (MatchStaffKey) o;
            return matchDetailId.equals(that.matchDetailId) &&
                    staffId.equals(that.staffId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(matchDetailId, staffId);
        }

    }

}
