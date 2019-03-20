
package FunctionLayer;

import java.util.ArrayList;

public class WallBuilder {
    
    public Wall buildWall(int height, int length){
        ArrayList<Line> lines = new ArrayList<>();
        LineBuilder lb = new LineBuilder();
        for (int i = 0; i < height; i++) {
            Line previousSide = null;
        if (!lines.isEmpty()){
        previousSide = lines.get(lines.size()-1);
        }
        lines.add(lb.buildLine(length, previousSide));
        }
        int numberOf2x4 = 0;
        int numberOf2x2 = 0;
        int numberOf2x1 = 0;
        for (Line line : lines) {
            for (LegoBlock block : line.getBlocks()) {
                if (block.getLength() == 4){
                    numberOf2x4 ++;
                }
                else if (block.getLength() == 2){
                    numberOf2x2 ++;
                }
                else if (block.getLength() == 1){
                    numberOf2x1 ++;
                }
            }
        }        
        Wall wall = new Wall(lines, numberOf2x4, numberOf2x2, numberOf2x1);
        return wall;          
    }
    
    public static void main(String[] args) {
        WallBuilder wb = new WallBuilder();
        Wall wall = wb.buildWall(4, 11);
        System.out.println("antal lines i waill :" + wall.getLines().size());
        System.out.println("2x4 i wall: " + wall.getAmountOf2x4());
        System.out.println("2x2 i wall: " + wall.getAmountOf2x2());
        System.out.println("1x4 i wall: " + wall.getAmountOf2x1());
    }
}
