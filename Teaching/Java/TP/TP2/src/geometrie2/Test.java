package geometrie2;


public class Test {

    public static void main(String[] argv) {
        
        Point p1 = new Point(3, 5);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(0, 2);
        
        System.out.println(p1);
        System.out.println(p2);
        
        Segment s1 = new Segment(p1, p2);
        Segment s2 = new Segment(p2, p3);
        Segment s3 = new Segment(p3, p1);
        
        Segment[] listSegment1 = {s1, s2, s3, s1};

        
//        Point p2 = new Point(0, 2);
//        Point p3 = new Point(1, 1);
//        
//        Segment s1 = new Segment(p1, p2);
//        Segment s2 = new Segment(p2, p3);
//        Segment s3 = new Segment(p3, p1);
//        
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
        
//        Segment[] listSegment1 = {s1, s2, s3, s1};
//        
//        Polygone poly1 = new Polygone(listSegment1);
//        
//        Polygone[] graph = {poly1};
//        for (int i = 0; i < graph.length; i++) {
//            System.out.println(graph[i]);
//        }
//        
//        poly1.deplacer(2, 2);
//        
//        Segment[] listSegment2 = {s1, s2, s3};
//        Polygone poly2 = new Triangle(listSegment2);
//        System.out.println(poly2);
        
    }
}
