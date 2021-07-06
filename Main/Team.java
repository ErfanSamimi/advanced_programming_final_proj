package Main;

import Main.Heroes_Package.Heroes;

import java.util.ArrayList;

public class Team {

    ArrayList<GameObjects> gameObjects = new ArrayList<>();

    Castle castle;
    Castle enemyCastle;
    String teamName ;


    public Team(int castleX , int castleY , String teamName ){

        this.teamName = teamName;
        this.castle = new Castle(this , 10000 , 0 , castleX , castleY , 78 , 81 , 84 );
        gameObjects.add(this.castle);


    }

    public void setEnemyCastle(Castle enemyCastle){
        this.enemyCastle = enemyCastle;
    }

    public GameObjects getEnemyCastle(){
        return this.enemyCastle;
    }

    public String getTeamName(){
        return this.teamName;
    }

}
