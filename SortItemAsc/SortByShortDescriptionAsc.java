package FinalProject.SortItemAsc;

import java.util.Comparator;
import FinalProject.Item;

public class SortByShortDescriptionAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i1.getShortDescription().compareTo(i2.getShortDescription());
    }
}
