import processing.core.PApplet;

import java.util.ArrayList;


public class GraphMain extends PApplet {


    /**
     * TO DO'S
     *  Adjatzenzmatrix Edges erstellen
     *  setChangeable vereinfachen
     *  Git lernen (Basics), vorher Zwischenspeichern in Ordner in BackUp Ordner
     *  Edges hinzufügen
     *  Vertex per Mausklick verschieben
     *  mehrere Buttons hinzufügen (Clear, createGraph, isBipartit, etc..) -> verschiedene Übergabeparameter am Anfang damit
     *  alle Buttons zu Beginn erstellt werden
     *
     */


    /**
     * test
     */
    public static PApplet processing;
    public static void main(String[] args) {
        PApplet.main("GraphMain");
    }
    ArrayList<Vertex> list = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();
    ArrayList<Vertex> twoVertex = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();
    ArrayList<Integer> index = new ArrayList<>();



    public void settings() {
        size(1000, 1000);
    }

    public void setup() {
        processing = this;
        buttons.add(new Button("CLEAR",0,0,100,80, 25,255, 1));
        buttons.add(new Button("CREATE","EDGE",100,0,100,80,25,255,2));
    }

    @Override
    public void draw() {
        background(Color.BLACK.getColor());

        for (int i = 0; i < list.size(); i++) {
            // 1. Button wenn Maus auf Position
            if((pmouseX < 100) && (pmouseY < 80)){
                buttons.get(0).setCurrentColor(150);
            }
            else {
                buttons.get(0).setCurrentColor(255);
            }
            /**
             * es gibt nun verschieden Situation was den 2. Button angeht
             * 1. getMarked == false + Mausposition == true -> graue Farbe
             * 2. getMarked == true + Mausposition == true -> Farbe bleibt
             * 3. getMarked == true + Mausposition == false -> graue Farbe
             * 4. getMarked == false + Mausposition == false -> weiße Farbe
             */
            if((pmouseX < 200) && (pmouseX > 100) && (pmouseY < 80) && !buttons.get(1).getMarked()){
                buttons.get(1).setCurrentColor(150);
            } else if (buttons.get(1).getMarked() && (pmouseX < 200) && (pmouseX > 100) && (pmouseY < 80)) {
                buttons.get(1).setCurrentColor(150);
            } else if (buttons.get(1).getMarked()) {
                buttons.get(1).setCurrentColor(150);
            } else {
                buttons.get(1).setCurrentColor(255);
            }
            /**
             * Radius vergrößern wenn Maus auf position oder Maus auf Position und createEdge == true
             */
            float x = list.get(i).location.x - list.get(i).window.pmouseX;
            float y = list.get(i).location.y - list.get(i).window.pmouseY;
            float dist = (float)Math.sqrt((x*x)+(y*y));
            if(dist < list.get(i).getRadius() && !buttons.get(1).getMarked()){
                list.get(i).setRadius(30);
            } else if (dist < list.get(i).getRadius() && buttons.get(1).getMarked() ) {
                list.get(i).setRadius(30);
            } else{
                list.get(i).setRadius(20);
            }
            list.get(i).display();
        }
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).display();
            //println(buttons.get(0).getMarked());
            //println(buttons.get(1).getMarked());
        }

        //println("Koordinaten X: " + pmouseX);
        //println("Koordinaten Y: " + pmouseY);

    }

    public void mousePressed(){
        /**
         * Switch - Case Anweisung
         */
        /**
         * TAB + Mausposition unter den Buttons + createEdge == false
         */
        if ((keyPressed && key == TAB )&& (pmouseY > 95 ) && !buttons.get(1).getMarked()) {
          list.add(new Vertex());
            /**
             * create Edge Button wird gedrückt und switcht zwischen true und false durchs klicken 
             */
        } else if ((pmouseX < 200) && (pmouseX > 100) && (pmouseY < 80)) {
            if(!buttons.get(1).getMarked()){
                buttons.get(1).setMarked(true);
                buttons.get(1).setCurrentColor(150);
            }else {
                buttons.get(1).setMarked(false);
                buttons.get(1).setCurrentColor(255);
            }
            /**
             * Edge erzeugen
             */
        }
        for (int i = 0; i < list.size(); i++) {
            float x = list.get(i).location.x - list.get(i).window.pmouseX;
            float y = list.get(i).location.y - list.get(i).window.pmouseY;
            float dist = (float)Math.sqrt((x*x)+(y*y));
            /**
             * wenn der createEdge Button == true und die Maus auf einem Knoten liegt
             */
            if (buttons.get(1).getMarked() && dist < list.get(i).getRadius()){
                list.get(i).setClicked(true);
                list.get(i).setRadius(30);
                list.get(i).setChangeable(false);
                index.add(i);
                twoVertex.add(list.get(i));
            }
        }

        if(twoVertex.size() == 2){
            float x1 = twoVertex.get(0).location.x;
            float y1 = twoVertex.get(0).location.y;
            float x2 = twoVertex.get(1).location.x;
            float y2 = twoVertex.get(1).location.y;
            edges.add(new Edge(x1,y1,x2,y2));
            twoVertex.remove(0);
            twoVertex.remove(1);
            list.get(index.get(0)).setClicked(false);
            list.get(index.get(1)).setChangeable(true);
        }

    }
}


