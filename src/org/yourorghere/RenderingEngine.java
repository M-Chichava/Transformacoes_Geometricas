
import java.awt.Graphics;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.GeometryUpdater;
import javax.vecmath.Vector3d;

/**

 * Definition of the RenderingEngine interface. A RenderingEngine

 * can render 3D geometry (described using a Java 3D GeometryArray)

 * into a 2D Graphics context.

 */

public interface RenderingEngine

{

 /**

  * Add a GeometryArray to the RenderingEngine. All GeometryArrays

  * will be rendered.

  */

 public void addGeometry( GeometryArray geometryArray );



 /**

  * Render a single frame into the Graphics.

 */

 public void render( Graphics graphics, GeometryUpdater updater );



 /**

  * Get the current Screen position used by the RenderEngine.

  */

 public Vector3d getScreenPosition();



 /**

  * Get the current View Angle used by the RenderEngine. View

  * angles are expressed in degrees.

  */

 public Vector3d getViewAngle();



 /**

  * Set the current View Angle used by the RenderEngine.

  */

 public void setViewAngle( Vector3d viewAngle );



 /**

  * Get the current View Angle used by the RenderEngine. View

  * angles are expressed in degrees.

  */

 public Vector3d getLightAngle();



 /**

  * Set the current View Angle used by the RenderEngine.

  */

 public void setLightAngle( Vector3d angle );



 /**

  * Set the Screen size used by the RenderEngine.

  */

 public void setScreenSize( int width, int height );



 /**

  * Set the scale used by the RenderEngine.

  */

 public void setScale( double scale );



 /**

  * Get the scale used by the RenderEngine.

  */

 public double getScale();

}