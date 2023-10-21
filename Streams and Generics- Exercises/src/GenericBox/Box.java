package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private T element;


    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.getClass().getName() + ": " + element;
    }


}
