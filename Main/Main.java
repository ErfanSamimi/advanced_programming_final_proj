package Main;

import Main.Graphics.GameFrame;
import Main.Heroes_Package.*;
import org.w3c.dom.ls.LSOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static   GameFrame gameFrame = new GameFrame();

    public static boolean gameFinished = false;

    public static void main(String[] args) throws FileNotFoundException {


        gameFrame.setVisible(true);

        Team team1 = getTeam("/home/erfan/Projects/Java/Files/FinalProject/team1.txt" , 0 , 0 , "team 1");
        Team team2 = getTeam("/home/erfan/Projects/Java/Files/FinalProject/team2.txt" , 9 , 9 , "team 2");

        team1.enemyCastle = team2.castle;
        team2.enemyCastle = team1.castle;

        addHeroes(team1 ,"/home/erfan/Projects/Java/Files/FinalProject/team1.txt" , 0 , 0  );
        addHeroes(team2 ,"/home/erfan/Projects/Java/Files/FinalProject/team2.txt" , 9 , 9  );


//        Team team1 = new Team(0,0 , "team 1");
//        team1.castle.name = "Team1 castle";
//
//        Team team2 = new Team(9,9 , "team 2");
//        team2.castle.name = "Team2 castle";
//
//        team1.enemyCastle = team2.castle;
//        team2.enemyCastle = team1.castle;
//
//        IceHero ice1 = new IceHero(team1 , 5 , 4 );
//        ice1.name = "Ice 1";
//        IceHero ice2 = new IceHero(team2 , 0 , 1 );
//        ice2.name = "Ice 2";
//        FireHero f1 = new FireHero(team1 , 2 , 3);
//        f1.name = "Fire 1";
//
//        team1.gameObjects.add(ice1);
//        team2.gameObjects.add(ice2);
//        team1.gameObjects.add(f1);


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



    static Team getTeam(String fileAddress , int numberX , int numberY , String name) throws FileNotFoundException {

//        int counter = -1;
//        Team team = null;

        FileInputStream fin = new FileInputStream(fileAddress);

        Scanner sc = new Scanner(fin);

        sc.nextLine();

        String[] str = sc.nextLine().split(" ");

        int x  = Math.abs(numberX -  Integer.parseInt(str[0]));
        int y = Math.abs(numberY - Integer.parseInt(str[1]) );

        Team team = new Team(x, y , name);

        return team;

    }


    static void addHeroes(Team team , String address , int numberX , int numberY) throws FileNotFoundException {

        FileInputStream fin = new FileInputStream(address);
        Scanner sc = new Scanner(fin);

        sc.nextLine();
        sc.nextLine();


        int counter = 0 ;

        while(sc.hasNextLine()){

            String[] str = sc.nextLine().split(" ");

            if (str.length == 1 )
                counter ++;

            else {

                int x  = Math.abs(numberX -  Integer.parseInt(str[0]));
                int y = Math.abs(numberY - Integer.parseInt(str[1]) );



                if (counter == 1)
                    team.gameObjects.add(new IceHero(team, x , y ));

                else if (counter == 2)
                    team.gameObjects.add(new FireHero(team, x , y ));

                else if (counter == 3)
                    team.gameObjects.add(new WindHero(team, x , y ));

                else if (counter == 4)
                    team.gameObjects.add(new EarthHero(team, x , y ));
            }

        }


    }





    static void checkingGame(Team team1 , Team team2) throws InterruptedException {
        boolean continueChecking = true;

        while (continueChecking) {

//            System.out.println("*");

//            System.out.println(team1.castle.killed);
            if (team1.castle.killed) {
                System.out.println("-*-*-*-*-*-*-*-* Team 1 lose the game -*-*-*-*-*-*-*-* ");
                continueChecking = false;
            }

//            System.out.println(team2.castle.killed);
            if (team2.castle.killed) {
                System.out.println("-*-*-*-*-*-*-*-* Team 2 lose the game -*-*-*-*-*-*-*-*");
                continueChecking = false;
            }

//            System.out.println("++");
            for (GameObjects g1 : team1.gameObjects) {

                for (GameObjects g2 : team2.gameObjects) {

                    if (g1.sameLocation(g2) && !g1.killed && !g2.killed &&!g1.combating   ) {
//                        System.out.println("-----");
                        g1.combating = true;
                        g2.combating = true;

                        Thread t = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*");
                                try {
                                    g1.combat(g2);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        t.start();


                    }
                }

            }


        }

            gameFinished = true;

//        System.out.println("++ finished");

    }
}
