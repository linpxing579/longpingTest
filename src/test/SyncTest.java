package test;

public class SyncTest {

    private static int count = 0;



    public static void sync(){

        for (int i = 0; i < 10; i++) {
            count ++ ;
            System.out.println(count);
        }

    }




    public static void main(String[] args) {
        Runnable a = new Runnable() {
            @Override
            public void run() {
                sync();
            }
        };

        Runnable a1 = new Runnable() {
            @Override
            public void run() {
                sync();
            }
        };

        a.run();
        a1.run();
    }
}
