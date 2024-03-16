package com.github.zwt.geotools.extension;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Geometry;
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
}
