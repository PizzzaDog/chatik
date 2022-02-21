package by.overone;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cheeck {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("qwe");
        list.add("qw");
        List<Integer> qw = list.stream()
                .filter(x -> !x.contains("qw"))
                .map(x -> Integer.parseInt(x.substring(1)))
                .collect(Collectors.toList());
        System.out.println();
    }
}
