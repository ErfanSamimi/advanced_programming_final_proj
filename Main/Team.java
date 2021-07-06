package Main;

import Main.Heroes_Package.Heroes;

import java.util.ArrayList;

public class Team {

    ArrayList<GameObjects> gameObjects = new ArrayList<>();

    GameObjects castle;
    GameObjects enemyCastle;
    String teamName ;


    public Team(int castleX , int castleY , String teamName ){
        this.castle = new GameObjects(this , 10000 , 0 , castleX , castleY , 78 , 81 , 84 );
        gameObjects.add(this.castle);

        this.teamName = teamName;
    }

    public void setEnemyCastle(GameObjects enemyCastle){
        this.enemyCastle = enemyCastle;
    }

    public GameObjects getEnemyCastle(){
        return this.enemyCastle;
    }

    public String getTeamName(){
        return this.teamName;
    }

}
