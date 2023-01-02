public class Item {
    private int item_id;
    private String name;
    private String category;
    private float price;
    private String old_price;
    private boolean sellable_online;
    private String link;
    private boolean other_colors;
    private String short_description;
    private String designer;
    private int depth;
    private int height;
    private int width;

    Item(int item_id, String name, String category, float price, String old_price, boolean sellable_online,
        String link, boolean other_colors, String short_description, String designer, int depth,int height, int width){
            this.item_id = item_id;
            this.name = name;
            this.category = category;
            this.price = price;
            this.old_price = old_price;
            this.sellable_online = sellable_online;
            this.link = link;
            this.other_colors = other_colors;
            this.short_description = short_description;
            this.designer = designer;
            this.depth = depth;
            this.height = height;
            this.width = width;
    }

    public String toString(){
        return item_id + ", " + name + ", " + category + ", " + price + ", "+  old_price + ", " + 
               sellable_online + ", " + link + ", " + other_colors + ", " + short_description + ", " +
               designer + ", " + depth + ", " + height + ", " + width + "\n";
    }

    public int getItemId(){
        return this.item_id;
    }

    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.category;
    }

    public float getPrice(){
        return this.price;
    }

    public String getOldPrice(){
        return this.old_price;
    }

    public boolean getSellableOnline(){
        return this.sellable_online;
    }

    public String getLink(){
        return this.link;
    }

    public boolean getOtherColors(){
        return this.other_colors;
    }

    public String getShortDescription(){
        return this.short_description;
    }

    public String getDesigner(){
        return this.designer;
    }

    public int getDepth(){
        return this.depth;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
}
