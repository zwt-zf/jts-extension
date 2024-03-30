package com.github.zwt.geotools.extension;

import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

/**
 * 坐标系相关
 */
public class CoordSystemUtil {

    private static final String strWKTMercator = "PROJCS[\"World_Mercator\","
            + "GEOGCS[\"GCS_WGS_1984\","
            + "DATUM[\"WGS_1984\","
            + "SPHEROID[\"WGS_1984\",6378137,298.257223563]],"
            + "PRIMEM[\"Greenwich\",0],"
            + "UNIT[\"Degree\",0.017453292519943295]],"
            + "PROJECTION[\"Mercator_1SP\"],"
            + "PARAMETER[\"False_Easting\",0],"
            + "PARAMETER[\"False_Northing\",0],"
            + "PARAMETER[\"Central_Meridian\",0],"
            + "PARAMETER[\"latitude_of_origin\",0],"
            + "UNIT[\"Meter\",1]]";


    private static final String strWKTWgs84 = "GEOGCS[\"WGS 84\"," 
            + "DATUM[" + "\"WGS_1984\","
            + "SPHEROID[\"WGS 84\",6378137,298.257223563,AUTHORITY[\"EPSG\",\"7030\"]],"
            + "TOWGS84[0,0,0,0,0,0,0],"
            + "AUTHORITY[\"EPSG\",\"6326\"]],"
            + "PRIMEM[\"Greenwich\",0,AUTHORITY[\"EPSG\",\"8901\"]],"
            + "UNIT[\"DMSH\",0.0174532925199433,AUTHORITY[\"EPSG\",\"9108\"]],"
            + "AXIS[\"Long\",EAST],"
            + "AXIS[\"Lat\",NORTH]," 
            + "AUTHORITY[\"EPSG\",\"4326\"]]";

    /**
	 * 经纬度转WEB墨卡托
	 * @param geom
	 * @return
     * @throws FactoryException 
     * @throws TransformException 
     * @throws MismatchedDimensionException 
	 */
	public static Geometry lonlat2WebMactor(Geometry geom) throws FactoryException,
     MismatchedDimensionException, 
     TransformException{
		CoordinateReferenceSystem mercatroCRS = CRS.parseWKT(strWKTMercator);
        MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, mercatroCRS);
        return JTS.transform(geom, transform);
	}

    public static Geometry webMactor2lonlat(Geometry geom) throws FactoryException,
     MismatchedDimensionException, 
     TransformException{
		CoordinateReferenceSystem wgs84 = CRS.parseWKT(strWKTWgs84);
        CoordinateReferenceSystem mercatroCRS = CRS.parseWKT(strWKTMercator);
        MathTransform transform = CRS.findMathTransform(mercatroCRS, wgs84);
        return JTS.transform(geom, transform);
	}
}
