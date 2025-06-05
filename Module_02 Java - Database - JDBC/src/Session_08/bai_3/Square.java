package Session_08.bai_3;

public class Square implements Colorable{
    private int length;
    private int width;

    public Square(int length, int width) {
        this.length = length;
        this.width = width;
    }


    @Override
    public void setColor(String color) {
        System.out.printf("Square color: %s \n", color);
    }
}
