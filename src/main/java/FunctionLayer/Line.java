
package FunctionLayer;

import java.util.ArrayList;


public class Line {
    private ArrayList<LegoBlock> blocks;
    private int amountOf4x2;
    private int amountOf2x2;
    private int amountOf2x1;

    public int getAmountOf4x2() {
        return amountOf4x2;
    }

    public int getAmountOf2x2() {
        return amountOf2x2;
    }

    public int getAmountOf2x1() {
        return amountOf2x1;
    }

    public ArrayList<LegoBlock> getBlocks() {
        return blocks;
    }

    public Line(ArrayList<LegoBlock> blocks, int amountOf4x2, int amountOf2x2, int amountOf1x2) {
        this.blocks = blocks;
        this.amountOf4x2 = amountOf4x2;
        this.amountOf2x2 = amountOf2x2;
        this.amountOf2x1 = amountOf1x2;
    }


}
