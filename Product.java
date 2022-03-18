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
    Nombre del programa: AbstractMap.java
    @version: 
        - Creación: 17/03/2022
        - Última modificación: 17/03/2022

    Clase que implementa la interfaz de pilas, y sirve como ADT
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
    public Product(String name, String category, int count){
        this.name = name;
        this.category = category;
        this.count = count;
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
     */
    public String toString(){
        return this.category + " | " + this.name + " | " + this.count;
    }
    //****************************************************************
}
