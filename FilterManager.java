import java.util.*;
import java.util.stream.Collectors;

public class FilterManager {
    private static Scanner sc = new Scanner(System.in);
    private static List<Item> result = new ArrayList<>();
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

        
    public static List<Item> filter(List<Item> list){

        Set s = menu();
        List<Item> result = new ArrayList<>(list);
        int choice = 0;
        List<Integer> fields = new ArrayList<>(s);
        for(int j = 0; j < s.size(); j++){
            switch (fields.get(j)){
                case 1:
                    choice = chooseFilter();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter number:");
                            int n = sc.nextInt();
                            result = result.stream().filter(a -> a.getItemId() == n).collect(Collectors.toList());
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
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter name:");
                    String name = sc.nextLine();

                    result = result.stream().filter(a -> a.getName().contains(name)).collect(Collectors.toList());
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter category:");
                    String category = sc.nextLine();

                    result = result.stream().filter(a -> a.getCategory().contains(category)).collect(Collectors.toList());
                    break;
                case 4:
                    choice = chooseFilter();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter number:");
                            int n = sc.nextInt();
                            result = result.stream().filter(a -> a.getPrice() == n).collect(Collectors.toList());
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
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter old price:");
                    String old_price = sc.nextLine();

                    result = result.stream().filter(a -> a.getOldPrice().contains(old_price)).collect(Collectors.toList());
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Enter sellable online(true, false):");
                    boolean sellable_online = sc.nextBoolean();

                    result = result.stream().filter(a -> Boolean.compare(a.getSellableOnline(), sellable_online) == 0).collect(Collectors.toList());
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Enter link:");
                    String link = sc.nextLine();

                    result = result.stream().filter(a -> a.getLink().contains(link)).collect(Collectors.toList());
                    break;
                case 8:
                    sc.nextLine();
                    System.out.println("Enter other colours(True, False):");
                    boolean other_colours = sc.nextBoolean();

                    result = result.stream().filter(a -> Boolean.compare(a.getOtherColors(),other_colours) == 0).collect(Collectors.toList());
                    break;
                case 9:
                    sc.nextLine();
                    System.out.println("Enter short description:");
                    String short_description =  sc.nextLine();

                    result = result.stream().filter(a -> a.getShortDescription().contains(short_description)).collect(Collectors.toList());
                    break;
                case 10:
                    sc.nextLine();
                    System.out.println("Enter designer:");
                    String designer = sc.nextLine();

                    result = result.stream().filter(a -> a.getDesigner().contains(designer)).collect(Collectors.toList());
                    break;
                case 11:
                    choice = chooseFilter();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter number:");
                            int n = sc.nextInt();
                            result = result.stream().filter(a -> a.getDepth() == n).collect(Collectors.toList());
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
                    break;
                case 12:
                    choice = chooseFilter();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter number:");
                            int n = sc.nextInt();
                            result = result.stream().filter(a -> a.getHeight() == n).collect(Collectors.toList());
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
                            result = result.stream().filter(a -> a.getHeight() < n1 && a.getHeight() > n).collect(Collectors.toList());
                        }

                        default -> throw new IllegalStateException("Unexpected value: " + choice);
                    }
                    break;
                case 13:
                    choice = chooseFilter();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter number:");
                            int n = sc.nextInt();
                            result = result.stream().filter(a -> a.getWidth() == n).collect(Collectors.toList());
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
                    break;
            }

            //System.out.println(result.toString())
        }

        return result;
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
