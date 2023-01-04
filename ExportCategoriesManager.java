import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExportCategoriesManager extends SearchManager{
    public static void export(List<Item> list){
        List<Item> res_list = new ArrayList<>();
        Set<String> categories = new HashSet<>();

        for (Item item : list) {
            categories.add(item.getCategory());
        }

        List<String> list_categories = new ArrayList<>(categories);

        boolean file_exists = false;
        for(int i = 0; i < categories.size(); i++){
            File theDir = new File("src/Categories");
            if (!theDir.exists()){
                theDir.mkdirs();
            }
            File file = new File("src/Categories/" + list_categories.get(i) + ".csv");

            try{
                if(!file.exists()){
                    file.createNewFile();
                }
                else{
                    System.out.println("File " + file.getName() + " already exists");
                    file_exists = true;
                }
            }catch(IOException e){
                System.out.println("IOException occurred");
            }
        }

        if(file_exists){
            return;
        }

        for(int i = 0; i < categories.size(); i++){

            try(FileWriter fw = new FileWriter("src/Categories/" + list_categories.get(i) + ".csv", true)){
                List<Item> result = searchCategory(list, list_categories.get(i));
                fw.write("item_id, name, category, price, old_price, sellable_online, link, other_colors, short_description, designer, depth, height, width");
                for(int j = 0; j < result.size(); j++){
                    fw.write(result.get(i).getItemId() + result.get(i).getName() + result.get(i).getPrice() + result.get(i).getOldPrice() +
                            result.get(i).getSellableOnline() + result.get(i).getLink() + result.get(i).getOtherColors() + result.get(i).getShortDescription() +
                            result.get(i).getDesigner() + result.get(i).getDepth() + result.get(i).getHeight() + result.get(i).getWidth());
                }

            }catch(IOException e){
                System.out.println("IOException occurred");
            }
        }


    }
}
