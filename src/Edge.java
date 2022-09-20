import processing.core.PApplet;
import processing.core.PVector;

public class Edge {


    Vertex vertex;
    public final PApplet window;
    PVector edge;
    private float x1;
    private float y1;
    private float x2;
    private float y2;

    public Edge(float x1, float y1, float x2, float y2){
        this.window = GraphMain.processing;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;


    }

    /**
     * Edge wird erzeugt wenn:
     * 1. createEdge == true
     * 2. 2 Knoten ausgewählt wurden
     *
     *
     */

    /**
     *
     * x Pos und y Pos von vertex1 und vertex 2 müssen übergeben werden
     */

    public void dispaly(){
        window.stroke(100);
        window.line(this.x1, this.y1, this.x2, this.y2);
    }

}
