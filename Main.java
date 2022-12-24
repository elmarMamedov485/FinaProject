package FinalProject;
import java.util.List;


public class Main {
     public static void main(String[] args) {
        
        
        //ListManager.listRandom(ListManager.convertToList("FinalProject/ikea.csv"));
        List<Item> list = ListManager.convertToList("FinalProject/ikea.csv");
        SortManager.sort(list);
        ListManager.listAll(list);
    }
}
