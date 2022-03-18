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

public class AbstractMap<K,V> implements IMap<K, V> {
    /**
    @author: José Pablo Kiesling Lange
    Nombre del programa: AbstractMap.java
    @version: 
        - Creación: 15/03/2022
        - Última modificación: 15/03/2022

    Clase que implementa la interfaz de pilas, y sirve como ADT
    */ 

    Map<K, V> map = null;
    
    public AbstractMap(int option){
        this.map = (new FactoryMap<K, V>()).newMap(option);
    }

    @Override
    public int size(){
        return map.size();
    }

    @Override
    public boolean isEmpty(){
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(K k) {
        return map.containsKey(k);
    }

    @Override
    public boolean containsValue(V v) {
        return map.containsValue(v);
    }

    @Override
    public V get(K k) {
        return map.get(k);
    }

    @Override
    public V put(K k, V v){
        return map.put(k, v);
    }

    @Override
    public V remove(K k) {
        return map.remove(k);
    }

    @Override
    public void putAll(IMap<K, V> other) {
        map.putAll(map);        
    }

    @Override
    public void clear() {
        map.clear();
    }

}
