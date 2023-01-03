import java.util.List;


public class Main {
     public static void main(String[] args) {
        
        //ListManager.listRandom(ListManager.convertToList("FinalProject/ikea.csv"));
        List<Item> list = ConvertManager.convertToList("src/ikea.csv");

        PrintManager.listAll(FilterManager.filter(list));
    }
}
