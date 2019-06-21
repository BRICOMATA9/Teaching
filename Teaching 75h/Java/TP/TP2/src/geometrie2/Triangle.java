package geometrie2;

public class Triangle extends Polygone {
    
    private Double perimetre;
    private Double surface;
    private String nom ="Triangle";

    public String getNom() {
        return nom;
    }

    public void setPerimetre(Double perimetre) {
        this.perimetre = perimetre;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public Double getPerimetre() {
        return perimetre;
    }

    public Double getSurface() {
        return surface;
    }
    
    public Double calculePerimetre() {
        return listSegment[1].longueur() + listSegment[2].longueur() +listSegment[3].longueur();
    }

    public Double calculeSurface() {
        return Math.sqrt(
                (perimetre/2) * (
                    (perimetre/2-listSegment[1].longueur())* 
                    (perimetre/2-listSegment[2].longueur())*
                    (perimetre/2-listSegment[3].longueur())
                )
            );
    }

    Triangle(Segment[] list) {
        super(list);
    }

    public String toString() {
        return super.toString();
    }

    public void deplacer(int dx, int dy) {
        super.deplacer(dx, dy);
    }
}
