import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchManager {
    private static  Scanner sc = new Scanner(System.in);
    private static int menu(){
        System.out.println("Choose field to search by:");
        System.out.println("1. Item id");
        System.out.println("2. Name");
        System.out.println("3. Category");
        System.out.println("4. Price");
        System.out.println("5. Old price");
        System.out.println("6. Sellable online");
        System.out.println("7. Link");
        System.out.println("8. Other colours");
        System.out.println("9. Short description");
        System.out.println("10. Designer");
        System.out.println("11. Depth");
        System.out.println("12. Height");
        System.out.println("13. Width");
        int n = 0;
        try {
           System.out.println("Enter field(number):");
            n = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Wrong input!");
        }
        return n;
    }

    protected static List<Item>  searchItemId(List<Item> list, int item_id){
        List<Item> result = list.stream().filter(a -> a.getItemId() == item_id).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchName(List<Item> list, String name){
        List<Item> result = list.stream().filter(a -> a.getName().contains(name)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchCategory(List<Item> list, String category){
        List<Item> result = list.stream().filter(a -> a.getCategory().contains(category)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchPrice(List<Item> list, float price){
        List<Item> result = list.stream().filter(a -> a.getPrice() == price).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchOldPrice(List<Item> list, String old_price){
        List<Item> result = list.stream().filter(a -> a.getOldPrice().contains(old_price)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchSellableOnline(List<Item> list, boolean sellable_online){
        List<Item> result = list.stream().filter(a -> Boolean.compare(a.getSellableOnline(), sellable_online) == 0).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchLink(List<Item> list, String link){
        List<Item> result = list.stream().filter(a -> a.getLink().contains(link)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchOtherColours(List<Item> list, boolean other_colours){
        List<Item> result = list.stream().filter(a -> Boolean.compare(a.getOtherColors(),other_colours) == 0).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchShortDescription(List<Item> list, String short_description){
        List<Item> result = list.stream().filter(a -> a.getShortDescription().contains(short_description)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchDesigner(List<Item> list, String designer){
        List<Item> result = list.stream().filter(a -> a.getDesigner().contains(designer)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchDepth(List<Item> list, int depth){
        List<Item> result = list.stream().filter(a -> a.getDepth() == depth).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchHeight(List<Item> list, int height){
        List<Item> result = list.stream().filter(a -> a.getHeight() == height).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchWidth(List<Item> list, int width){
        List<Item> result = list.stream().filter(a -> a.getWidth() == width).collect(Collectors.toList());

        return result;
    }
    public static List<Item> search(List<Item> list){
        List<Item> searchResult = new ArrayList<>();
        try{
        int n = menu();

        sc.nextLine();
        switch(n){
            case 1:
                System.out.println("Enter item id: ");
                int item_id = sc.nextInt();
                searchResult = searchItemId(list, item_id);
                break;
            case 2:
                System.out.println("Enter name:");
                String name = sc.nextLine();
                searchResult = searchName(list, name);
                break;
            case 3:
                System.out.println("Enter category:");
                String category = sc.nextLine();
                searchResult = searchCategory(list, category);
                break;
            case 4:
                System.out.println("Enter price: ");
                float price = sc.nextFloat();
                searchResult = searchPrice(list, price);
                break;
            case 5:
                System.out.println("Enter old price:");
                String old_price = sc.nextLine();

                searchResult = searchOldPrice(list, old_price);
                break;
            case 6:
                System.out.println("Enter sellable online(true, false):");
                boolean sellable_online = sc.nextBoolean();

                searchResult = searchSellableOnline(list, sellable_online);
                break;
            case 7:
                System.out.println("Enter link:");
                String link = sc.nextLine();

                searchResult = searchLink(list, link);
                break;
            case 8:
                System.out.println("Enter other colours(True, False):");
                boolean other_colours = sc.nextBoolean();
                searchResult = searchOtherColours(list, other_colours);
                break;
            case 9:
                System.out.println("Enter short description:");
                String short_description =  sc.nextLine();

                searchResult = searchShortDescription(list, short_description);
                break;
            case 10:
                System.out.println("Enter designer:");
                String designer = sc.nextLine();

                searchResult = searchDesigner(list, designer);
                break;
            case 11:
                System.out.println("Enter depth: ");
                int depth = sc.nextInt();

                searchResult = searchDepth(list, depth);
                break;
            case 12:
                System.out.println("Enter height: ");
                int height = sc.nextInt();
                searchResult = searchHeight(list, height);
                break;
            case 13:
                System.out.println("Enter width: ");
                int width = sc.nextInt();
                searchResult = searchWidth(list, width);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }}catch (InputMismatchException e){
            System.out.println("Wrong input!");

        }

        return searchResult;
    }
}
