package Main;

import Main.Graphics.GameBoardPanel;
import Main.Graphics.GameFrame;
import Main.Heroes_Package.*;

import java.awt.*;
import java.io.Serializable;

public abstract class GameObjects implements Serializable {

    static int number = 1;

    private int health ;
    private int power ;
    private Team team;
    private int locationX;
    private int locationY;
    boolean continueCombat = true;
    boolean killed = false ;
    public String name;
    boolean combating = false ;
//    Object lockObj = new Object();
    public Color color;

    public GameObjects(Team team , int health , int power , int locationX , int locationY , int red , int green , int blue){
        this.health = health ;
        this.power = power ;
        this.team = team;
        this.locationX = locationX ;
        this.locationY = locationY;
        this.color = new Color(red , green , blue);
        Main.gameFrame.changeColor(locationX , locationY , this.color , team.getTeamName());

        if(this instanceof IceHero)
            this.name = team.teamName + " IceHero " + number;
        else if (this instanceof EarthHero)
            this.name = team.teamName + " Earth Hero " + number;
        else if (this instanceof WindHero)
            this.name = team.teamName + " wind hero " + number;
        else if (this instanceof FireHero)
            this.name = team.teamName + " fire Hero " + number;
        else
            this.name = team.teamName + " Castle";

        number ++;
    }



    public void combat( GameObjects enemy ) throws InterruptedException {




        if ( !(this  instanceof  Castle)) {
            ((Heroes) this).move = false;
//            this.combating = true;
        }

        if (!(enemy instanceof Castle)) {
            ((Heroes) enemy).move = false;
//            enemy.combating =true;
        }

//        System.out.println(enemy.combating);
//        System.out.println(this.combating);

        //-------------------------------------------------



        while (continueCombat && ! Main.gameFinished ){





//            synchronized (lockObj) {
            System.out.println("++++  " + this.name + " and " + enemy.name + " combating | " + this.name + " Health : " + this.health + " | " + enemy.name + " Health : " + enemy.health  );
            this.health -= enemy.power;

            Main.gameFrame.changeColor(locationX ,locationY , new Color(187, 0, 255), "");

            Thread.sleep(2000);

            enemy.health -= this.power;





//            }

            if(this.health<=0 ){
                this.killed = true;
//                this.team.gameObjects.remove(this);

                System.out.println("x");
                enemy.combating = false;
                continueCombat = false;
                Main.gameFrame.changeColor(this.locationX ,this.locationY , GameBoardPanel.defaultColor , "");
            }

            if (enemy.health <=0){
                enemy.killed = true;
                System.out.println("x");

//                enemy.team.gameObjects.remove(enemy);
                this.combating = false;
                continueCombat = false;
                Main.gameFrame.changeColor(enemy.locationX ,enemy.locationY , GameBoardPanel.defaultColor , "");
            }

            Main.gameFrame.updateTeamsStatus(this.team , enemy.team);

        }

        //-------------------------------------------------

        if (this instanceof Heroes && ! this.killed )
            ((Heroes) this).move = true;

        if (enemy instanceof Heroes && ! enemy.killed)
            ((Heroes) enemy).move = true;

//        Main.gameFrame.changeColor(this.locationX ,this.locationY , GameBoardPanel.defaultColor , "");

        continueCombat = true ;
    }

    public void setLocation(int x , int y){
        this.locationY = y ;
        this.locationX = x ;
    }

    public int[] getLocation(){
        int[] location = new int[2];

        location[0] = this.locationX;
        location[1] = this.locationY;

        return location ;
    }

    public Team getTeam(){
        return this.team;
    }

    public void kill(){
        this.killed = true;
    }

    public boolean isKilled(){
        return this.killed;
    }

    public boolean sameLocation(GameObjects obj){

        if (this.locationY == obj.locationY && this.locationX == obj.locationX)
            return true;

        return false;
    }

    public int getHealth(){
        return this.health;
    }

}
