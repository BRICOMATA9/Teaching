
public class Test {

    public static void main(String[] argv) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(3, 3);
        
        Segment s1 = new Segment(p1, p2);
        Segment s2 = new Segment(p2, p3);
        Segment s3 = new Segment(p3, p4);
        Segment s4 = new Segment(p4, p1);
        
        Segment[] listSegment1 = {s1, s2, s3, s1};
        Segment[] listSegment2 = {s4, s3, s2, s4};
        
        Polygone poly1 = new Polygone(listSegment1);
        Polygone poly2 = new Polygone(listSegment2);
        
        Polygone[] graph = {poly1, poly2};
        for (int i = 0; i < graph.length; i++) {
            System.out.println(graph[i]);
        }
    }
}
