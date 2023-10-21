package Animals;

public class Cat extends Animal{
    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite foof is %s",getName(),getFavouriteFood());
    }

    public Cat(String name, String favfood) {
        super(name,favfood);
    }
}
