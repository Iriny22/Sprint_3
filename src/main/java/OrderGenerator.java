import java.util.List;

public class OrderGenerator {

    public static Order getDefault() {
        List<String> color = List.of("BLACK,GREY");
        return new Order("irida","petrova","gagarina 20","5","8888888888",3,"2022-11-12","krutbl",color);
    }

    public static Order getColor(List<String> color) {
        return new Order("irida","petrova","gagarina 20","5","8888888888",3,"2022-11-12","krutbl",color);
    }
}
