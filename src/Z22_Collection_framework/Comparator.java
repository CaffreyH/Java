package Z22_Collection_framework;

import java.io.Serializable;

/**
 * Created by Caffrey on 2017/4/5.
 */
public class Comparator implements Serializable {
    public int compare(int a,int b)
    {
        if(a>b)
        {
            return a;
        }
        else
            return b;
    }

}
