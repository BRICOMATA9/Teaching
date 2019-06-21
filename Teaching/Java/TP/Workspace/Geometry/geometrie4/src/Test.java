
public class Test {

    public static void main(String[] argv) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(3, 3);
        Triangle t = new Triangle(p1, p2, p3);
        Segment s = new Segment(p3, p4);
        Forme[] graph = {t, s};
        for (int i = 0; i < graph.length; i++) {
            (graph[i]).draw();
        }
    }
}
