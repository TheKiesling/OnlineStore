/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Store {
    /**
    @author: José Pablo Kiesling Lange
    Program's name: Store
    @version: 
        - Creation's date: 14/03/2022
        - Last modification: 14/03/2022

    Control the model and do the methods that relate them
    */ 

    //---------------------------PROPERTIES---------------------------
    private Map<String, Product> inventory = null;
    private Map<String, Product> collection = null;
    private ArrayList<String> inventoryKeys;
    private ArrayList<String> collectionKeys;

    //---------------------------METHODS------------------------------

    /*****************************************************************
     * instance the maps and add the store information
     * @param option
     * @throws FileNotFoundException
     */
    public Store(int option) throws FileNotFoundException{
        try{
            inventory = (new FactoryMap<String, Product>()).newMap(option);
            collection = (new FactoryMap<String, Product>()).newMap(option);
            inventoryKeys = new ArrayList<String>(); 
            collectionKeys = new ArrayList<String>();
            read();
        }catch(FileNotFoundException e){
            String s = e.getMessage();
			throw new FileNotFoundException(s);
        }
    }
    //****************************************************************

    /*****************************************************************
     * read a File that contains the store information
     * @throws FileNotFoundException
     */
    private void read() throws FileNotFoundException{
        try{
            File file = new File("ListadoProducto.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String[] elements = reader.nextLine().split("[|]");
                String category = elements[0].trim();
                String nameProduct = elements[1].trim();
                insertProduct(category, nameProduct, inventory, inventoryKeys);
            }
            reader.close();
        }catch(FileNotFoundException e){
            String s =  e.getMessage();
			throw new FileNotFoundException(s);
        }
    }
    //****************************************************************

    /*****************************************************************
     * add a product to the colecction of the user if this product exist
     * @param category
     * @param nameProduct
     * @return the status of the adding of the product
     */
    public String newProduct(String category, String nameProduct){
        String status = "";
        Product product = null;
        String key = createKey(category, nameProduct);
        Boolean add = true;

        if(collection.containsKey(key)){ //If the user adds an existing product
            product = inventory.get(key);
            product.addAmount(); //Add the count of this product
            collection.remove(key);
            collection.put(key, product);
        }
        else{ //The product doesn't exist
            if (inventory.containsKey(key)) //Verify if the product exist
                insertProduct(category, nameProduct, collection, collectionKeys);
            else{ //The product doesn't exist
                status = "The product: " + nameProduct + " doesn't exist";
                add = false;
            }
        }

        if(add)
            status = "Adding: " + nameProduct;

        return status;
    }
    //****************************************************************

    /*****************************************************************
     * search the product's category that the user wants
     * @param nameProduct
     * @return the product's category
     */
    public String searchCategory(String nameProduct){
        String category = "";
        Boolean find = false;
        String[] keys = {};

        for(int i = 0; i < this.inventoryKeys.size() && find == false; i++){ //Look all the keys
            keys = this.inventoryKeys.get(i).split("[|]"); //Break the keys
            if (keys[1].equals(nameProduct)){ //Verify if the product is the same that the product that are looking
                category = keys[0]; //This is the category
                find = true;
            }
        }
        return "The category is: " + category;
    }
    //****************************************************************

    /*****************************************************************
     * choose the option of showing the products and print them
     * @Overload
     * @param option
     * @return all the products
     */
    public String showProducts(int option, int mapOption){
        String products = "";
        
        if (option == 3){
            products = "Category | Product | Amount" + "\n";
            products += showProducts(collectionKeys, collection, option);
        }
        else if (option == 4){
            products = "Category | Product | Amount" + "\n";
            products +=showProducts(collectionKeys, collection, mapOption, option);
        }
        else if (option == 5){
            products = "Category | Product" + "\n";
            products += showProducts(inventoryKeys, inventory, option);
        }
        else if (option == 6){
            products = "Category | Product" + "\n";
            products +=showProducts(inventoryKeys, inventory, mapOption, option);
        }
        return products;
    }
    //****************************************************************

    /*****************************************************************
     * show the product's information depends of the space that the user want
     * @Overload
     * @param keys
     * @return all the products
     */
    private String showProducts(ArrayList<String> keys, Map<String, Product> map, int option){
        String products = "";
        for(int i = 0; i < keys.size(); i++){
            Product product = map.get(keys.get(i));
            products += product.toString(option) + "\n";
        }
        return products;  
    }
    //****************************************************************

    /*****************************************************************
     * show the product's information sorted by tipe, depends of the space that the user want
     * @param keys
     * @param map
     * @param mapOption
     * @return all the products
     */
    private String showProducts(ArrayList<String> keys, Map<String, Product> map, int mapOption, int option){
        String products = "";
        List<Entry<String, Product>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByKey());
        Map<String, Product> result = new LinkedHashMap<>();
        for(Entry<String, Product> entry : list){
            result.put(entry.getKey(), entry.getValue());
            products += entry.getValue().toString(option) + "\n";
        }
        return products;
    }
    //****************************************************************

    /*****************************************************************
     * insert a product to the map
     * @param elements
     */
    private void insertProduct(String category, String nameProduct, Map<String, Product> map, ArrayList<String> keys){
        Product product = new Product(nameProduct, category);
        String key = createKey(category, nameProduct, keys);
        map.put(key, product);
    }
    //****************************************************************

    /*****************************************************************
     * create a key that will be the id of the product
     * @Overload
     * @param category
     * @param product
     * @return a key that serves to the map
     */
    private String createKey(String category, String product){
        String key = category.trim()  + "|" + product.trim();
        return key;
    }
    //****************************************************************

    /*****************************************************************
     * create a key that will be the id of the product and add it to an array
     * @Overload
     * @param category
     * @param product
     * @return a key that serves to the map
     */
    private String createKey(String category, String product, ArrayList<String> keys){
        String key = category.trim() + "|" + product.trim();
        keys.add(key);
        return key;
    }
    //****************************************************************
}
