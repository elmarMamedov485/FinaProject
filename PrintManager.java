import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ListManager {

    //prints entities of a given list
    public static void printList(List<Item> list){
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