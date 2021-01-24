
import com.sun.j3d.loaders.objectfile.ObjectFile;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javafx.scene.Scene;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.GeometryUpdater;
import javax.media.j3d.Shape3D;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**

* Render a 3D shape using a 3D rendering engine

* that was written from scratch using AWT for

* graphics operations.

*/

public class MyJava3D extends JFrame{

 private static int     m_kWidth = 400;

 private static int     m_kHeight = 400;



 private RenderingEngine   renderingEngine = new AwtRenderingEngine();

 private GeometryUpdater   geometryUpdater = new RotatingGeometryUpdater();

 private RenderingSurface   renderingSurface;



 public MyJava3D( )

 {

    // load the object file

  Scene scene = null;

  Shape3D shape = null;



  // read in the geometry information from the data file

  ObjectFile objFileloader = new ObjectFile( ObjectFile.RESIZE );



  try

  {

   scene = (Scene) objFileloader.load( "hand1.obj" );

  }

  catch ( Exception e )

  {

   scene = null;

   System.err.println( e );

  }



  if( scene == null )

   System.exit( 1 );



  // retrieve the Shape3D object from the scene

  BranchGroup branchGroup = scene.getSceneGroup( );

  shape = (Shape3D) branchGroup.getChild( 0 );



   // add the geometry to the rendering engine...

   renderingEngine.addGeometry( (GeometryArray) shape.getGeometry() );



   // create a rendering surface and bind the rendering engine

   renderingSurface = new RenderingSurface( renderingEngine,geometryUpdater );



   // start the rendering surface and add it to the content panel

   renderingSurface.start();

   getContentPane().add( renderingSurface );



   // disable automatic close support for Swing frame.

  setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );



  // add the window listener

  addWindowListener(

   new WindowAdapter()

   {

    // handle the system exit window message

    public void windowClosing( WindowEvent e )

    {

     System.exit( 0 );

               }

   }

  );

 }



 public static void main( String[] args )

 {

  MyJava3D myJava3D = new MyJava3D();

           myJava3D.setTitle( "MyJava3D" );

           myJava3D.setSize( 300, 300 );

           myJava3D.setVisible( true );

 }

}