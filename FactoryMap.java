/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;

public class FactoryMap<K,V> {
    /**
    @author: José Pablo Kiesling Lange
    Program's name: Factory Map
    @version: 
        - Creation's date: 14/03/2022
        - Last modification: 14/03/2022

    Class that use the Factory pattern to create the instance of the map
    */ 

    //---------------------------MÉTODOS------------------------------
    /*****************************************************************
     * instance of map using factory pattern
     * @param option
     * @return instance of map
     */
    public Map<K,V> newMap(int option){
        Map<K,V> map = null;
        if (option == 1)
            map = new HashMap<K, V>();
        if (option == 2)
            map = new TreeMap<K, V>();
        if (option == 3)
            map = new LinkedHashMap<K, V>();
        return map;
    }
    //****************************************************************
}
