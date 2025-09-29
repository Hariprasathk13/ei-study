
/**
 * FlyWeightPatternDemo
 * 
 * A simple example project to demonstrate flyweight pattern
 * 
 * Idea:
 * - unique data per Text is stored in Text .
 * - Common data is stored in TextStyle and shared.
 * - reduces memory usage by reusing common styles instead of duplicating
 * them.
 * 
 * Memory  of Text
 * without flyweight - 25 bytes
 * with flyweight - 13 bytes
 */

// Text contains only intrinsic data
class Text {
    private char c;
    private int position;
    private TextStyle style; // accepting extrinsic data as reference

    public Text(char c, int position, TextStyle style) {
        this.c = c;
        this.position = position;
        this.style = style;
    }

    @Override
    public String toString() {
        return "Text [c=" + c + ", position=" + position + ", style=" + style + "]";
    }

}

// TextStyle contains only extrinsic data
class TextStyle {
    int fontSize;
    String color;

    String fontWeight;

    public TextStyle(int fontSize, String color, String fontWeight) {
        this.fontSize = fontSize;
        this.color = color;
        this.fontWeight = fontWeight;
    }

    @Override
    public String toString() {
        return "TextStyle [fontSize=" + fontSize + ", color=" + color + ", fontWeight=" + fontWeight + "]";
    }

}

// client
public class FlyWeightPatternDemo {

    public static void main(String[] args) {

        // creating a simple style
        TextStyle simpleStyle = new TextStyle(24, "RED", "BOLDER");

        // passing single style for all texts
        Text t1 = new Text('A', 0, simpleStyle);
        Text t2 = new Text('B', 1, simpleStyle);

        System.out.println(t1); // Text [c=A, position=0, style=TextStyle [fontSize=24,
                                // color=RED,fontWeight=BOLDER]]

        System.out.println(t2); // Text [c=B, position=1, style=TextStyle [fontSize=24,
                                // color=RED,fontWeight=BOLDER]]

        // - Common properties are not duplicated for each object, saving memory.

    }
}