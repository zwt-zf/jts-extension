package com.github.zwt.geotools.extension;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.PrecisionModel;


public class GeometryUtil{
    private static final GeometryFactory DEFAULT_GEOMETRY_FACTORY = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING));

    /**
     * create a new linestring
     * @param geometryFactory
     * @param coordList
     * @return
     */
    public static LineString createLineString(GeometryFactory geometryFactory, List<Coordinate> coordList) {
        Coordinate[] coodArray = new Coordinate[0];
        coodArray = coordList.toArray(coodArray);
        LineString lineString = geometryFactory.createLineString(coodArray);
        return lineString;
        
    }


    /**
     * create a new linestring
     * @param coordList
     * @return
     */
    public static LineString createLineString(List<Coordinate> coordList) {
        return createLineString(DEFAULT_GEOMETRY_FACTORY, coordList);
    }

}