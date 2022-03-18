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
    Nombre del programa: Factory Map
    @version: 
        - Creación: 14/03/2022
        - Última modificación: 14/03/2022

    Clase que usa el patron Factory para la creacion del mapa
    */ 

    /*****************************************************************
     * crea una instancia del mapa usando el patrón factory
     * @param option
     * @return map
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
