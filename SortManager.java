import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SortManager {
    private static String request = new String();
    public static String getRequest(){return request;}
    public static List<Item> sort(List<Item> list){
        request = new String();
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

        Map<String, Comparator<Item>> sortMapDsc = new HashMap<>();
        sortMapDsc.put("Item id", (Item i1, Item i2) -> {return i2.getItemId() - i1.getItemId();});
        sortMapDsc.put("Name", (Item i1, Item i2) -> {return i2.getName().compareTo(i1.getName());});
        sortMapDsc.put("Category", (Item i1, Item i2) -> {return i2.getCategory().compareTo(i1.getCategory());});
        sortMapDsc.put("Price", (Item i1, Item i2) -> {return Float.compare(i2.getPrice(), i1.getPrice());});
        sortMapDsc.put("Old price", (Item i1, Item i2) -> {return i2.getOldPrice().compareTo(i1.getOldPrice());});
        sortMapDsc.put("Sellable Online", (Item i1, Item i2) -> {return Boolean.compare(i2.getSellableOnline(),i1.getSellableOnline());});
        sortMapDsc.put("Link", (Item i1, Item i2) -> {return i2.getLink().compareTo(i1.getLink());});
        sortMapDsc.put("Other colours", (Item i1, Item i2) -> {return Boolean.compare(i2.getOtherColors(),i1.getOtherColors());});
        sortMapDsc.put("Short description", (Item i1, Item i2) -> {return i2.getShortDescription().compareTo(i1.getShortDescription());});
        sortMapDsc.put("Designer", (Item i1, Item i2) -> {return i2.getDesigner().compareTo(i1.getDesigner());});
        sortMapDsc.put("Depth", (Item i1, Item i2) -> {return i2.getDepth() - i1.getDepth();});
        sortMapDsc.put("Height", (Item i1, Item i2) -> {return i2.getHeight() - i1.getHeight();});
        sortMapDsc.put("Width", (Item i1, Item i2) -> {return i2.getWidth() - i1.getWidth();});

        Scanner sc = new Scanner(System.in);
        int n = 0;
        int order = 0;
        try {
            System.out.println("Enter number (enter 15 to go back):");
            n = sc.nextInt();

            if(n ==15){
                return list;
            }
            else if(n > 15){
                System.out.println("Wrong number");
                return list;
            }

            System.out.println("Choose order: ");
            System.out.println("1.Ascending");
            System.out.println("2.Descending");

            System.out.println("Enter order(number)");
            order = sc.nextInt();
            if(order != 1 || order != 2){
                System.out.println("Wrong number");
                return list;
            }


        }catch(Exception e){
            System.out.println("Wrong input!");
        }
        switch(order){
            case 1:
            switch(n){
                case 1:
                    list.sort(Comparator.comparing(Item::getItemId).thenComparing(Item::getName)
                            .thenComparing(Item::getCategory).thenComparing(Item::getPrice)
                            .thenComparing(Item::getOldPrice).thenComparing(Item::getSellableOnline)
                            .thenComparing(Item::getLink).thenComparing(Item::getOtherColors)
                            .thenComparing(Item::getShortDescription).thenComparing(Item::getDesigner)
                            .thenComparing(Item::getDepth).thenComparing(Item::getHeight).thenComparing(Item::getWidth));
                    request += "Sort_all_ascending_order";
                    break;
                case 2:
                    list.sort(sortMapAsc.get("Item id"));
                    request += "Sort_item_id_ascending_order";
                    break;
                case 3:
                    list.sort(sortMapAsc.get("Name"));
                    request += "Sort_name_ascending_order";
                    break;
                case 4:
                    list.sort(sortMapAsc.get("Category"));
                    request += "Sort_category_ascending_order";
                    break;
                case 5:
                    list.sort(sortMapAsc.get("Price"));
                    request += "Sort_price_ascending_order";
                    break;
                case 6:
                    list.sort(sortMapAsc.get("Old Price"));
                    request += "Sort_old_price_ascending_order";
                    break;
                case 7:
                    list.sort(sortMapAsc.get("Sellable Online"));
                    request += "Sort_sellable_online_ascending_order";
                    break;
                case 8:
                    list.sort(sortMapAsc.get("Link"));
                    request += "Sort_link_ascending_order";
                    break;
                case 9:
                    list.sort(sortMapAsc.get("Other colours"));
                    request += "Sort_other_colours_ascending_order";
                    break;
                case 10:
                    list.sort(sortMapAsc.get("Short description"));
                    request += "Sort_short_description_ascending_order";
                    break;
                case 11:
                    list.sort(sortMapAsc.get("Designer"));
                    request += "Sort_designer_ascending_order";
                    break;
                case 12:
                    list.sort(sortMapAsc.get("Depth"));
                    request += "Sort_depth_ascending_order";
                    break;
                case 13:
                    list.sort(sortMapAsc.get("Height"));
                    request += "Sort_height_ascending_order";
                    break;
                case 14:
                    list.sort(sortMapAsc.get("Width"));
                    request += "Sort_width_ascending_order";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + n);
            }
                break;
                case 2:
                switch(n){
                    case 1:
                        list.sort(Comparator.comparing(Item::getItemId).thenComparing(Item::getName)
                                .thenComparing(Item::getCategory).thenComparing(Item::getPrice)
                                .thenComparing(Item::getOldPrice).thenComparing(Item::getSellableOnline)
                                .thenComparing(Item::getLink).thenComparing(Item::getOtherColors)
                                .thenComparing(Item::getShortDescription).thenComparing(Item::getDesigner).reversed());
                        request += "Sort_all_descending_order";
                        break;
                    case 2:
                        list.sort(sortMapDsc.get("Item id"));
                        request += "Sort_item_id_descending_order";
                        break;
                    case 3:
                        list.sort(sortMapDsc.get("Name"));
                        request += "Sort_name_descending_order";
                        break;
                    case 4:
                        list.sort(sortMapDsc.get("Category"));
                        request += "Sort_category_descending_order";
                        break;
                    case 5:
                        list.sort(sortMapDsc.get("Price"));
                        request += "Sort_price_descending_order";
                        break;
                    case 6:
                        list.sort(sortMapDsc.get("Old Price"));
                        request += "Sort_old_price_descending_order";
                        break;
                    case 7:
                        list.sort(sortMapDsc.get("Sellable Online"));
                        request += "Sort_sellable_online_descending_order";
                        break;
                    case 8:
                        list.sort(sortMapDsc.get("Link"));
                        request += "Sort_link_descending_order";
                        break;
                    case 9:
                        list.sort(sortMapDsc.get("Other colours"));
                        request += "Sort_other_colours_descending_order";
                        break;
                    case 10:
                        list.sort(sortMapDsc.get("Short description"));
                        request += "Sort_short_description_descending_order";
                        break;
                    case 11:
                        list.sort(sortMapDsc.get("Designer"));
                        request += "Sort_designer_descending_order";
                        break;
                    case 12:
                        list.sort(sortMapDsc.get("Depth"));
                        request += "Sort_depth_descending_order";
                        break;
                    case 13:
                        list.sort(sortMapDsc.get("Height"));
                        request += "Sort_height_descending_order";
                        break;
                    case 14:
                        list.sort(sortMapDsc.get("Width"));
                        request += "Sort_width_descending_order";
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + n);
                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + n);
        }

        return list;
    }

}
