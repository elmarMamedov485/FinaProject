package FinalProject.SortItemAsc;
import java.util.Comparator;
import FinalProject.Item;

public class SortByOtherColorsAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return Boolean.compare(i1.getOtherColors(),i2.getOtherColors());
    }
}
