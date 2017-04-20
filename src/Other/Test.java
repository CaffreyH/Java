package Other;

/**
 * Created by Caffrey on 2017/4/20.
 */
public class Test {
    public static void main(String[] args)
    {
        Animals c = new Cat();
        c.Birth();
        c.Breath();
        Cat cat = new Cat();
        cat.eat();
        Cat fatCat = new FatCat(5);
        fatCat.eat();
        fatCat.Birth();
        fatCat.Breath();
    }
}
