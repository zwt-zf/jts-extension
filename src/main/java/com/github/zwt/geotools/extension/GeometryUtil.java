package com.github.zwt.geotools.extension;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;


public class GeometryUtil{
    protected static final int DEFAULT_SRID = 4326;
    protected static final GeometryFactory DEFAULT_GEOMETRY_FACTORY = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), DEFAULT_SRID);


    /**
     * 一米是多少度（用于粗略的做经纬度和米转换）
     */
    private static final double ONE_METER_DEGREE = 1.048218E-5;

    public static Geometry wktToGeometry(String wkt) throws ParseException {
        return wktToGeometry(DEFAULT_GEOMETRY_FACTORY, wkt);
    }

    public static Geometry wktToGeometry(GeometryFactory geometryFactory, String wkt) throws ParseException {
        WKTReader wktReader = new WKTReader(geometryFactory);
        Geometry geometry = wktReader.read(wkt);
        return geometry;
    }

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
     * create a new linestring with default geometry factory
     * @param coordList
     * @return
     */
    public static LineString createLineString(List<Coordinate> coordList) {
        return createLineString(DEFAULT_GEOMETRY_FACTORY, coordList);
    }


    /**
     * create a point with default geometry factory
     * @param geometryFactory
     * @param coordinate
     * @return
     */
    public static Point createPoint(Coordinate coordinate) {
         return createPoint(DEFAULT_GEOMETRY_FACTORY, coordinate);
    }

    /**
     * create a point
     * @param geometryFactory
     * @param coordinate
     * @return
     */
    public static Point createPoint(GeometryFactory geometryFactory, Coordinate coordinate) {
         return geometryFactory.createPoint(coordinate);
    }



    /**
     * 度 转 米
     * 注意： 粗算，不精确
     * @param degree
     * @return
     */
    public static double degreeToMeter(double degree) {
        return degree / ONE_METER_DEGREE;
    }

    /**
     * 米 转 度
     * 注意： 粗算，不精确
     * @param degree
     * @return
     */
    public static double meterToDegree(double meter) {
        return meter * ONE_METER_DEGREE;
    }
}