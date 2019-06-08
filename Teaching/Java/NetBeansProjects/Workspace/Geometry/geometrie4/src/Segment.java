
public class Segment implements Forme {

    private Point beginning;
    private Point ending;

    Segment(Point beginning, Point ending) {
        this.beginning = new Point(beginning);
        this.ending = new Point(ending);
    }

    public void deplacer(int dx, int dy) {
        beginning.deplacer(dx, dy);
        ending.deplacer(dx, dy);
    }

    public void draw() {
        System.out.println(" debut = " + beginning + " fin = " + ending);
    }
}
