package FinalProject.SortItemDsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByOldPriceDsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i2.getOldPrice().compareTo(i1.getOldPrice());
    }
}
