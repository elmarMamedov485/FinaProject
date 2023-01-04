import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExportDesignersManager {
    public static void exportDesigners(List<Item> list){
        Set<String> setDesigners = new HashSet<>();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getDesigner().charAt(0) >= 48  && list.get(i).getDesigner().charAt(0) <= 57){
                continue;
            }
            if(list.get(i).getDesigner().contains("/")){
                String[] designers = list.get(i).getDesigner().split("/");
                for(int j = 0; j < designers.length; j++){
                    setDesigners.add(designers[j]);
                }
            }else{
                setDesigners.add(list.get(i).getDesigner());
            }
        }

        File theDir = new File("src/Designers");
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        File file = new File("src/Designers/designers.csv");

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

        List<String> listDesigners = new ArrayList<>(setDesigners);

        try(FileWriter fw = new FileWriter("src/Designers/designers.csv", true)){
            for(int i = 0; i < listDesigners.size(); i++){
                fw.write(listDesigners.get(i) + "\n");
            }
        }catch(IOException e){
            System.out.println("IOException occurred");
        }
    }
}
