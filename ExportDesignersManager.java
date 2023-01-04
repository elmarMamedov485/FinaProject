import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportDesignersManager {
    public static void exportDesigners(List<Item> list){
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

        try(FileWriter fw = new FileWriter("src/Designers/designers.csv", true)){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getDesigner().charAt(0) >= 48  && list.get(i).getDesigner().charAt(0) <= 57){
                    continue;
                }
                if(list.get(i).getDesigner().contains("/")){
                    String[] designers = list.get(i).getDesigner().split("/");
                    String result = new String();
                    for(int j = 0; j < designers.length; j++){
                        result += designers[j] + ", ";
                    }
                    fw.write(result + "\n");
                }else{
                    fw.write(list.get(i).getDesigner() + "\n");
                }

            }
        }catch(IOException e){
            System.out.println("IOException occurred");
        }
    }
}
