import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchManager {
    public static List<Item> search(List<Item> list){
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

        try{
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Enter field(number):");
        n = sc.nextInt();
        sc.nextLine();
        switch(n){
            case 1:
                System.out.println("Enter item id: ");
                int item_id = sc.nextInt();

                List<Item> result = list.stream().filter(a -> a.getItemId() == item_id).collect(Collectors.toList());

                return result;

            case 2:
                System.out.println("Enter name:");
                String name = sc.nextLine();

                result = list.stream().filter(a -> a.getName().contains(name)).collect(Collectors.toList());

                return result;
            case 3:
                System.out.println("Enter old_price:");
                String category = sc.nextLine();

                result = list.stream().filter(a -> a.getCategory().contains(category)).collect(Collectors.toList());

                return result;
            case 4:
                System.out.println("Enter price: ");
                float price = sc.nextInt();

                result = list.stream().filter(a -> a.getPrice() == price).collect(Collectors.toList());

                return result;
            case 5:
                System.out.println("Enter old price:");
                String old_price = sc.nextLine();

                result = list.stream().filter(a -> a.getOldPrice().contains(old_price)).collect(Collectors.toList());

                return result;
            case 6:
                System.out.println("Enter sellable online(true, false):");
                boolean sellable_online = sc.nextBoolean();

                result = list.stream().filter(a -> Boolean.compare(a.getSellableOnline(), sellable_online) == 0).collect(Collectors.toList());

                return result;
            case 7:
                System.out.println("Enter link:");
                String link = sc.nextLine();

                result = list.stream().filter(a -> a.getLink().contains(link)).collect(Collectors.toList());

                return result;
            case 8:
                System.out.println("Enter other colours(True, False):");
                boolean other_colours = sc.nextBoolean();

                result = list.stream().filter(a -> Boolean.compare(a.getOtherColors(),other_colours) == 0).collect(Collectors.toList());

                return result;
            case 9:
                System.out.println("Enter short description:");
                String short_description =  sc.nextLine();

                result = list.stream().filter(a -> a.getShortDescription().contains(short_description)).collect(Collectors.toList());

                return result;
            case 10:
                System.out.println("Enter designer:");
                String designer = sc.nextLine();

                result = list.stream().filter(a -> a.getDesigner().contains(designer)).collect(Collectors.toList());

                return result;
            case 11:
                System.out.println("Enter depth: ");
                int depth = sc.nextInt();

               result = list.stream().filter(a -> a.getDepth() == depth).collect(Collectors.toList());

                return result;
            case 12:
                System.out.println("Enter height: ");
                int height = sc.nextInt();

                result = list.stream().filter(a -> a.getHeight() == height).collect(Collectors.toList());

                return result;

            case 13:
                System.out.println("Enter width: ");
                int width = sc.nextInt();

                result = list.stream().filter(a -> a.getWidth() == width).collect(Collectors.toList());

                return result;

            default:
                System.out.println("Wrong number!!!");
                break;
        }}catch (InputMismatchException e){
            System.out.println("Wrong input!");

        }

        return null;
    }
}
