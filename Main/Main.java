package Main;

import Main.Heroes_Package.EarthHero;
import Main.Heroes_Package.FireHero;
import Main.Heroes_Package.IceHero;
import Main.Heroes_Package.WindHero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main() throws FileNotFoundException {

        Team team1 = getTeam("/home/erfan/Projects/Java/Files/FinalProject/team1.txt" , 0 , 0);
        Team team2 = getTeam("/home/erfan/Projects/Java/Files/FinalProject/team2.txt" , 9 , 9);

        team1.enemyCastle = team2.castle;
        team2.enemyCastle = team1.castle;


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    checkingGame(team1 , team2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t.start();

    }

    static Team getTeam(String fileAddress , int numberX , int numberY) throws FileNotFoundException {

        int counter = -1;
        Team team = null;

        FileInputStream fin = new FileInputStream(fileAddress);

        Scanner sc = new Scanner(fin);



        while(sc.hasNextLine()){

            String[] str = sc.nextLine().split(" ");

            if (str.length == 1 )
                counter ++;

            else {

                int x  = Math.abs(numberX -  Integer.parseInt(str[0]));
                int y = Math.abs(numberY - Integer.parseInt(str[1]) );

                if (counter == 0)
                    team = new Team(Integer.parseInt(str[0]), Integer.parseInt(str[1]));

                else if (counter == 1)
                    team.gameObjects.add(new IceHero(team, x , y ));

                else if (counter == 2)
                    team.gameObjects.add(new FireHero(team, x , y ));

                else if (counter == 3)
                    team.gameObjects.add(new WindHero(team, x , y ));

                else if (counter == 4)
                    team.gameObjects.add(new EarthHero(team, x , y ));
            }

        }



        return team;

    }

    static void checkingGame(Team team1 , Team team2) throws InterruptedException {

        for(GameObjects g1 : team1.gameObjects){

            for(GameObjects g2 : team2.gameObjects){
                if (g1.sameLocation(g2))
                    g1.combat(g2);
            }
        }

    }
}
