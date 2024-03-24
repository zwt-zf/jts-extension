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

    static final String strWKTMercator = "PROJCS[\"World_Mercator\","
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
}
