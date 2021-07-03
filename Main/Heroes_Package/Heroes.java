package Main.Heroes_Package;

import Main.GameObjects;
import Main.Team;

public abstract class Heroes extends GameObjects {

    Speed speed ;

    public Heroes (Team team , int power , int health , Speed speed){
        super(team , health , power);
        this.speed = speed;
    }



}
