package singleton;


public class BSingleton {

    private ASingleton aSingleton = ASingleton.getInstance();

    private BSingleton(){
        System.out.println("这是B的构造器");
    }

    private static class BSingletonHolder{
        private static final BSingleton Instance = new BSingleton();
        static {
            System.out.println("这是B的内部类");
        }
    }

    public static BSingleton getInstance(){
        System.out.println("这是B的getInstance");
        return BSingletonHolder.Instance;
    }


    public void test(){
        aSingleton.test();
        System.out.println("这是B");
    }
}
