package Session_08.bai_3;

public class Rectangle implements Colorable{
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void setColor(String color) {
        System.out.printf("Rectangle color: %s \n", color);
    }
}
