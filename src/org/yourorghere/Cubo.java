/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.ColorCube;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.*;
import javax.vecmath.Color3f;


/**
 *
 * @author Chichava.Marcos
 */
public class Cubo extends Applet  {
    public Cubo () {
        setLayout(new BorderLayout());
        Canvas3D canvas3D = new Canvas3D(null); // passo 1
        add("Center", canvas3D);
        BranchGroup s = ConstroiContentBranch(); // passo 5
        s.compile(); // passo 6
        // A instanciação de um objeto SimpleUniverse corresponde
        // aos passos 2, 3, e 4 da "receita"
        SimpleUniverse su = new SimpleUniverse(canvas3D);
        // Desloca o ViewPlatform para trás para que os
        // objetos da cena possam ser vistos.
        su.getViewingPlatform().setNominalViewingTransform();
        // Anexa o content graph ao nó Locale : passo 7
        su.addBranchGraph(s);
        }
        public BranchGroup ConstroiContentBranch() {
        // Especifica-se aqui os conteúdos gráficos a serem renderizados
        BranchGroup objRoot = new BranchGroup();
        // O trecho de código a seguir especifica duas transformações
        // 3D, uma para rotacionar o cubo no eixo x e a outra no eixo y
        // e por fim combina as duas transformações
        Transform3D rotate1 = new Transform3D();
        Transform3D rotate2 = new Transform3D();
        rotate1.rotX(Math.PI/4.0d);
        rotate2.rotY(Math.PI/5.0d);
        rotate1.mul(rotate2);
        TransformGroup objRotate = new TransformGroup(rotate1);
        objRoot.addChild(objRotate);
        objRotate.addChild(new ColorCube(0.4));
        return objRoot;
        }
        
        private Appearance constroiAparencia () {
            Appearance ap = new Appearance();
            LineAttributes al = new LineAttributes();
            al.setLineWidth(2.0f);
            al.setLinePattern(al.PATTERN_SOLID);
            ap.setColoringAttributes(al);
            ColoringAttributes aCor = new ColoringAttributes();
            aCor.setColor(new Color3f(1.0f, 0.0f, 0.0f));
            ap.setColoringAttributes(aCor);
            PolygonAttributes pa = new PolygonAttributes();
            pa.setPolygonMode(PolygonAttributes.Polygon_FILL);
            ap.setPolygonAttributes(pa);
            return ap;
        }
        public static void main (String[] args) {
            Frame frame = new MainFrame (new Cubo(), 256, 256);
    }
}




// O método a seguir permite que o applet Exemplo01 seja
// executado como uma aplicação

