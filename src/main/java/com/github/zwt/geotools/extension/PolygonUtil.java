package com.github.zwt.geotools.extension;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;

public class PolygonUtil{
    

    public static Polygon createPolygonFromEnvelope(Envelope envelope) {
        return createPolygonFromEnvelope(GeometryUtil.DEFAULT_GEOMETRY_FACTORY, envelope);
    }

    public static Polygon createPolygonFromEnvelope(GeometryFactory geometryFactory, Envelope envelope) {
        double minX = envelope.getMinX();
        double minY = envelope.getMinY();
        double maxX = envelope.getMaxX();
        double maxY = envelope.getMaxY();

        List<Coordinate> coordList = new ArrayList<>(5);
        coordList.add(new Coordinate(minX, minY));
        coordList.add(new Coordinate(minX,maxY));
        coordList.add(new Coordinate(maxX, maxY));
        coordList.add(new Coordinate(maxX, minY));
        coordList.add(new Coordinate(minX, minY));
        
        return GeometryUtil.createPolygon(coordList);
    }

    /**
     * 确保Polygon中不包含孔洞，如果有，则使用最外侧多边形做Polygon
     * @throws ParseException 
     */
    public static Polygon getPolygonWithoutHole(Polygon polygon) throws ParseException {
        return getPolygonWithoutHole(GeometryUtil.DEFAULT_GEOMETRY_FACTORY, polygon);
    }
    
    /**
     * 确保Polygon中不包含孔洞，如果有，则使用最外侧多边形做Polygon
     * @throws ParseException 
     */
    public static Polygon getPolygonWithoutHole(GeometryFactory geometryFactory, Polygon polygon) throws ParseException {
        int numInteriorRing = polygon.getNumInteriorRing();
        if(numInteriorRing > 0) {
            String wkt = polygon.getExteriorRing().toText();
            wkt = "POLYGON(" + wkt.replace("LINEARRING", "") + "}";
            return (Polygon) GeometryUtil.wktToGeometry(geometryFactory, wkt);
        }
        return polygon;
    }
}