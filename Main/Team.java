package Main;

import Main.Heroes_Package.Heroes;

import java.util.ArrayList;

public class Team {

    ArrayList<Heroes> heroes = new ArrayList<>();

    GameObjects castle;
    GameObjects enemyCastle;

    public Team( GameObjects castle , GameObjects enemyCastle){
        this.castle = castle ;
        this.enemyCastle = enemyCastle ;
    }

    public GameObjects getEnemyCastle(){
        return this.enemyCastle;
    }

}
