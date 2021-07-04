package org.polachdan.football.jpa.model.season;

import org.polachdan.football.jpa.model.person.Player;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class RosterPlayer {

    @EmbeddedId
    private RosterPlayerKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rosterId")
    @JoinColumn(name = "roster_id")
    private Roster roster;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "roster_shirt_number")
    private Integer shirtNumber;

    private Boolean gone;

    private Boolean captain;

    public RosterPlayerKey getId() {
        return id;
    }

    public void setId(RosterPlayerKey id) {
        this.id = id;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
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

    public Boolean getGone() {
        return gone;
    }

    public void setGone(Boolean gone) {
        this.gone = gone;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    @Embeddable
    private static class RosterPlayerKey implements Serializable {

        @Column(name = "roster_id")
        private Long rosterId;

        @Column(name = "player_id")
        private Long playerId;

        public Long getRosterId() {
            return rosterId;
        }

        public void setRosterId(Long rosterId) {
            this.rosterId = rosterId;
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
            if (!(o instanceof RosterPlayerKey)) return false;
            RosterPlayerKey that = (RosterPlayerKey) o;
            return rosterId.equals(that.rosterId) &&
                    playerId.equals(that.playerId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rosterId, playerId);
        }
    }

}
