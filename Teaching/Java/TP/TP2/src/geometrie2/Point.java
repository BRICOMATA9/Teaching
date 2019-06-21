package geometrie2;

public class Point {

    private int x;
    private int y;
    private String nom;
    
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(String nom) {
        new Point();
        this.nom=nom;
    }

    public Point(Point p) {
        
        this.x = p.x;
        this.y = p.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return ("(" + x + "," + y + ")");
    }

    public void deplacer(int dx, int dy) {
        x = this.x + dx;
        y = this.y + dy;
    }
}
