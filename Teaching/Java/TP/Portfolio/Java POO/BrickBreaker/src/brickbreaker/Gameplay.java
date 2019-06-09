/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author kiyth
 */
public class Gameplay extends JPanel implements KeyListener, ActionListener{
    private boolean play =false;
    private int score = 0;
    private int totalBricks = 21;
    
    private Timer time;
    private int delay =8;
    private int playerX = 310;
    //private int playerY = ;
    
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    
    private MapGenerator mapPlay;
    
    public Gameplay(){
        mapPlay = new MapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay, this);
        time.start();
    }
    
    public void paint(Graphics graph){
        //bacground
        graph.setColor(Color.black);
        graph.fillRect(1, 1, 692, 592);
        
        //score
        graph.setColor(Color.blue);
        
        
        //draw map
        mapPlay.draw((Graphics2D)graph);
        //borders
        graph.setColor(Color.yellow);
        graph.fillRect(0, 0, 3, 592);
        graph.fillRect(0, 0, 3, 592);
        graph.fillRect(0, 0, 3, 592);
        graph.fillRect(0, 0, 3, 592);
        
        //paddle
        graph.setColor(Color.green);
        graph.fillRect(playerX, 550, 100, 8);
        
        //the ball
        graph.setColor(Color.yellow);
        graph.fillOval(ballPosX, ballPosY, 20, 20);
        
        if(totalBricks<=0){
            play= false;
            ballXdir = 0;
            ballYdir = 0;
            graph.setColor(Color.red);
            graph.setFont(new Font("serif", Font.BOLD, 30));
            graph.drawString(" Vous avez Gagnez, Score: "+score, 260, 300);
            
            graph.setFont(new Font("serif", Font.BOLD, 20));
            graph.drawString(" Appuyer sur entre pour recommenecer ", 230, 300);
        }
        
        if(ballPosY>570){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            graph.setColor(Color.red);
            graph.setFont(new Font("serif", Font.BOLD, 30));
            graph.drawString(" Game Over, Score: "+score, 190, 300);
            
            graph.setFont(new Font("serif", Font.BOLD, 20));
            graph.drawString(" Appuyer sur entre pour recommenecer ", 230, 300);
        }
        
        graph.dispose();
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >=600){
            playerX = 600;
            }else{
                moveRight();
            }
        }
        if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX <10){
                playerX = 10;
            }else{
                moveLeft();
            }
        }
        if(ke.getKeyCode()== KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                ballPosX = 120;
                ballPosY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                score = 0;
                totalBricks = 21;
                mapPlay = new MapGenerator(3, 7);
                repaint();
            }
        }
    }

    public void moveRight(){
        play = true;
        playerX +=20;
    }
    
    public void moveLeft(){
        play = true;
        playerX -=20;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        time.start();
        if(play){
            if(new Rectangle(ballPosX, ballPosX, 20,20).intersects(new Rectangle(playerX, 550, 100, 8))){
            ballYdir = -ballYdir;
            }
            
            A: for(int i=0; i<mapPlay.map.length; i++){
                for(int j=0; j<mapPlay.map.length; j++){
                    if(mapPlay.map[i][j] > 0){
                        int brickX = j*mapPlay.brickWidth+80;
                        int brickY = i*mapPlay.brickHeight+50;
                        int brickWidth = mapPlay.brickWidth;
                        int brickHeight = mapPlay.brickHeight;
                        
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle bricRect = rect;
                        if(ballRect.intersects(bricRect)){
                            mapPlay.setBrickValue(0, i, j);
                            totalBricks--;
                            score +=5;
                            
                            if(ballPosX+19 <= bricRect.x || ballPosX +1 >= bricRect.x + bricRect.width){
                                ballXdir = -ballXdir;
                            }else{
                                ballYdir = -ballYdir;
                            }
                        }
                    }
                }
            }
            
            ballPosX += ballXdir;
            ballPosY += ballYdir;
            if(ballPosX < 0){
            ballXdir = -ballXdir;
            }
            if(ballPosY < 0){
            ballYdir = -ballYdir;
            }
            if(ballPosX > 670){
            ballXdir = -ballXdir;
            }
        }
        
        
        repaint();
    }
    
}
