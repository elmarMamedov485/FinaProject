import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortManager {
    public static void sort(List<Item> list){
        System.out.println("Choose field to sort by:");
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

        Map<String, Comparator<Item>> sortMapAsc = new HashMap<>();
        sortMapAsc.put("Item id", (Item i1, Item i2) -> {return i1.getItemId() - i2.getItemId();});
        sortMapAsc.put("Name", (Item i1, Item i2) -> {return i1.getName().compareTo(i2.getName());});
        sortMapAsc.put("Category", (Item i1, Item i2) -> {return i1.getCategory().compareTo(i2.getCategory());});
        sortMapAsc.put("Price", (Item i1, Item i2) -> {return Float.compare(i1.getPrice(), i2.getPrice());});
        sortMapAsc.put("Old price", (Item i1, Item i2) -> {return i1.getOldPrice().compareTo(i2.getOldPrice());});
        sortMapAsc.put("Sellable Online", (Item i1, Item i2) -> {return Boolean.compare(i1.getSellableOnline(),i2.getSellableOnline());});
        sortMapAsc.put("Link", (Item i1, Item i2) -> {return i1.getLink().compareTo(i2.getLink());});
        sortMapAsc.put("Other colours", (Item i1, Item i2) -> {return Boolean.compare(i1.getOtherColors(),i2.getOtherColors());});
        sortMapAsc.put("Short description", (Item i1, Item i2) -> {return i1.getShortDescription().compareTo(i2.getShortDescription());});
        sortMapAsc.put("Designer", (Item i1, Item i2) -> {return i1.getDesigner().compareTo(i2.getDesigner());});
        sortMapAsc.put("Depth", (Item i1, Item i2) -> {return i1.getDepth() - i2.getDepth();});
        sortMapAsc.put("Height", (Item i1, Item i2) -> {return i1.getHeight() - i2.getHeight();});
        sortMapAsc.put("Width", (Item i1, Item i2) -> {return i1.getWidth() - i2.getWidth();});

        Scanner sc = new Scanner(System.in);
        int n; 

        System.out.println("Enter field(number):");
        n = sc.nextInt();

        System.out.println("Choose order: ");
        System.out.println("1.Ascending");
        System.out.println("2.Descending");

        int order; 

        System.out.println("Enter order(number)");
        order = sc.nextInt();
        sc.close();
        switch(order){
            case 1:
            switch(n){
                case 1:
                    Comparator.comparing(Item::getItemId).thenComparing(Item::getName)
                            .thenComparing(Item::getCategory).thenComparing(Item::getPrice)
                            .thenComparing(Item::getOldPrice).thenComparing(Item::getSellableOnline)
                            .thenComparing(Item::getLink).thenComparing(Item::getOtherColors)
                            .thenComparing(Item::getShortDescription).thenComparing(Item::getDesigner)
                            .thenComparing(Item::getDepth).thenComparing(Item::getHeight).thenComparing(Item::getWidth);
                    break;
                case 2:
                    list.sort(sortMapAsc.get("Item id"));
                    break;
                case 3:
                    list.sort(sortMapAsc.get("Name"));
                    break;
                case 4:
                    list.sort(sortMapAsc.get("Category"));
                    break;
                case 5:
                    list.sort(sortMapAsc.get("Price"));
                    break;
                case 6:
                    list.sort(sortMapAsc.get("Old Price"));
                    break;
                case 7:
                    list.sort(sortMapAsc.get("Sellable Online"));
                    break;
                case 8:
                    list.sort(sortMapAsc.get("Link"));
                    break;
                case 9:
                    list.sort(sortMapAsc.get("Other colours"));
                    break;
                case 10:
                    list.sort(sortMapAsc.get("Short description"));
                    break;
                case 11:
                    list.sort(sortMapAsc.get("Designer"));
                    break;
                case 12:
                    list.sort(sortMapAsc.get("Depth"));
                    break;
                case 13:
                    list.sort(sortMapAsc.get("Height"));
                    break;
                case 14:
                    list.sort(sortMapAsc.get("Width"));
                    break;
                default:
                    System.out.println("Wrong number");
            }
                break;
                case 2:
                /*switch(n){
                    case 1:
                        System.out.println("Not Implemented yet");
                        break;
                    case 2:
                        Collections.sort(list, new SortByItemIdDsc());
                        break;
                    case 3:
                        Collections.sort(list, new SortByNameDsc());
                        break;
                    case 4:
                        Collections.sort(list, new SortByCategoryDsc());
                        break;
                    case 5:
                        Collections.sort(list, new SortByPriceDsc());
                        break;
                    case 6:
                        Collections.sort(list, new SortByOldPriceDsc());
                        break;
                    case 7:
                        Collections.sort(list, new SortBySellableOnlineDsc());
                        break;
                    case 8:
                        Collections.sort(list, new SortByLinkDsc());
                        break;
                    case 9:
                        Collections.sort(list, new SortByOtherColorsDsc());
                        break;
                    case 10:
                        Collections.sort(list, new SortByShortDescriptionDsc());
                        break;
                    case 11:
                        Collections.sort(list, new SortByDesignerDsc());
                        break;
                    case 12:
                        Collections.sort(list, new SortByDepthDsc());
                        break;
                    case 13:
                        Collections.sort(list, new SortByHeightDsc());
                        break;
                    case 14:
                        Collections.sort(list, new SortByWidthDsc());
                        break;
                    default:
                        System.out.println("Wrong number");
                }*/
                break;
                default:
                    System.out.println("Wrong number");
        }
        
    }
}
