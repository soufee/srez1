import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by Shoma on 12.04.2017.
 */
public class Counter extends Thread{
    static boolean  counterFlag = true;
   HashMap<Integer, Integer>map = new HashMap<>();
    @Override
    public void run() {
       while (counterFlag != false)
       {
    //       System.out.println(counterFlag);
           for (int i = 0; i < Main.list.size(); i++) {
               int k;
               synchronized (Main.list) {
                  k = Main.list.get(i);
              }
               if (map.containsKey(k)){
                 int v = map.get(k)+1;

                  map.put(k,v); 
               } else
                   map.put(k,1);
                   
           }
           Iterator<HashMap.Entry<Integer, Integer>> entries = map.entrySet().iterator();
           while (entries.hasNext()) {
               Map.Entry<Integer, Integer> entry = entries.next();
               System.out.println("Цифра " + entry.getKey() + " встречается " + entry.getValue()+" раз.");
               if (entry.getValue()>=5)
               {
                   System.out.println("!!Цифра " + entry.getKey() + " была сгенерирована " + entry.getValue()+" раз."+
                   " Программа прекращает свою работу. ");
                 counterFlag=false; NumGenerator.flag = false;
                 return;
               }
           }
           try {
               TimeUnit.SECONDS.sleep(5);
               Thread.yield();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }


    }
}
