package FinalProject.SortItemDsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByLinkDsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i2.getLink().compareTo(i1.getLink());
    }
}
