package org.polachdan.football.jpa.model.event.match;

import org.polachdan.football.jpa.model.person.Player;

import javax.persistence.*;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goal_seq")
    @SequenceGenerator(name = "goal_generator", sequenceName = "goal_seq")
    @Column(name = "goal_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player scorer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_detail_id")
    private MatchDetail matchDetail;

    private Integer minute;

    private Boolean own;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Assist assist;

    public Long getId() {
        return id;
    }

    public Player getScorer() {
        return scorer;
    }

    public void setScorer(Player scorer) {
        this.scorer = scorer;
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

    public Boolean getOwn() {
        return own;
    }

    public void setOwn(Boolean own) {
        this.own = own;
    }

    public Assist getAssist() {
        return assist;
    }

    public void setAssist(Assist assist) {
        this.assist = assist;
    }
}
