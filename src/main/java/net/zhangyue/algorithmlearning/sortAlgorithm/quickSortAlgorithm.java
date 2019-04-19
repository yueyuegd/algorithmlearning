package net.zhangyue.algorithmlearning.sortAlgorithm;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 快速排序算法
 *
 */
public class quickSortAlgorithm {

    public static void main(String[] args) {
        //int[] arr = new int[]{1,2,34,5};
        //注意生成的是int[]的流
        //Stream<int[]> stream2 = Stream.of(arr,arr);
        //stream2.forEach(System.out::println);
        System.out.println(quickSort(Arrays.asList(10, 5, 2, 3)));
    }


    private static List<Integer> quickSort(List<Integer> list) {
        //基准条件：如果数组中包含一个元素或者数组是空的话则表示该数组是有序的。
        if (list.size() < 2) {
            return list;
        } else {
            //拿第一个元素为基准元素
            Integer pivot = list.get(0);
            //将比基准元素小的所有元素放入一个数组中
            List<Integer> less = list.stream().skip(1).filter(i -> i <= pivot).collect(Collectors.toList());
            //将比基准元素大的所有元素放入一个数组中
            List<Integer> greater = list.stream().skip(1).filter(i -> i > pivot).collect(Collectors.toList());
            return Stream.of(
                    quickSort(less).stream(),
                    Stream.of(pivot),
                    quickSort(greater).stream())
                    .flatMap(Function.identity())
                    .collect(Collectors.toList());

        }


    }
}
