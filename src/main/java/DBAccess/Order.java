
package DBAccess;


public class Order {
    private String email;
    private int width;
    private int length;
    private int height;
    private boolean hasBeenShipped;
    private int bricks2x4;
    private int bricks2x2;
    private int bricks2x1;
    private int orderId;

    public Order(String email, int width, int length, int height, int bricks2x4, int bricks2x2, int bricks2x1, boolean hasBeenShipped) {
        this.email = email;
        this.width = width;
        this.length = length;
        this.height = height;
        this.bricks2x4 = bricks2x4;
        this.bricks2x2 = bricks2x2;
        this.bricks2x1 = bricks2x1;
        this.hasBeenShipped = hasBeenShipped;
    }
    public Order(String email, int width, int length, int height, int bricks2x4, int bricks2x2, int bricks2x1, boolean hasBeenShipped, int orderId) {
        this.email = email;
        this.width = width;
        this.length = length;
        this.height = height;
        this.bricks2x4 = bricks2x4;
        this.bricks2x2 = bricks2x2;
        this.bricks2x1 = bricks2x1;
        this.hasBeenShipped = hasBeenShipped;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" + "email=" + email + ", width=" + width + ", length=" + length + ", height=" + height + ", hasBeenShipped=" + hasBeenShipped + ", bricks2x4=" + bricks2x4 + ", bricks2x2=" + bricks2x2 + ", bricks2x1=" + bricks2x1 + ", orderId=" + orderId + '}';
    }

    public String getEmail() {
        return email;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHasBeenShipped() {
        return hasBeenShipped;
    }

    public int getBricks2x4() {
        return bricks2x4;
    }

    public int getBricks2x2() {
        return bricks2x2;
    }

    public int getBricks2x1() {
        return bricks2x1;
    }

    public int getOrderId() {
        return orderId;
    }
    
}
