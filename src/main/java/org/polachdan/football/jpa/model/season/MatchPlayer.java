package org.polachdan.football.jpa.model.season;

import org.polachdan.football.jpa.model.event.match.MatchDetail;
import org.polachdan.football.jpa.model.person.Player;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class MatchPlayer {

    @Id
    private MatchPlayerKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("matchDetailId")
    @JoinColumn(name = "match_detail_id")
    private MatchDetail matchDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "match_shirt_number")
    private Integer shirtNumber;

    @Column(name = "lineup_position")
    private Integer lineupPosition;

    @Column(name = "sub_on")
    private Integer on;

    @Column(name = "sub_off")
    private Integer off;

    private Boolean captain;

    public MatchPlayerKey getId() {
        return id;
    }

    public void setId(MatchPlayerKey id) {
        this.id = id;
    }

    public MatchDetail getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetail matchDetail) {
        this.matchDetail = matchDetail;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Integer getLineupPosition() {
        return lineupPosition;
    }

    public void setLineupPosition(Integer lineupPosition) {
        this.lineupPosition = lineupPosition;
    }

    public Integer getOn() {
        return on;
    }

    public void setOn(Integer on) {
        this.on = on;
    }

    public Integer getOff() {
        return off;
    }

    public void setOff(Integer off) {
        this.off = off;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    private static class MatchPlayerKey implements Serializable {

        @Column(name = "match_detail_id")
        private Long matchDetailId;

        @Column(name = "player_id")
        private Long playerId;

        public Long getMatchDetailId() {
            return matchDetailId;
        }

        public void setMatchDetailId(Long matchDetailId) {
            this.matchDetailId = matchDetailId;
        }

        public Long getPlayerId() {
            return playerId;
        }

        public void setPlayerId(Long playerId) {
            this.playerId = playerId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MatchPlayerKey)) return false;
            MatchPlayerKey that = (MatchPlayerKey) o;
            return matchDetailId.equals(that.matchDetailId) &&
                    playerId.equals(that.playerId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(matchDetailId, playerId);
        }

    }

}
