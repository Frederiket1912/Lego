
package FunctionLayer;

import java.util.ArrayList;


public class Wall {
    private ArrayList<Line> lines;
    private int amountOf4x2;
    private int amountOf2x2;
    private int amountOf2x1;

    public Wall(ArrayList<Line> lines, int amountOf4x2, int amountOf2x2, int amountOf1x2) {
        this.lines = lines;
        this.amountOf4x2 = amountOf4x2;
        this.amountOf2x2 = amountOf2x2;
        this.amountOf2x1 = amountOf1x2;
    }

    public int getAmountOf2x4() {
        return amountOf4x2;
    }

    public int getAmountOf2x2() {
        return amountOf2x2;
    }

    public int getAmountOf2x1() {
        return amountOf2x1;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }


}
