package com.github.zwt.geotools.extension;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;

public class CoordSystemUtilTest {

    @Test
    public void lonlat2WebMactorTest() throws Exception {
        String wkt = "Point(116.368904 39.913423)";
        Geometry geom = GeometryUtil.wktToGeometry(wkt);
        Geometry mactorGeom = CoordSystemUtil.lonlat2WebMactor(geom);
        System.out.println(geom);
        System.out.println(mactorGeom);
    }

}