package Installation;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class RubyInstallation {

    private static ExecutorService executorService = Executors.newCachedThreadPool();
//    public static void install(){
//        try {
//            installRuby(aVoid -> {
//                try {
//                    Runtime.getRuntime().exec("gem install github-linguist");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

//    private static void installRuby(Consumer<Void> consumer) throws IOException{
//        final Process[] d = new Process[1];
//        executorService.execute(()->{
//            try {
//                d[0] = Runtime.getRuntime().exec("apt install ruby");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            consumer.accept(null);
//        });
//        executorService.execute(()->{
//            while (!d[0].isAlive()){Thread.sleep();}
//
//        });
//    }
}
