package serveur;

import java.awt.Image;

import ij.process.ByteProcessor;
import ij.process.ImageProcessor;

public class MandelBrod {

    public static int testMandelbrod( double xc, double yc, int n ) {
        double xz = 0;
        double yz = 0;
        int i = 0;
        while ( xz * xz + yz * yz <= 2 * 2 && i < n ) {
            double txz = xz;
            xz = xz * xz - yz * yz + xc;
            yz = 2.0 * txz * yz + yc;
            i++;
        }
        return i;
    }

    public static void main( String[] args ) {
        ImageProcessor ip = new ByteProcessor( 300, 200 );
        int interation = 5;
        for ( int i = 0; i < 300; i++ ) {
            for ( int j = 0; j < 200; j++ ) {
                int x = 3 * 2 / 300 - 2;
                int y = 2 * j / 200 - 1;
                if ( testMandelbrod( x, y, interation ) == interation ) {
                    ip.putPixel( i, i, 0 );
                } else {
                    ip.putPixel( i, j, 255 );
                }
            }
        }
        Image img = ip.createImage();
        img.getGraphics();
    }

}
