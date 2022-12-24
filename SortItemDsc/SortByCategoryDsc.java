package FinalProject.SortItemDsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByCategoryDsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i2.getCategory().compareTo(i1.getCategory());
    }
}
