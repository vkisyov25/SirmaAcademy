package GenericSwapMethodStrings;

import java.util.List;

public class Box1<T> {
    private T element;

    public Box1(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.getClass().getName() + ": " + element;
    }

    /*public List<T> swap(List<Box1> list, int index1, int index2) {
        T temp = (T) list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, (Box1) temp);
        return (List<T>) list;
    }*/

    public List<T> swap(List<T> list, int index1, int index2) {
        T temp = (T) list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
        return (List<T>) list;
    }

}
