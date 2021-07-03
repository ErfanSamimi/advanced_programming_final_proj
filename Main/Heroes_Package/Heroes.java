package Main.Heroes_Package;

import Main.GameObjects;
import Main.Team;

public abstract class Heroes extends GameObjects implements Runnable {

    Speed speed ;
    public boolean move = true ;
    boolean kill = false ;


    public Heroes (Team team , int power , int health , Speed speed , int locationX , int locationY ){
        super(team , health , power , locationX , locationY);
        this.speed = speed;
        Thread t = new Thread(this , "move hero");
        t.start();
    }


    void moveHero() throws InterruptedException {

        long sleepTime ;

        if(this.speed.equals(Speed.SLOW))
            sleepTime = 3000;

        else
            sleepTime = 1500;



            if (move){

                int heroLocX = this.getLocation()[0];
                int heroLocY = this.getLocation()[1];

                int enemyLocX = this.getTeam().getEnemyCastle().getLocation()[0];
                int enemyLocY = this.getTeam().getEnemyCastle().getLocation()[1];

                int distanceX = Math.abs(enemyLocX - heroLocX);
                int distanceY = Math.abs(enemyLocY - heroLocY);



                if ( distanceX > distanceY)
                    this.setLocation(heroLocX+1 , heroLocY);

                else
                    this.setLocation(heroLocX , heroLocY+1);


            }

            Thread.sleep(sleepTime);

        }




    @Override
    public void run(){

        while (! isKilled() ){

            try {
                this.moveHero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }



}
