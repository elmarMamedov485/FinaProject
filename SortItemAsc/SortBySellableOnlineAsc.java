package FinalProject.SortItemAsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortBySellableOnlineAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return Boolean.compare(i1.getSellableOnline(),i2.getSellableOnline());
    }
}
