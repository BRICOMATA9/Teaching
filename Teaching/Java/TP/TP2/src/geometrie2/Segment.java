package geometrie2;


public class Segment {

    private Point beginning;
    private Point ending;

    Segment(Point beginning, Point ending) {
        this.beginning = new Point(beginning);
        this.ending = new Point(ending);
    }

    public void setBeginning(Point beginning) {
        this.beginning = beginning;
    }

    public void setEnding(Point ending) {
        this.ending = ending;
    }

    public Point getBeginning() {
        return beginning;
    }

    public Point getEnding() {
        return ending;
    }

    public void deplacer(int dx, int dy) {
        beginning.deplacer(dx, dy);
        ending.deplacer(dx, dy);
    }
    
    public Double longueur(){
        return Math.sqrt(Math.pow(this.ending.getY() - this.beginning.getY(),2) + Math.pow(this.ending.getX() - this.beginning.getX(),2));
    }

    public String toString() {
        return " Segment " + beginning + " , " + ending;
    }
}
