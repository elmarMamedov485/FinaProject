import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertManager {
    // converst .csv file to List
    public static List<Item> convertToList(String file_name){

        List<Item> list = new ArrayList<Item>();

        try(FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr)){
            //String firstLine = ",item_id,name,category,price,old_price,sellable_online,link,other_colors,short_description,designer,depth,height,width";
            String line = br.readLine();
            
            int i = 0;           
            line = br.readLine();          
            while(line != null){
                
                List<String> str = new ArrayList<String>();
                
                boolean inside_brackets = false;
                StringBuffer elem = new StringBuffer();
                
                for(int j = 0; j < line.length(); j++){
                    char ch = line.charAt(j);
                    
                    if(!inside_brackets){
                        if(ch == 34){
                            inside_brackets = true;
                            
                            continue;
                        }
                        if(j == line.length() - 1 && ch == ','){
                            str.add("");
                        }
                        if(ch == ',' ){
                            str.add(elem.toString());
                            elem = new StringBuffer("");
                            continue;
                        }
                    }
                    else if(inside_brackets){
                        if(ch == 34){
                            inside_brackets = false;
                            continue;
                        }
                        if(ch == ','){
                            continue;
                        }
                    }
                    
                    
                    if(j == line.length() - 1){
                        elem.append(line.charAt(line.length()-1));
                        str.add(elem.toString());
                    }
                    
                    elem.append(ch);
                }
                
                
                boolean sellable_online;
                boolean other_colors;
                
                if(str.get(6) == "TRUE"){
                    sellable_online = true;
                }
                else{
                    sellable_online = false;
                }

                if(str.get(8) == "Yes"){
                    other_colors = true;
                }
                else{
                    other_colors = false;
                }        

                if(str.get(4) == ""){
                    str.set(4,"0");
                }
                if(str.get(11) == ""){
                    str.set(11,"0");
                }
                if(str.get(12) == ""){
                    str.set(12,"0");
                }
                if(str.get(13) == ""){
                    str.set(13,"0");
                }
                
                

                list.add(i, new Item(Integer.parseInt(str.get(1)), str.get(2), str.get(3),Float.valueOf(str.get(4)),
                str.get(5),sellable_online,str.get(7),other_colors,str.get(9),str.get(10),
                Integer.parseInt(str.get(11)),Integer.parseInt(str.get(12)),Integer.parseInt(str.get(13)))) ;
               
                
                i++;
                line = br.readLine();
                
            }

            
        }catch(IOException e){
            System.out.println("IOEXception occured");
        }

        return list;
    }
}
