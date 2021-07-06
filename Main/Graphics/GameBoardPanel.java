package Main.Graphics;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameBoardPanel extends JPanel {

    public static Color defaultColor = new Color(250, 131, 131);

    JButton[][] buttons = new JButton[10][10];

    public GameBoardPanel(){
        initMyFrame();
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    myFunction();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

//        t.start();
    }

    void initMyFrame(){


        this.setLayout(new GridLayout(10 , 10 , 2 , 2));
        this.setPreferredSize(new Dimension( 700,700));
        for (int i=0 ; i<this.buttons.length ; i++){
            for (int j=0 ; j<buttons[i].length ; j++){
                JButton b = new JButton();
                b.setText("");
                b.setSize(35,35);
                b.setBackground(defaultColor);
                this.buttons[i][j] = b;
                this.add(b);
            }
        }




    }

    public void changeColor(int x , int y , Color color , String name){
        this.buttons[x][y].setBackground(color);
        this.buttons[x][y].setText(name);
    }


//    void myFunction() throws InterruptedException {
//
////        while (true){
////
////            for (int i=0 ; i<buttons.length ; i++){
////                for(int j=0 ; j<buttons[i].length ; j++){
////                    Thread.sleep(100);
////                    buttons[i][j].setBackground(randomColor());
////                }
////            }
////        }
//
//
//
//        while (true){
//
//            Thread.sleep(20);
//
//            Random rand = new Random();
//            int x = Math.abs(rand.nextInt()%10);
//            int y =Math.abs(rand.nextInt()%10);
//
//            buttons[x][y].setBackground(randomColor());
//
//        }
//
//
//    }
//
//    Color randomColor(){
//        Random rand = new Random();
//        float r = rand.nextFloat();
//        float g = rand.nextFloat();
//        float b = rand.nextFloat();
//
//        return  new Color(r, g, b);
//
//    }


    public static void main(String [] args){

        GameBoardPanel f = new GameBoardPanel();
//        f.setVisible(true);


    }

}

