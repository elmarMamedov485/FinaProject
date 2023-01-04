import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
     public static void main(String[] args) {
        
        //ListManager.listRandom(ListManager.convertToList("FinalProject/ikea.csv"));
        List<Item> list = ConvertManager.convertToList("src/ikea.csv");

        menu(list);
    }

    public static void menu(List<Item> list){
         int choice = 0;
         List<Item> result = new ArrayList<>(list);
         String request = "List";

         while(choice != 15){
             System.out.println("\n\n////////////////////////////////////////");
             System.out.println("\n1.List ");
             System.out.println("2.Sort");
             System.out.println("3.Search");
             System.out.println("4.List column names");
             System.out.println("5.Filter");
             System.out.println("6.Export list of designers");
             System.out.println("7.Export products of each category");
             System.out.println("8.Export");
             System.out.println("9.Change list to original");
             System.out.println("Enter one number(enter 15 to exit):");

             Scanner sc = new Scanner(System.in);
             choice = sc.nextInt();

             switch(choice){
                 case 1:
                     PrintManager.listMenu(result);
                     break;
                 case 2:
                     result = SortManager.sort(result);
                     request = SortManager.getRequest();
                     break;
                 case 3:
                     result = SearchManager.search(result);
                     request = SearchManager.getRequest();
                     break;
                 case 4:
                     PrintManager.listColumnNames();
                     break;
                 case 5:
                     result = FilterManager.filter(result);
                     request = FilterManager.getRequest();
                     break;
                 case 6:
                     ExportDesignersManager.exportDesigners(list);
                     break;
                 case 7:
                     ExportCategoriesManager.export(list);
                     break;
                 case 8:
                     ExportManager.export(result, request);
                     break;
                 case 9:
                     result = list;
                     result = new ArrayList<>(list);
                     String request = "List";
                     break;
                 default:
                     if(choice != 15){
                         System.out.println("Wrong number!");
                     }
             }
         }

         System.out.println("Farewell!");
    }


}
