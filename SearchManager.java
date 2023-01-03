import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchManager {
    private static  Scanner sc = new Scanner(System.in);
    private static List<Item> result = new ArrayList<>();
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

    protected static List<Item>  searchItemId(List<Item> list){
        System.out.println("Enter item id: ");
        int item_id = sc.nextInt();

        List<Item> result = list.stream().filter(a -> a.getItemId() == item_id).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchName(List<Item> list){
        System.out.println("Enter name:");
        String name = sc.nextLine();

        result = list.stream().filter(a -> a.getName().contains(name)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchCategory(List<Item> list){
        System.out.println("Enter category:");
        String category = sc.nextLine();

        result = list.stream().filter(a -> a.getCategory().contains(category)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchPrice(List<Item> list){
        System.out.println("Enter price: ");
        float price = sc.nextInt();

        result = list.stream().filter(a -> a.getPrice() == price).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchOldPrice(List<Item> list){
        System.out.println("Enter old price:");
        String old_price = sc.nextLine();

        result = list.stream().filter(a -> a.getOldPrice().contains(old_price)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchSellableOnline(List<Item> list){
        System.out.println("Enter sellable online(true, false):");
        boolean sellable_online = sc.nextBoolean();

        result = list.stream().filter(a -> Boolean.compare(a.getSellableOnline(), sellable_online) == 0).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchLink(List<Item> list){
        System.out.println("Enter link:");
        String link = sc.nextLine();

        result = list.stream().filter(a -> a.getLink().contains(link)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchOtherColours(List<Item> list){
        System.out.println("Enter other colours(True, False):");
        boolean other_colours = sc.nextBoolean();

        result = list.stream().filter(a -> Boolean.compare(a.getOtherColors(),other_colours) == 0).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchShortDescription(List<Item> list){
        System.out.println("Enter short description:");
        String short_description =  sc.nextLine();

        result = list.stream().filter(a -> a.getShortDescription().contains(short_description)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchDesigner(List<Item> list){
        System.out.println("Enter designer:");
        String designer = sc.nextLine();

        result = list.stream().filter(a -> a.getDesigner().contains(designer)).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchDepth(List<Item> list){
        System.out.println("Enter depth: ");
        int depth = sc.nextInt();

        result = list.stream().filter(a -> a.getDepth() == depth).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchHeight(List<Item> list){
        System.out.println("Enter height: ");
        int height = sc.nextInt();

        result = list.stream().filter(a -> a.getHeight() == height).collect(Collectors.toList());

        return result;
    }
    protected static List<Item>  searchWidth(List<Item> list){
        System.out.println("Enter width: ");
        int width = sc.nextInt();

        result = list.stream().filter(a -> a.getWidth() == width).collect(Collectors.toList());

        return result;
    }
    public static List<Item> search(List<Item> list){
        List<Item> searchResult = new ArrayList<>();
        try{
        int n = menu();

        sc.nextLine();
        switch(n){
            case 1:
                searchResult = searchItemId(list);
                break;
            case 2:
                searchResult = searchName(list);
                break;
            case 3:
                searchResult = searchCategory(list);
                break;
            case 4:
                searchResult = searchPrice(list);
                break;
            case 5:
                searchResult = searchOldPrice(list);
                break;
            case 6:
                searchResult = searchSellableOnline(list);
                break;
            case 7:
                searchResult = searchLink(list);
                break;
            case 8:
                searchResult = searchOtherColours(list);
                break;
            case 9:
                searchResult = searchShortDescription(list);
                break;
            case 10:
                searchResult = searchDesigner(list);
                break;
            case 11:
                searchResult = searchDepth(list);
                break;
            case 12:
                searchResult = searchHeight(list);
                break;
            case 13:
                searchResult = searchWidth(list);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }}catch (InputMismatchException e){
            System.out.println("Wrong input!");

        }

        return searchResult;
    }
}
