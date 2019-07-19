
public class Polygone{

    private Segment[] listSegment;

    Polygone(Segment[] listSegment) {
        this.listSegment = listSegment;
    }

    public String toString() {
        String draw = "Polygone ";
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
