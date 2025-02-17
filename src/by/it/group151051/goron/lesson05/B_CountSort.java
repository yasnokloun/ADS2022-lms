package by.it.group151051.goron.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Первая строка содержит число 1<=n<=10000, вторая - n натуральных чисел, не превышающих 10.
Выведите упорядоченную по неубыванию последовательность этих чисел.

При сортировке реализуйте метод со сложностью O(n)

Пример: https://karussell.wordpress.com/2010/03/01/fast-integer-sorting-algorithm-on/
Вольный перевод: http://programador.ru/sorting-positive-int-linear-time/
*/

public class B_CountSort {


    int[] countSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        int[] points=new int[n];

        //читаем точки
        for (int i = 0; i < n; i++) {
            points[i]=scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением сортировки подсчетом

        // Поиск минимального и максимального элемента
        int min, max;
        max = min = points[0];
        for (int i = 0; i < points.length; i++) {
            if (points[i] < min)
                min = points[i];
            if (points[i] > max)
                max = points[i];
        }

        // Подсчет сколько раз встречается каждое число в массиве
        int[] counter = new int[max - min + 1];
        for (int i = 0; i < points.length; i++)
            counter[points[i] - min]++;

        // Заполнение исходного массива числами в зависимости от того как часто число встречается в массиве
        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++)
                points[index++] = i + min;
        }

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return points;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson05/dataB.txt");
        B_CountSort instance = new B_CountSort();
        int[] result=instance.countSort(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }
}
