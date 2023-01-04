import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportManager {
    public static void export(List<Item> list, String request){
        File theDir = new File("src/Exports");
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        File file = new File("src/Exports/"+ request +".csv");

        try{
            if(!file.exists()){
                file.createNewFile();
            }
            else{
                System.out.println("File " + file.getName() + " already exists");
                return;
            }
        }catch(IOException e){
            System.out.println("IOException occurred");
        }
        try(FileWriter fw = new FileWriter("src/Exports/"+ request +".csv", true)){
            for(Item i : list){
                fw.write(i.toString());
            }
        }catch(IOException e){
            System.out.println("IOException occurred");
        }

        System.out.println("Exported");
    }
}
