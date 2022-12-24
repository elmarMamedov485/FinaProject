package FinalProject.SortItemDsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByOtherColorsDsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return Boolean.compare(i2.getOtherColors(),i1.getOtherColors());
    }
}
