package com.github.zwt.geotools.extension.geom3d;

import java.util.List;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.WKTWriter;

public class Geometry3DUtil {

    /**
     * 给每个坐标点分配z值
     * @param geom
     * @param z
     */
    public static void assignZ(Geometry geom, double[] zArray) {
        if(geom.getCoordinates().length != zArray.length) {
            throw new RuntimeException("zArray参数与geom中的坐标点数量不相同");
        }
        for (int i = 0; i < zArray.length; i++) {
            geom.getCoordinates()[i].z = zArray[i];
        }
    }

    public static String get3DWkt(Geometry geometry) {
        WKTWriter wktWriter = new WKTWriter(3);
        return wktWriter.write(geometry);
    }
}
