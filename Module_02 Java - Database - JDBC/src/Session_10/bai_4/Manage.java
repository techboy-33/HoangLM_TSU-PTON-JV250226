package Session_10.bai_4;

public interface Manage <T> {
    void add(T item);
    void update(int index, T item);
    void delete( int index);
    void display();
}
