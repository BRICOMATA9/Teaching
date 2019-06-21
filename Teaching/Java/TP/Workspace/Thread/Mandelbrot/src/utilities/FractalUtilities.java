package utilities;

import java.util.ArrayList;
import java.util.List;

import serveurs.ComputingServer;

public class FractalUtilities {
    public static int testMandelBrot( double xc, double yc, int iteration ) {
        double xz = 0;
        double yz = 0;
        int i = 0;
        while ( xz * xz + yz * yz <= 4 && i < iteration ) {
            double txz = xz;
            xz = xz * xz - yz * yz + xc;
            yz = 2.0 * txz * yz + yc;
            i++;
        }
        return i;
    }

    public static Point transpose( int abs, int ord, Point inf, Point sup, Frame f ) {
        double x = abs * ( sup.getAbscisse() - inf.getAbscisse() ) / f.getLargeur() + inf.getAbscisse();
        double y = ord * ( sup.getOrdonne() - inf.getOrdonne() ) / f.getHauteur() + inf.getOrdonne();
        return new Point( x, y );
    }

    public static List<Pixel> getFractalPixels( int blockId, FractalRequest request, Frame cadre ) {
        List<Pixel> pixels = new ArrayList<Pixel>();
        int x = blockId % ComputingServer.HORIZONTAL_DIV;
        int hpad = cadre.getLargeur() / ComputingServer.HORIZONTAL_DIV;
        x *= hpad;
        int y = blockId / ComputingServer.HORIZONTAL_DIV;
        int vpad = cadre.getHauteur() / ComputingServer.VERTICAL_DIV;
        y *= vpad;
        for ( int i = x; i < x + hpad; i++ ) {
            for ( int j = y; j < y + vpad; j++ ) {

                Pixel pixel;
                Point point = transpose( i, j, request.getInfGauche(), request.getSupDroit(), cadre );
                int val = testMandelBrot( point.getAbscisse(), point.getOrdonne(), request.getIteration() );
                pixel = new Pixel( i, j, val );
                pixels.add( pixel );
            }
        }
        return pixels;
    }
}
