import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(8);
        numbers.add(3);
        numbers.add(7);
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(8);

        numbers.stream().


        String name = "abhishek Patel Kasrawad";
        Map map = name.chars().mapToObj(c->(char) c).collect();

        System.out.println(map);
           }
}