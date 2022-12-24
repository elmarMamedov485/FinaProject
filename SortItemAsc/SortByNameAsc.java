package FinalProject.SortItemAsc;

import java.util.Comparator;
import FinalProject.Item;

public class SortByNameAsc implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i1.getName().compareTo(i2.getName());
    }
}
