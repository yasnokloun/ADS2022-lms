package by.it.group151051.k_maliuk.lesson01;

import java.math.BigInteger;
import java.util.ArrayList;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();
    private ArrayList<BigInteger> array = new ArrayList<>(){{add(BigInteger.ZERO); add(BigInteger.ONE);}};

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        if (n < 1) return BigInteger.ZERO;
        if (n < 2) return BigInteger.ONE;
        for(int i = 2; i <= n; i++) array.add(array.get(i - 1).add(array.get(i - 2)));
        return array.get(n);
    }
}

