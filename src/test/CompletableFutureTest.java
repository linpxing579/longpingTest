package test;

import com.lpmas.framework.util.JsonKit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

public class CompletableFutureTest {


    @Test
    public void test1() throws ExecutionException, InterruptedException {
        List<CompletableFuture> list = new ArrayList<>();
        List<String> messageList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
           CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(finalI);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return CompletableFuture.completedFuture(finalI + "返回了");
            }).thenAccept(item -> {
                try {
                    messageList.add(item.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(finalI + "：出来了");
//           completableFuture.join();
            list.add(completableFuture);
        }
        list.forEach(CompletableFuture::join);
        System.out.println(JsonKit.toJson(messageList));
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        List<CompletableFuture> list = new ArrayList<>();
        List<String> messageList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(finalI);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return CompletableFuture.completedFuture(finalI + "返回了");
            });
//           completableFuture.join();
            list.add(completableFuture);
        }

        list.forEach(item -> {
            item.whenComplete(new BiConsumer<String, Throwable>() {

                @Override
                public void accept(String s, Throwable throwable) {
                    messageList.add(s);
                }
            });
        });
//        list.forEach(CompletableFuture::join);
//        for (CompletableFuture completableFuture : list) {
//            messageList.add(completableFuture.get().toString());
//        }
        System.out.println(JsonKit.toJson(messageList));
    }
}
