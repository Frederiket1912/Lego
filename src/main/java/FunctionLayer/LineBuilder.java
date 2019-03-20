package FunctionLayer;

import java.util.ArrayList;

public class LineBuilder {

    // min ide er at tjekke om forrige line starter med en 2x4 brik, hvis det er tilfældet skal den nye line starte med en 2x1 brik.
    public Line buildLine(int length, Line previousLine) {
        int numberOf2x4 = 0;
        int numberOf2x2 = 0;
        int numberOf1x2 = 0;
        ArrayList<LegoBlock> blocks = new ArrayList<>();
        if (null == previousLine) {
            if (length >= 4) {
                numberOf2x4 = length / 4;
                for (int i = 0; i < numberOf2x4; i++) {
                    blocks.add(new LegoBlock2x4());
                }
                length = length % 4;
            }
            if (length >= 2) {
                numberOf2x2 = length / 2;
                for (int i = 0; i < numberOf2x2; i++) {
                    blocks.add(new LegoBlock2x2());
                }
                length = length % 2;
            }
            if (length >= 1) {
                numberOf1x2 = length;
                for (int i = 0; i < numberOf1x2; i++) {
                    blocks.add(new LegoBlock2x1());
                }
            }
        } else {
            if (previousLine.getBlocks().get(0).getLength() == 4) {
                numberOf1x2 += 1;
                blocks.add(new LegoBlock2x1());
                length -= 1;
            }
            if (length >= 4) {
                numberOf2x4 = length / 4;
                for (int i = 0; i < numberOf2x4; i++) {
                    blocks.add(new LegoBlock2x4());
                }
                length = length % 4;
            }
            if (length >= 2) {
                numberOf2x2 = length / 2;
                for (int i = 0; i < numberOf2x2; i++) {
                    blocks.add(new LegoBlock2x2());
                }
                length = length % 2;
            }
            if (length >= 1) {
                numberOf1x2 += length;
                for (int i = 0; i < numberOf1x2; i++) {
                    blocks.add(new LegoBlock2x1());
                }
            }
        }
        return new Line(blocks, numberOf2x4, numberOf2x2, numberOf1x2);
    }
}
