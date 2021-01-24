/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.geometry.Cylinder;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.lang.UnsatisfiedLinkError;

/**
 *
 * @author Chichava.Marcos
 */
public class Cilindro extends Applet{
    public BranchGroup createSceneGraph(){
        // Cria no' raiz do grafo de cena
        BranchGroup objRoot = new BranchGroup();
        // cria um Transformgroup para fazer escala em todos os
        // objetos que aparecem na cena
        TransformGroup objScale = new TransformGroup();
        Transform3D t3d = new Transform3D();
        t3d.setScale(0.55);
        objScale.setTransform(t3d);
        objRoot.addChild(objScale);
        // cria um cilindro e adiciona
        // ao grafo de cena
        Cylinder CylinderObj = new Cylinder();
        objScale.addChild(CylinderObj);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        // luzes
        Color3f lColor1 = new Color3f(1.0f, 0.0f, 0.0f);
        Color3f lColor2 = new Color3f(1.0f, 0.0f, 0.0f);
        Vector3f lDir1 = new Vector3f(-1.0f, -1.0f, -1.0f);
        Vector3f lDir2 = new Vector3f(0.0f, 0.0f, -1.0f);
        DirectionalLight lgt1 = new DirectionalLight(lColor1, lDir1);
        DirectionalLight lgt2 = new DirectionalLight(lColor2, lDir2);
        lgt1.setInfluencingBounds(bounds);
        lgt2.setInfluencingBounds(bounds);
        objScale.addChild(lgt1);
        objScale.addChild(lgt2);
        // otimiza conversao do grafo de cena para renderizacao
        // pela OpenGL
        objRoot.compile();
        return objRoot;
    }
    public Cilindro (){
        setLayout(new BorderLayout());
        GraphicsConfiguration config =
        SimpleUniverse.getPreferredConfiguration();
        Canvas3D c = new Canvas3D(config);
        add("Center", c);
        // Cria um grafo simple e o anexa ao virtual universe
        BranchGroup scene = createSceneGraph();
        SimpleUniverse u = new SimpleUniverse(c);
        // Move ViewPlatform para tras, para que
        // os objetos da cena sejam vistos
        u.getViewingPlatform().setNominalViewingTransform();
        u.addBranchGraph(scene);
    }
    public static void main(String argv[]){
        new MainFrame(new Cilindro(), 400, 400);

    }
}
