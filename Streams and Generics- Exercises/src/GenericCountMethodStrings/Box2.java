package GenericCountMethodStrings;

import java.util.List;

public class Box2<T extends Comparable> {
    private T element;

    public Box2(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        //return element.getClass().getName() + ": " + element;
        return element.toString();
    }

    public int  count(List<T> list, T element){
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).compareTo(element)>0)
                count++;
            }
        return count;
    }

    }

