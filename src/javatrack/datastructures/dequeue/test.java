package javatrack.datastructures.dequeue;

import java.util.*;

/*
6 3
5 3 5 2 3 2
 */
public class test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int max = map.size();

        //Slide window using Dequeue addLast and removeFirst, Dequeue maintains the same size always
        for (int i = 0; i < n; i++) {
            int nextNum = scan.nextInt();
            //When adding an element increment occurrences
            deque.addLast(nextNum);
            map.merge(nextNum, 1, Integer::sum);

            //When removing element decrement occurrences
            if (i >= m) {
                int old = deque.removeFirst();
                map.merge(old, 1, Math::subtractExact);//map always contains that element since we added it before
                map.remove(old, 0);//only remove if occurrences for element are 0, this is needed to use map.size() elements for unique elements
            }

            //map.size() is the number of distinct elements
            max = Math.max(max, map.size());
        }

        scan.close();

        System.out.println(max);
    }
}
