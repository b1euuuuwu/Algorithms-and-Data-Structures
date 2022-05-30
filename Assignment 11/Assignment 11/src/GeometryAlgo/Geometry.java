package GeometryAlgo;

import java.util.Arrays;

public class Geometry {
    public static double cross(Point O, Point A, Point B) {
        return (A.x - O.x) * (B.x - O.x) - (A.y - O.y) * (B.x - O.x);
    }

    public static boolean ccw(Point p, Point q, Point r) {
        return cross(p, q, r) > 0;
    }
    
    public static Point[] convexHull(Point [] P) {
        if (P.length > 2) {
            int n = P.length, upperLength = 0, lowerLength = 0;
            Point [] lowerHull = new Point[n];
            Point [] upperHull = new Point[n];

            Arrays.sort(P);

            // Build lower hull
            lowerHull[0] = P[0];
            lowerHull[1] = P[1];
            lowerLength = 2;
            for (int i = 2; i < n; i++) {
                while (lowerLength >= 2 && 
                        !ccw(lowerHull[lowerLength - 2], lowerHull[lowerLength - 1], P[i])) {
                            lowerLength--;
                }
                lowerHull[lowerLength] = P[i];
                lowerLength++;
            }
            // Build upper hull
            upperHull[0] = P[0];
            upperHull[1] = P[1];
            upperLength = 2;

            for (int i = n - 3; i >= 0; i--) {
                while (upperLength >= 2 &&
                        !ccw(upperHull[upperLength - 2], upperHull[upperLength - 1], P[i])) {
                            upperLength--;
                }
                upperHull[upperLength] = P[i];
                upperLength++;
            }

            // Combine upper and lower hull
            Point[] result = new Point[2 * n];
            int t = 0;
            for (int i = 0; i < lowerLength - 1; i++) {
                result[t] = lowerHull[i];
                t++;
            }
            for (int i = 0; i < upperLength - 1; i++) {
                result[t] = upperHull[i];
                t++;
            }

            if (t > 1) {
                result = Arrays.copyOfRange(result, 0, t);
            }
            return result;
        }
        else if (P.length <= 2) {
            return P.clone();
        }
        else {
            return null;
        }
    }
}