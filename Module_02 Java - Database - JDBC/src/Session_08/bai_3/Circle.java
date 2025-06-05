package Session_08.bai_3;

public class Circle implements Colorable {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void setColor(String color) {
        System.out.printf("Circle color: %s \n", color);
    }
}
