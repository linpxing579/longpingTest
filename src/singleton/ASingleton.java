package singleton;

public class ASingleton {

    private BSingleton bSingleton = BSingleton.getInstance();
    private ASingleton(){
        System.out.println("这是A的构造器");
    }

    private static class ASingletonHolder{
        private static final ASingleton Instance = new ASingleton();
        static {
            System.out.println("这是A的内部类");
        }
    }

    public static ASingleton getInstance(){
        System.out.println("这是A的getInstance");
        if (ASingletonHolder.Instance == null) {
            System.out.println("这是A的kong");
        }
        return ASingletonHolder.Instance;
    }


    public void test(){
        bSingleton.test();
        System.out.println("这是A");
    }
}
