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

    public String getTeamStatus(){

        String str = "";
        str += "Team Number : "+ this.teamName + "\n";


        for (GameObjects g : this.gameObjects){

            if (g.killed)
                continue;

            if(g instanceof EarthHero)
                str += "Earth Hero Health : " + g.getHealth() + "\n" ;

            else if ( g instanceof FireHero)
                str += "Fire Hero Health : " + g.getHealth() + "\n" ;

            else if (g instanceof IceHero)
                str += "Ice Hero Health : " + g.getHealth() + "\n" ;

            else if (g instanceof WindHero)
                str += "Wind Hero Health : " + g.getHealth() + "\n" ;

            else
                str += "Castle Health : " + g.getHealth() + "\n" ;
        }

        return str;

    }

}
