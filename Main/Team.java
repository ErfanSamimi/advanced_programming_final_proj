package Main;

import Main.Heroes_Package.Heroes;

import java.util.ArrayList;

public class Team {

    ArrayList<GameObjects> gameObjects = new ArrayList<>();

    GameObjects castle;
    GameObjects enemyCastle;

    public Team(int castleX , int castleY){
        this.castle = new GameObjects(this , 10000 , 0 , castleX , castleY );
        gameObjects.add(this.castle);
    }

    public void setEnemyCastle(GameObjects enemyCastle){
        this.enemyCastle = enemyCastle;
    }

    public GameObjects getEnemyCastle(){
        return this.enemyCastle;
    }

}
