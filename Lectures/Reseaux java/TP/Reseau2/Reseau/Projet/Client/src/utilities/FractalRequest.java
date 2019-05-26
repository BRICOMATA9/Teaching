package utilities;

import java.util.Map;

import serialization.Creator;
import serialization.MySerializable;
import serialization.SerializerBuffer;

/**
 * Classe representant une requete de fractale
 *
 */
public class FractalRequest implements MySerializable {
    public static final Creator<FractalRequest> CREATOR = FractalRequest::new;
    private int                                 iteration;
    private Point                               infGauche;
    private Point                               supDroit;
    private int                                 ownerId;

    public FractalRequest() {
    }

    public FractalRequest( Point infGauche, Point supDroit, int iteration ) {
        this.infGauche = infGauche;
        this.supDroit = supDroit;
        this.iteration = iteration;
    }

    public Point getInfGauche() {
        return this.infGauche;
    }

    public void setInfGauche( Point infGauche ) {
        this.infGauche = infGauche;
    }

    public Point getSupDroit() {
        return this.supDroit;
    }

    public void setSupDroit( Point supDroit ) {
        this.supDroit = supDroit;
    }

    public int getIteration() {
        return this.iteration;
    }

    public void setIteration( int iteration ) {
        this.iteration = iteration;
    }

    public static FractalRequest request( String url ) {
        Map<String, String> params = HttpUtilities.extractParameters( url );
        if ( params == null )
            return null;
        double Xmin = Double.parseDouble( params.get( "Xmin" ) );
        double Ymin = Double.parseDouble( params.get( "Ymin" ) );
        double Xmax = Double.parseDouble( params.get( "Xmax" ) );
        double Ymax = Double.parseDouble( params.get( "Ymax" ) );
        int iteration = Integer.parseInt( params.get( "Iteration" ) );
        Point infGauche = new Point( Xmin, Ymin );
        Point supDroit = new Point( Xmax, Ymax );
        return new FractalRequest( infGauche, supDroit, iteration );
    }

    @Override
    public String toString() {
        return "Requete du client avec les coordonnées suivantes :" + infGauche.toString() + " et "
                + supDroit.toString() + " et " + iteration + " itérations";
    }

    @Override
    public void serialize( SerializerBuffer ms ) {
        ms.writeInt( iteration );
        ms.writeMySerializable( infGauche );
        ms.writeMySerializable( supDroit );

    }

    @Override
    public void deserialize( SerializerBuffer ms ) {
        this.iteration = ms.readInt();
        this.infGauche = ms.readMySerializable( Point.CREATOR );
        this.supDroit = ms.readMySerializable( Point.CREATOR );
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId( int ownerId ) {
        this.ownerId = ownerId;
    }

}
