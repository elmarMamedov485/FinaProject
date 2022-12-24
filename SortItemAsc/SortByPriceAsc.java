package FinalProject.SortItemAsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByPriceAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return Float.compare(i1.getPrice(), i2.getPrice());
    }
}
