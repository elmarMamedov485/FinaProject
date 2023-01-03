import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExportCategoriesManager {
    public static void export(List<Item> list){
        List<Item> res_list = new ArrayList<>();
        Set<String> categories = new HashSet<>();

        for(int i = 0; i < list.size(); i++){
            categories.add(list.get(i).getCategory());
        }



    }
}
