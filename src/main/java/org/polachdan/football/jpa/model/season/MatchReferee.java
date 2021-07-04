package org.polachdan.football.jpa.model.season;

import org.polachdan.football.jpa.model.person.RefereeStatus;
import org.polachdan.football.jpa.model.event.match.MatchDetail;
import org.polachdan.football.jpa.model.person.Referee;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class MatchReferee {

    @EmbeddedId
    private MatchRefereeKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("matchDetailId")
    @JoinColumn(name = "match_detail_id")
    private MatchDetail matchDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("refereeId")
    @JoinColumn(name = "referee_id")
    private Referee referee;

    private RefereeStatus status;

    public MatchRefereeKey getId() {
        return id;
    }

    public void setId(MatchRefereeKey id) {
        this.id = id;
    }

    public MatchDetail getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetail matchDetail) {
        this.matchDetail = matchDetail;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public RefereeStatus getStatus() {
        return status;
    }

    public void setStatus(RefereeStatus status) {
        this.status = status;
    }

    @Embeddable
    private static class MatchRefereeKey implements Serializable {

        @Column(name = "match_detail_id")
        private Long matchDetailId;

        @Column(name = "referee_id")
        private Long refereeId;

        public Long getMatchDetailId() {
            return matchDetailId;
        }

        public void setMatchDetailId(Long matchDetailId) {
            this.matchDetailId = matchDetailId;
        }

        public Long getRefereeId() {
            return refereeId;
        }

        public void setRefereeId(Long refereeId) {
            this.refereeId = refereeId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MatchRefereeKey)) return false;
            MatchRefereeKey that = (MatchRefereeKey) o;
            return matchDetailId.equals(that.matchDetailId) &&
                    refereeId.equals(that.refereeId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(matchDetailId, refereeId);
        }

    }

}
