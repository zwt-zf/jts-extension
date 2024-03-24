package com.github.zwt.geotools.extension;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;

public class GeometryUtilTest {
    

    @Test
    public void wktToGeometryTest() throws ParseException {
        String wkt = "POINT (0 0)";
        Geometry geom = GeometryUtil.wktToGeometry(wkt);

        Assert.assertNotNull(geom);
        Assert.assertTrue(geom instanceof Point);
    }

    @Test
    public void degreeToMeterTest() {
        double degree = 1.0;
        double meter = GeometryUtil.degreeToMeter(degree);
        System.out.println(meter);
    }

    @Test
    public void meterToDegreeTest() {
        double meter = 5.0;
        double degree = GeometryUtil.meterToDegree(meter);
        System.out.println(degree);
    }

    @Test
    public void createPointTest() {
        Coordinate coordinate = new Coordinate(1.0, 2.0);
        Point point = GeometryUtil.createPoint(coordinate);
        System.out.println(point);
    }

    @Test
    public void createLineStringTest() {
        Coordinate c1 = new Coordinate(1.0, 1.0);
        Coordinate c2 = new Coordinate(1.0, 2.0);

        LineString lineString = GeometryUtil.createLineString(Arrays.asList(c1, c2));
        System.out.println(lineString);
    }
}
