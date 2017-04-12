import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shoma on 12.04.2017.
 */
public class NumGenerator extends Thread{
    Random random = new Random();
public static boolean flag=true;
    @Override
    public  void run() {
        while (flag!=false){
   //         System.out.println(flag);
       int num = random.nextInt(100);
       synchronized (Main.list){
        Main.list.add(num);
        Thread.yield();
       }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // super.run();
    }
    }
}
