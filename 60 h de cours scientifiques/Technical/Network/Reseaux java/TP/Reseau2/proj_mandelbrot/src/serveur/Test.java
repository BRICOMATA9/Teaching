package serveur;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Test {

    public static int testMandelBrot( double xc, double yc, int iteration ) {
        double xz = 0;
        double yz = 0;
        int i = 0;
        while ( xz * xz + yz * yz < 4 && i < iteration ) {
            double txz = xz;
            xz = xz * xz - yz * yz + xc;
            yz = 2.0 * txz * yz + yc;
            i++;
        }
        return i;
    }

    public static Point transpose( Point p, Point inf, Point sup, Frame f ) {
        double x = p.getAbscisse() * ( sup.getAbscisse() - inf.getAbscisse() ) / f.getLargeur() + inf.getAbscisse();
        double y = p.getOrdonne() * ( sup.getOrdonne() - inf.getOrdonne() ) / f.getHauteur() + inf.getOrdonne();
        return new Point( x, y );
    }

    public static void main( String[] args ) throws Exception {
        Point inf = new Point( -2, -1 );
        Point sup = new Point( 1, 1 );

        Frame cadre = new Frame( 900, 600 );
        int iteration = 50;

        BufferedImage bufferedImage = new BufferedImage( cadre.getLargeur(), cadre.getHauteur(),
                BufferedImage.TYPE_BYTE_GRAY );
        for ( int i = 0; i < cadre.getLargeur(); i++ ) {
            for ( int j = 0; j < cadre.getHauteur(); j++ ) {
                Point p = transpose( new Point( i, j ), inf, sup, cadre );
                if ( testMandelBrot( p.getAbscisse(), p.getOrdonne(), iteration ) == iteration ) {
                    bufferedImage.setRGB( i, j, 0 );
                } else {
                    bufferedImage.setRGB( i, j, 16777215 );
                }
            }
        }
        File file = new File( "mandelbrotset.png" );
        ImageIO.write( bufferedImage, "png", file );
    }
}
