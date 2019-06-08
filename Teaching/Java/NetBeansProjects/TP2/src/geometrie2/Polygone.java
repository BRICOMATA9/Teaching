package geometrie2;

public class Polygone{

    protected Segment[] listSegment;
    protected String nom ="Polygone";

    public String getNom() {
        return nom;
    }

    Polygone(Segment[] list) {
        this.listSegment = new Segment[list.length];
        for (int i = 0; i < list.length; i++)
            this.listSegment[i] = new Segment(list[i].getBeginning(), list[i].getEnding());
    }

    public String toString() {
        String draw = getNom();
        for (int i = 0; i < this.listSegment.length; i++){
            draw+= "\n" + this.listSegment[i];
        }
        return draw;
    }

    public void deplacer(int dx, int dy) {
        for (int i = 0; i < this.listSegment.length; i++)
            (this.listSegment[i]).deplacer(dx, dy);
    }
}
