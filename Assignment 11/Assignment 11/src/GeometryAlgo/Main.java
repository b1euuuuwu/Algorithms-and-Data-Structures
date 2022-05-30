package GeometryAlgo;

public class Main {
    public static void main(String[] args) throws Exception {
        Point[] points = new Point[7];
        points[0] = new Point(3.6, 4.5);
        points[1] = new Point(0, 4);
        points[2] = new Point(1.75, 6.75);
        points[3] = new Point(2.4, 3);
        points[4] = new Point(5.6, 5.8);
        points[5] = new Point(0.5, 1.5);
        points[6] = new Point(4.75, 2.1);

        Point[] hull = Geometry.convexHull(points);

        System.out.println("Convex Hull:");
        for (int i = 0; i < hull.length; i++) {
            if (hull[i] != null)
                System.out.println(hull[i]);
        }
    }
}
