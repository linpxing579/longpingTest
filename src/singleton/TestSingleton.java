package singleton;

import bean.A;
import org.junit.Test;

public class TestSingleton {


    @Test
    public void test(){
        ASingleton aSingleton = ASingleton.getInstance();
        aSingleton.test();

        BSingleton bSingleton = BSingleton.getInstance();
        bSingleton.test();
    }
}
