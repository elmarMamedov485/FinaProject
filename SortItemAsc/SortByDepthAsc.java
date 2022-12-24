package FinalProject.SortItemAsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByDepthAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i1.getDepth() - i2.getDepth();
    }
}
