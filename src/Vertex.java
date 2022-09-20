import processing.core.PApplet;
import processing.core.PVector;


public class Vertex {

    public final PApplet window;
    PVector location;
    PVector mouse;
    private float radius;
    float x;
    float y;
    private int currentColor;
    private boolean clicked;
    private boolean changeable;
    private int index;


    public Vertex() {
        this.window = GraphMain.processing;
        this.clicked = false;
        this.radius = 20;
        this.currentColor = 255;
        this.changeable = true;
        x = window.mouseX;
        y = window.mouseY;
        location = new PVector(x,y);
        mouse = new PVector(window.pmouseX,window.pmouseY);
    }

    public void display() {
        window.fill(currentColor);
        window.ellipse(location.x,location.y, radius, radius);
        //zeichne die Maus
        //window.line(0,0,window.pmouseX,window.pmouseY);
        //zeichne den Knoten
        //window.line(0,0,location.x,location.y);
        //window.line(location.x,location.y,window.pmouseX,window.pmouseY);
    }

    public void setRadius(float radius) {
        if(changeable){
            this.radius = radius;
        }
    }
    public float getRadius(){return radius;}

    public void setCurrentColor(int currentColor){
        this.currentColor = currentColor;
    }

    public boolean getClicked() {
        return clicked;
    }
    public void setClicked(boolean clicked){
        this.clicked = clicked;
    }
    public void setChangeable(boolean changeable){
        this.changeable = changeable;
    }
    public void setIndex(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}