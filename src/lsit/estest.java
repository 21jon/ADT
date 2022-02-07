package lsit;

public class estest {

    public static void main(String[] args) {
        es<Integer> it = new es<>();

        Integer[] numbers = new Integer[] { 123, 235, 345, 34, 565, 6, 4567, 5, 324, 512, 43, 24, 53, 56, 467, 578,
                5678, 46, 634, 56, 32546, 46, 757, 8, 367, 2356, 3457, 4578, 567, 945, 7, 23456, 435, 64, 56, 47, 578,
                456, 73, 46, 345, 634, 56, 34, 654, 67, 456, 8, 36, 23, 45 };

        for (Integer integer : numbers) {
            it.enqueue(integer);
        }

        // System.out.println(it.get(5));
        // System.out.println(it.isEmpty());
        // System.out.println(it.deleteAt(5));

        System.out.println(it.debugString());
        it.move(1, 5);
        System.out.println(it.debugString());

    }

}
