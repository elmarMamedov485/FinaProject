package FinalProject.SortItemAsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByHeightAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i1.getHeight() - i2.getHeight();
    }
}
