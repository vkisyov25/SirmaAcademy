package Animals;

public class Dog extends Animal{
    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite foof is %s",getName(),getFavouriteFood());
    }

    public Dog(String name, String favfood) {
        super(name,favfood);
    }
}
