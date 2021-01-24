package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;



/**
 * Transf_Geometricas.java <BR>
 * author: Grupo 2
 *
 * 
 */
public class Transf_Geometricas implements GLEventListener {

    public static void main(String[] args) {
       
        //Criar Frame
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Transf_Geometricas());
        frame.add(canvas);
        frame.setSize(1920, 1080);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                
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
        // Usa o debug de pipeline
     
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Habilita VSync
        gl.setSwapInterval(1);

        // Configura a área de desenho e o modo de sombreamento
        
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); 
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { 
        
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
        gl.glTranslatef(-2.0f, 0.0f, -6.0f);

        // Desenho de triangulo
        
        gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1.0f, 0.0f, 0.0f);    // Defina a cor do desenho atual para vermelho
            gl.glVertex3f(0.0f, 1.0f, 0.0f);   // Top
            gl.glColor3f(0.0f, 1.0f, 0.0f);    // Set the current drawing color to green
            gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
            gl.glColor3f(0.0f, 0.0f, 1.0f);    // Set the current drawing color to blue
            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
        
        // Desenho Terminado do Triângulo

        gl.glEnd();

        // Mover o "cursor de desenho" para outra posição
       //gl.glScalef(0.5f, 0.8f, 0.0f);
        gl.glTranslatef(3.0f, -1.4f, 0.0f);
       // gl.glRotatef(45,3.0f, -1.4f, 0f);
        
        // Desenhar um Quadrado
        
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.5f, 0.5f, 1.0f);    // Set the current drawing color to light blue
            gl.glVertex3f(-1.0f, 1.0f, 0.0f);  // Top Left
            gl.glVertex3f(1.0f, 1.0f, 0.0f);   // Top Right
            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
            gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
        // Desenho Terminado do Quadrado
        gl.glEnd();
        
        // Mover o "cursor de desenho" para outra posição
        gl.glTranslatef(0.0f, 2.4f, 0.0f);
        //Desenhar uma Circunferência
        
        gl.glBegin(GL.GL_LINE_LOOP);
            byte pontos = 100;
           
            for (byte i = 0; i < pontos; i++) {
            double anglo = 2*PI*i/pontos;
                gl.glColor3f(0.8f, 0.5f, 1.0f); 
                gl.glVertex2d(cos(anglo), sin(anglo));
            }
        // Desenho Terminado da Circunferência
        
        gl.glEnd();
        
       gl.glRotatef(90.0f, 0.0f, 2.0f, 0.0f); 
       gl.glTranslatef(-3.0f, -0.4f, 0.0f);
        // Desenhar um Poligono
        
        gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.5f, 0.5f, 1.0f);    // Set the current drawing color to light blue
            gl.glVertex3f(1.0f, 1.0f, 0.0f);   // Top Right
            gl.glColor3f(0.2f, 0.5f, 0.5f); 
            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
            gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
        // Desenho Terminado do Quadrado
        
        gl.glEnd();
        

        // Descarrega todas as operações de desenho na placa gráfica
        gl.glFlush();
    }
    

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

