package FinalProject.SortItemAsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByCategoryAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i1.getCategory().compareTo(i2.getCategory());
    }
}
