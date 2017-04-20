package Other;

/**
 * Created by Caffrey on 2017/4/20.
 */
public class Cat extends Animals implements Eat{
    public Cat()
    {
        System.out.println("Do you like Cat?");
    }
    public Cat(int n)
    {
        System.out.println("You have "+n+" Cats now!");
    }
    @Override
    public void Birth() {
        System.out.println("A new cat birth");
    }

    @Override
    public void Breath() {
        System.out.println("cat is breathing...");
    }

    @Override
    public void eat() {
        System.out.println("cat is eating...");
    }
}
