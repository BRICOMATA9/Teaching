
public class Triangle implements Forme {

    private Segment segment1;
    private Segment segment2;
    private Segment segment3;

    Triangle(Point p1, Point p2, Point p3) {
        this.segment1 = new Segment(p1, p2);
        this.segment2 = new Segment(p2, p3);
        this.segment3 = new Segment(p3, p1);
    }

    public void draw() {
        segment1.draw();
        segment2.draw();
        segment3.draw();
    }

    public void deplacer(int dx, int dy) {
        segment1.deplacer(dx, dy);
        segment2.deplacer(dx, dy);
        segment3.deplacer(dx, dy);
    }
}
