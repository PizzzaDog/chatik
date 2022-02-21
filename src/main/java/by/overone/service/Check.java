package by.overone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Check {

    public static void main(String[] args) {
//        Dto dto1 = new Dto();
//        Dto dto2 = new Dto();
//        List<Dto> list = new ArrayList<>();
//        list.add(dto1);
//        list.add(dto2);
//        Optional<String> collect = list.stream()
//                .map(Dto::getName)
//                .filter(Objects::nonNull).distinct().findFirst();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.remove(0);

        System.out.println("qwe");


    }

    static class Dto {
        private String name;

        public Dto() {
        }

        public Dto(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
