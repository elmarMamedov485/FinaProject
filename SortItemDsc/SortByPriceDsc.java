package FinalProject.SortItemDsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByPriceDsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return Float.compare(i2.getPrice(), i1.getPrice());
    }
}
