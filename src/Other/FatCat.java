package Other;

/**
 * Created by Caffrey on 2017/4/20.
 */
public class FatCat extends Cat {
    public FatCat(int n)
    {
        super(n);
        System.out.println("You have" +n+ " Fat cat");
    }
    public void eat() {
        System.out.println("I am a Fat cat I can Eat so much...");
    }
}
