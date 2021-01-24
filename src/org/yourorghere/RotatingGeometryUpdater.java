
import java.awt.Graphics;
import javax.media.j3d.Geometry;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.GeometryUpdater;
import javax.vecmath.Vector3d;

/**

 * Implementation of the GeometryUpdater interface

 * that rotates the scene by changing the viewer position

 * and the scale factor for the model.

 */

public class RotatingGeometryUpdater implements GeometryUpdater

{

 long lastFrame = -1;



 public RotatingGeometryUpdater ( )

 {

 }



public boolean update( Graphics graphics, RenderingEngine engine,

 GeometryArray geometry, int index, long frameNumber )

 {

  if ( lastFrame != frameNumber )

  {

    lastFrame = frameNumber;

Vector3d viewAngle = engine.getViewAngle( );

 viewAngle.x += 1;

       engine.setViewAngle( viewAngle );

  }



   return false;

 }

    public void updateData(Geometry gmtr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
