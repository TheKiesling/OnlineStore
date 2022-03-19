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
import java.util.ArrayList;

public class Store {
    /**
    @author: José Pablo Kiesling Lange
    Program's name: Store
    @version: 
        - Creation's date: 14/03/2022
        - Last modification: 14/03/2022

    Control the model and do the methods that relate them
    */ 

    //---------------------------PROPIEDADES--------------------------
    private Map<String, Product> inventory = null;
    private Map<String, Product> collection = null;
    private ArrayList<String> keys;

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * instance the maps and add the store information
     * @param option
     * @throws FileNotFoundException
     */
    public Store(int option) throws FileNotFoundException{
        try{
            inventory = (new FactoryMap<String, Product>()).newMap(option);
            collection = (new FactoryMap<String, Product>()).newMap(option); 
            read();
        }catch(FileNotFoundException e){
            String s = "Store.read:" + e.getMessage();
			throw new FileNotFoundException(s);
        }
    }
    //****************************************************************

    /*****************************************************************
     * read a File that contains the store information
     * @throws FileNotFoundException
     */
    private void read() throws FileNotFoundException{
        String[] elements = new String[2];
        try{
            File file = new File("ListadoProducto.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine())
                elements = reader.nextLine().split("|");
                String category = elements[0];
                String nameProduct = elements[1];
                insertProduct(category, nameProduct, inventory);
            reader.close();
        }catch(FileNotFoundException e){
            String s = "Store.read:" + e.getMessage();
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
            product.addCount(); //Add the count of this product
        }
        else{ //The product doesn't exist
            if (inventory.containsKey(key)) //Verify if the product exist
                insertProduct(category, nameProduct, collection);
            else{ //The product doesn't exist
                status = "The product: " + product + " doesn't exist";
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

        for(int i = 0; i < this.keys.size() && find == false; i++){ //Look all the keys
            keys = this.keys.get(i).split("|"); //Break the keys
            if (keys[1] == nameProduct){ //Verify if the product is the same that the product that are looking
                category = keys[0]; //This is the category
                find = true;
            }
        }
        return category;
    }
    //****************************************************************

    /*****************************************************************
     * insert a product to the map
     * @param elements
     */
    private void insertProduct(String category, String nameProduct, Map<String, Product> map){
        Product product = new Product(nameProduct, category);
        String key = createKey(category, nameProduct);
        map.put(key, product);
    }
    //****************************************************************

    /*****************************************************************
     * create a key that will be the id of the product
     * @param category
     * @param product
     * @return a key that serves to the map
     */
    private String createKey(String category, String product){
        category.trim(); product.trim();
        String key = category + "|" + product;
        keys.add(key);
        return key;
    }
    //****************************************************************
}
