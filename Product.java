/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class Product {
    /**
    @author: José Pablo Kiesling Lange
    Program's name: Product
    @version: 
        - Creation's date: 14/03/2022
        - Last modification: 14/03/2022

    Product and his properties
    */ 

    //---------------------------PROPIEDADES--------------------------
    private String name;
    private String category;
    private int count;

    //---------------------------MÉTODOS------------------------------
    /*****************************************************************
     * instance the properties
     * @param name
     * @param category
     * @param count
     */
    public Product(String name, String category){
        this.name = name;
        this.category = category;
        this.count = 1;
    }
    //****************************************************************

    /*****************************************************************
     * incrementate the count of the product
     */
    public void addCount(){
        this.count++;
    }
    //****************************************************************

    /*****************************************************************
     * override of method toString
     * @return a friendly message of product's properties
     */
    public String toString(){
        return this.category + " | " + this.name + " | " + this.count;
    }
    //****************************************************************
}
