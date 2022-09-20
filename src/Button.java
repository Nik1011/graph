import processing.core.PApplet;

public class Button {
    public final PApplet window;
    private String name1;
    private String name2;
    private int rectX;
    private int rectY;
    private int rectWidth;
    private int rectHeight;
    private int currentColor;
    private int textSize;
    private int numberOfText;
    private boolean marked;


    public Button(String name1,int rectX, int rectY, int rectWidth, int rectHeight, int textSize,int currentColor, int numberOfText) {
        // Redundanz vermeiden durch Constructor Chaining
       this(name1,"",rectX, rectY,rectWidth,rectHeight,textSize,currentColor, numberOfText);

    }
    public Button(String name1,String name2,int rectX, int rectY, int rectWidth, int rectHeight, int textSize,int currentColor, int numberOfText) {
        this.window = GraphMain.processing;
        this.name1 = name1;
        this.name2 = name2;
        this.rectX = rectX;
        this.rectY = rectY;
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
        this.textSize = textSize;
        this.currentColor = currentColor;
        this.numberOfText = numberOfText;
        this.marked = false;
    }
    public void display(){
        window.fill(currentColor);
        window.rect(rectX,rectY, rectWidth,rectHeight);
        window.textSize(textSize);
        window.fill(0);
        if(numberOfText == 2){
            window.text(name1,10 + rectWidth,rectHeight/2);
            window.text(name2,10 + rectWidth,(rectHeight/4)*3);
        }else{
            window.text(name1,15,50);
        }
    }
    public void setMarked(boolean marked){
        this.marked = marked;
    }
    public boolean getMarked(){
        return this.marked;
    }
    public void setCurrentColor(int currentColor){
        this.currentColor = currentColor;
    }
    public int getCurrentColor(){
        return this.currentColor;
    }


}
