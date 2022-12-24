package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ListManager {
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

    //prints entities of a given list
    public static void pritnList(List<Item> list){
        int i;
        
        for(i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }

        System.out.println((i + 1) + " entities listed");
    }

    //lists all entities
    public static void listAll(List<Item> list){
        printChosenFields(list);
    }

    //lists 20 random entities
    public static void listRandom(List<Item> list){
        List<Item> newList = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            int k = (int)( Math.random()*100);
            newList.add(list.get(k));
        }

        printChosenFields(newList);
    }

    //lists top 20 entities
    public static void listTop(List<Item> list){
        List<Item> newList = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            newList.add(list.get(i));
        }

        printChosenFields(newList);
    }

    //lists bottom 20 entities
    public static void listBottom(List<Item> list){
        List<Item> newList = new ArrayList<>();

        for(int i = list.size() - 20; i < list.size(); i++){
            newList.add(list.get(i));
        }

        printChosenFields(newList);
    }

    //provides user the ability to choose which fields to display
    private static void printChosenFields(List<Item> list){
        System.out.println("Choose fields to display:");
        System.out.println("1. All fields");
        System.out.println("2. Item id");
        System.out.println("3. Name");
        System.out.println("4. Category");
        System.out.println("5. Price");
        System.out.println("6. Old price");
        System.out.println("7. Sellable online");
        System.out.println("8. Link");
        System.out.println("9. Other colours");
        System.out.println("10. Short description");
        System.out.println("11. Designer");
        System.out.println("12. Depth");
        System.out.println("13. Height");
        System.out.println("14. Width");
        System.out.println("\nEnter numbers (enter 15 to stop and Enter buttons):");

        int[] arr = new int[14];
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(true){
            int n = sc.nextInt();
            
            if(n == 15){
                break;
            }
            if(i > 13){
                break;
            }
            if(n > 14){
                System.out.println("Wrong number");
                continue;
            }

            arr[i] = n;

            if(n == 1){
                break;
            }

            i++;
        }

        Set<Integer> s = new HashSet<Integer>();

        for(int j = 0; j < arr.length; j++){
            s.add(arr[j]);
        }

        if(s.contains(1)){
            pritnList(list);
        }
        else{
            for(int j = 0 ; j < list.size(); j++){
                if(s.contains(2)){
                    System.out.print(list.get(j).getItemId() + " ");
                }
                if(s.contains(3)){
                    System.out.print(list.get(j).getName() + " ");
                }
                if(s.contains(4)){
                    System.out.print(list.get(j).getCategory() + " ");
                }
                if(s.contains(5)){
                    System.out.print(list.get(j).getPrice() + " ");
                }
                if(s.contains(6)){
                    System.out.print(list.get(j).getOldPrice() + " ");
                }
                if(s.contains(7)){
                    System.out.print(list.get(j).getSellableOnline() + " ");
                }
                if(s.contains(8)){
                    System.out.print(list.get(j).getLink() + " ");
                }
                if(s.contains(9)){
                    System.out.print(list.get(j).getOtherColors() + " ");
                }
                if(s.contains(10)){
                    System.out.print(list.get(j).getShortDescription() + " ");
                }
                if(s.contains(11)){
                    System.out.print(list.get(j).getDesigner() + " ");
                }
                if(s.contains(12)){
                    System.out.print(list.get(j).getDepth() + " ");
                }
                if(s.contains(13)){
                    System.out.print(list.get(j).getWidth() + " ");
                }
                if(s.contains(14)){
                    System.out.print(list.get(j).getHeight() + " ");
                }

                System.out.println();

                if(j == list.size() - 1){
                    System.out.println("\n" + (j + 1) + " entities listed");
                }
            }
        }

        sc.close();
    }
}