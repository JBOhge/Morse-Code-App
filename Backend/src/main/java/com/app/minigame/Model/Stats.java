package com.app.minigame.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="stats")
public class Stats {

	@Id
    @Column(name="id")
    private Integer id;

	@Column(name="username")
    private String username;

    @Column(name="gamesplayed")
    private Integer gamesPlayed;

    @Column(name="game1score")
    private Integer game1score;

    @Column(name="game2score")
    private Integer game2score;

    @Column(name="game3score")
    private Integer game3score;

    @Column(name="game4score")
    private Integer game4score;

    @Column(name="game5score")
    private Integer game5score;

    @Column(name="game6score")
    private Integer game6score;

    @Column(name="game7score")
    private Integer game7score;

    @Column(name="game8score")
    private Integer game8score;

    @Column(name="game9score")
    private Integer game9score;

    @Column(name="game1played")
    private Integer game1played;

    @Column(name="game2played")
    private Integer game2played;

    @Column(name="game3played")
    private Integer game3played;

    @Column(name="game4played")
    private Integer game4played;

    @Column(name="game5played")
    private Integer game5played;

    @Column(name="game6played")
    private Integer game6played;

    @Column(name="game7played")
    private Integer game7played;

    @Column(name="game8played")
    private Integer game8played;

    @Column(name="game9played")
    private Integer game9played;



    public Stats() {

    }

    public Stats(String username,Integer id){
        this.id = id;
        this.username = username;
        this.gamesPlayed = 0;
        this.game1played = 0;
        this.game2played = 0;
        this.game3played = 0;
        this.game4played = 0;
        this.game5played = 0;
        this.game6played = 0;
        this.game7played = 0;
        this.game8played = 0;
        this.game9played = 0;
        this.game1score = 0;
        this.game2score = 0;
        this.game3score = 0;
        this.game4score = 0;
        this.game5score = 0;
        this.game6score = 0;
        this.game7score = 0;
        this.game8score = 0;
        this.game9score = 0;

    }

    //GETTERS

    public String getUsername() {
        return this.username;
    }

    public Integer getTotalGamesPlayed(){
        return this.gamesPlayed;
    }

    public Integer getGame1score(){
        return game1score;
    }
    public Integer getGame2score(){
        return game2score;
    }
    public Integer getGame3score(){
        return game3score;
    }
    public Integer getGame4score(){
        return game4score;
    }
    public Integer getGame5score(){
        return game5score;
    }
    public Integer getGame6score(){
        return game6score;
    }
    public Integer getGame7score(){
        return game7score;
    }
    public Integer getGame8score(){
        return game8score;
    }
    public Integer getGame9score(){
        return game9score;
    }

    public Integer getGameHighScore(Integer gameId){
        switch (gameId){
            case 1:
                return game1score;
            case 2:
                return game2score;
            case 3:
                return game3score;
            case 4:
                return game4score;
            case 5:
                return game5score;
            case 6:
                return game6score;
            case 7:
                return game7score;
            case 8:
                return game8score;
            case 9:
                return game9score;
        }
        return 0;
    }

    public Integer getGamesPlayed(Integer gameId){
        switch (gameId){
            case 1:
                return game1played;
            case 2:
                return game2played;
            case 3:
                return game3played;
            case 4:
                return game4played;
            case 5:
                return game5played;
            case 6:
                return game6played;
            case 7:
                return game7played;
            case 8:
                return game8played;
            case 9:
                return game9played;
        }
        return 0;
    }

    //ADDERS
    public void addGamesPlayed(int gamesPlayed){
        this.gamesPlayed += gamesPlayed;
    }



}
