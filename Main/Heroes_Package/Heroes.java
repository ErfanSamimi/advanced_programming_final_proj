package Main.Heroes_Package;

import Main.GameObjects;
import Main.Team;

public abstract class Heroes extends GameObjects {

    Speed speed ;
    boolean move ;

    public Heroes (Team team , int power , int health , Speed speed , int locationX , int locationY){
        super(team , health , power , locationX , locationY);
        this.speed = speed;
    }


//    void moveHero

}
