package FunctionLayer;

public class LegoBlock2x2 implements LegoBlock {
    private int width = 2;
    private int length = 2;

    public int getWidth() {
        return width;
    }

    @Override
    public int getLength() {
        return length;
    }

    public LegoBlock2x2() {
    }
}
