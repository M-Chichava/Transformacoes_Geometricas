package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;



/**
 * Transf_Geometricas.java <BR>
 * author: Grupo 2
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Transf_Geometricas implements GLEventListener {

    public static void main(String[] args) {
       
        //Criar Frame
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Transf_Geometricas());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // frame Central
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Limpar a area de desenho
        
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Resenta a actual matriz para "identidade"
        gl.glLoadIdentity();

        // Move o cursor de desenho
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);

        // Desenho de triangulo
        
        gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1.0f, 0.0f, 0.0f);    // Set the current drawing color to red
            gl.glVertex3f(0.0f, 1.0f, 0.0f);   // Top
            gl.glColor3f(0.0f, 1.0f, 0.0f);    // Set the current drawing color to green
            gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
            gl.glColor3f(0.0f, 0.0f, 1.0f);    // Set the current drawing color to blue
            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
        
// Desenho Terminado do Triângulo

        gl.glEnd();

        // Move the "drawing cursor" to another position
        gl.glTranslatef(3.0f, 0.0f, 0.0f);
        // Draw A Quad
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.5f, 0.5f, 1.0f);    // Set the current drawing color to light blue
            gl.glVertex3f(-1.0f, 1.0f, 0.0f);  // Top Left
            gl.glVertex3f(1.0f, 1.0f, 0.0f);   // Top Right
            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
            gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
        // Done Drawing The Quad
        gl.glEnd();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

