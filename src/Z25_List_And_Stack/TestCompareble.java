package Z25_List_And_Stack;

/**
 * Created by Caffrey on 2017/4/23.
 */
public class TestCompareble {
    public static void main(String[] args)
    {
        Rabbit r1 = new Rabbit(1,1,1);
        Rabbit r2 = new Rabbit(2,2,2);
        Rabbit r3 = new Rabbit(3,3,3);
        System.out.print(r1.compareTo(r2));
        if(r2.compareTo(r1)>0)
        {
            System.out.println(r2.toString());
        }

    }

    public static class Rabbit implements Comparable
    {
        int face;
        int hand;
        int ear;

        public Rabbit(int face,int hand,int ear)
        {
            this.face = face;
            this.hand = hand;
            this.ear = ear;
        }
        public String toString()
        {
            return "兔兔"+this.getClass().getSimpleName()+"的脸更大";
        }

        @Override
        public int compareTo(Object o) {
            return this.face-((Rabbit)o).face;
        }
    }
}
