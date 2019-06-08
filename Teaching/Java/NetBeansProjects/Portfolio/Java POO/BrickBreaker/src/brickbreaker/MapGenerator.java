package brickbreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author kiyth
 */
public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    
    public MapGenerator(int row, int col){
        map = new int[row][col];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                map[i][j] = 1;
            }
        }
        brickWidth = 540/col;
        brickHeight = 150/row;
    }
    
    public void draw(Graphics2D graph){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] > 0){
                    graph.setColor(Color.white);
                    graph.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
                    
                    //for separed the map
                    graph.setStroke(new BasicStroke(3));
                    graph.setColor(Color.black);
                    graph.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
                }
            }
        }
    }
    
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
