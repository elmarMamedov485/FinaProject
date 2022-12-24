package FinalProject.SortItemAsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByLinkAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i1.getLink().compareTo(i2.getLink());
    }
}
