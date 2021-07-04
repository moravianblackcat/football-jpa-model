package org.polachdan.football.jpa.model.event.match;

import org.polachdan.football.jpa.model.person.Player;

import javax.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq")
    @Column(name = "card_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    private MatchDetail matchDetail;

    private Integer minute;

    @Enumerated(EnumType.STRING)
    private CardType type;

    public Long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MatchDetail getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetail matchDetail) {
        this.matchDetail = matchDetail;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

}
