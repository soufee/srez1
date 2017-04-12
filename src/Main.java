import java.util.ArrayList;

/**
 * Created by Shoma on 12.04.2017.
 *
 * Реализовать программу из 2-х потоков. Один из потоков каждую секунду генерирует случайное число в интервале [0;99].
 * Второй поток раз в пять секунд выводит количество раз, которое каждое из чисел было сгенерированно.
 * После того, как какое-либо из чисел будет сгенерированно не менее, чем 5 раз, оба потока должны остановить свое выполнение.
 *
 */
public class Main {
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
new NumGenerator().start();
new Counter().start();
    }
}
