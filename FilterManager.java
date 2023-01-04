import java.util.*;
import java.util.stream.Collectors;

public class FilterManager extends SearchManager{
    private static Scanner sc = new Scanner(System.in);
    private static List<Item> result;
    private static Set menu(){
        System.out.println("Choose fields to filter by:");
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
        System.out.println("\nEnter numbers (enter 14 to stop and Enter buttons):");

        int[] arr = new int[13];

        int i = 0;
        while(true){
            int n = sc.nextInt();

            if(n == 14){
                break;
            }
            if(i >= 13){
                break;
            }
            if(n > 14){
                System.out.println("Wrong number");
                continue;
            }

            arr[i] = n;

            i++;
        }

        Set s = new HashSet<>();

        for (int k : arr) {
            s.add(k);
        }

        return s;
    }
    private static List<Item> filterItemId(List<Item> list){
        result = new ArrayList<>(list);
        int choice = chooseFilter();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = SearchManager.searchItemId(list, n);
            }
            case 2 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getItemId() > n).collect(Collectors.toList());
            }
            case 3 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getItemId() < n).collect(Collectors.toList());
            }
            case 4 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getItemId() >= n).collect(Collectors.toList());
            }
            case 5 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getItemId() <= n).collect(Collectors.toList());
            }
            case 6 -> {
                System.out.println("Enter lower boundary:");
                int n = sc.nextInt();
                System.out.println("Enter upper boundary:");
                int n1 = sc.nextInt();
                result = result.stream().filter(a -> a.getItemId() < n1 && a.getItemId() > n).collect(Collectors.toList());
            }

            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        return result;
    }
    private static List<Item> filterPrice(List<Item> list){
        result = new ArrayList<>(list);
        int choice = chooseFilter();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = searchPrice(list, n);
            }
            case 2 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getPrice() > n).collect(Collectors.toList());
            }
            case 3 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getPrice() < n).collect(Collectors.toList());
            }
            case 4 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getPrice() >= n).collect(Collectors.toList());
            }
            case 5 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getPrice() <= n).collect(Collectors.toList());
            }
            case 6 -> {
                System.out.println("Enter lower boundary:");
                int n = sc.nextInt();
                System.out.println("Enter upper boundary:");
                int n1 = sc.nextInt();
                result = result.stream().filter(a -> a.getPrice() < n1 && a.getPrice() > n).collect(Collectors.toList());
            }

            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        return result;
    }
    private static List<Item> filterDepth(List<Item> list){
        int  choice = chooseFilter();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = searchDepth(list, n);
            }
            case 2 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getDepth() > n).collect(Collectors.toList());
            }
            case 3 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getDepth() < n).collect(Collectors.toList());
            }
            case 4 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getDepth() >= n).collect(Collectors.toList());
            }
            case 5 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getDepth() <= n).collect(Collectors.toList());
            }
            case 6 -> {
                System.out.println("Enter lower boundary:");
                int n = sc.nextInt();
                System.out.println("Enter upper boundary:");
                int n1 = sc.nextInt();
                result = result.stream().filter(a -> a.getDepth() < n1 && a.getDepth() > n).collect(Collectors.toList());
            }

            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        return result;
    }
    private static List<Item> filterHeight(List<Item> list){
        result = new ArrayList<>(list);
        int choice = chooseFilter();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();

               result = searchHeight(list, n);
            }
            case 2 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getHeight() > n).collect(Collectors.toList());
            }
            case 3 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getHeight() < n).collect(Collectors.toList());
            }
            case 4 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getHeight() >= n).collect(Collectors.toList());
            }
            case 5 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getHeight() <= n).collect(Collectors.toList());
            }
            case 6 -> {
                System.out.println("Enter lower boundary:");
                int n = sc.nextInt();
                System.out.println("Enter upper boundary:");
                int n1 = sc.nextInt();
                result = result.stream().filter(a -> (a.getHeight() > n && a.getHeight() < n1)).collect(Collectors.toList());
            }

            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        return result;
    }
    private static List<Item> filterWidth(List<Item> list){
        result = new ArrayList<>(list);
        int choice = chooseFilter();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();

                result = searchWidth(list, n);
            }
            case 2 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getWidth() > n).collect(Collectors.toList());
            }
            case 3 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getWidth() < n).collect(Collectors.toList());
            }
            case 4 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getWidth() >= n).collect(Collectors.toList());
            }
            case 5 -> {
                System.out.println("Enter number:");
                int n = sc.nextInt();
                result = result.stream().filter(a -> a.getWidth() <= n).collect(Collectors.toList());
            }
            case 6 -> {
                System.out.println("Enter lower boundary:");
                int n = sc.nextInt();
                System.out.println("Enter upper boundary:");
                int n1 = sc.nextInt();
                result = result.stream().filter(a -> a.getWidth() < n1 && a.getWidth() > n).collect(Collectors.toList());
            }

            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        return result;
    }
    public static List<Item> filter(List<Item> list){

        Set s = menu();
        List<Item> finalResult = new ArrayList<>(list);
        int choice = 0;
        List<Integer> fields = new ArrayList<>(s);
        for(int j = 0; j < s.size(); j++){
            switch (fields.get(j)){
                case 1:
                    finalResult =  filterItemId(finalResult);
                    break;
                case 2:
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    finalResult = searchName(finalResult, name);
                    break;
                case 3:
                    System.out.println("Enter category:");
                    String category = sc.nextLine();
                    finalResult = searchCategory(finalResult, category);
                    break;
                case 4:
                    finalResult = filterPrice(finalResult);
                    break;
                case 5:
                    System.out.println("Enter old price:");
                    String old_price = sc.nextLine();
                    finalResult = searchOldPrice(finalResult, old_price);
                    break;
                case 6:
                    System.out.println("Enter sellable online(true, false):");
                    boolean sellable_online = sc.nextBoolean();
                    finalResult = searchSellableOnline(finalResult, sellable_online);
                    break;
                case 7:
                    System.out.println("Enter link:");
                    String link = sc.nextLine();
                    finalResult = searchLink(finalResult, link);
                    break;
                case 8:
                    System.out.println("Enter other colours(True, False):");
                    boolean other_colours = sc.nextBoolean();
                    finalResult = searchOtherColours(finalResult, other_colours);
                    break;
                case 9:
                    System.out.println("Enter short description:");
                    String short_description =  sc.nextLine();
                    finalResult = searchShortDescription(finalResult, short_description);
                    break;
                case 10:
                    System.out.println("Enter designer:");
                    String designer = sc.nextLine();
                    finalResult = searchDesigner(finalResult, designer);
                    break;
                case 11:
                    finalResult = filterDepth(finalResult);
                    break;
                case 12:
                    finalResult = filterHeight(finalResult);
                    break;
                case 13:
                    finalResult = filterWidth(finalResult);
                    break;
            }
        }

        return finalResult;
    }

    //enables user to choose filter for numbers
    private static int chooseFilter(){
        System.out.println("Enter your choice (enter number): ");
        System.out.println("1.Equal to");
        System.out.println("2.Greater than");
        System.out.println("3.Less than");
        System.out.println("4.Greater or equal to");
        System.out.println("5.Less or equal to");
        System.out.println("6.Between");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        return n;
    }

}
