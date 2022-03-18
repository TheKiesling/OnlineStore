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
    Program's name: Abstract Map
    @version: 
        - Creation's date: 14/03/2022
        - Last modification: 14/03/2022

    Class that implements the Map's Interface and use polimorfism to do the methods
    */ 

    //---------------------------PROPIEDADES--------------------------
    Map<K, V> map = null;
    
    //---------------------------MÉTODOS------------------------------
    /*****************************************************************
     * instance the map using the class of factory pattern
     * @param option
     */
    public AbstractMap(int option){
        this.map = (new FactoryMap<K, V>()).newMap(option);
    }
    //****************************************************************

    /*****************************************************************
     * @post returns the number of entries in the map
     */
    public int size(){
        return map.size();
    }
    //****************************************************************

    /*****************************************************************
     * @post returns true iff this map does not contain any entries
     */
    public boolean isEmpty(){
        return map.isEmpty();
    }
    //****************************************************************

    /*****************************************************************
     * @pre k is non-null
     * @post returns true iff k is in the domain of the map
     */
    public boolean containsKey(K k) {
        return map.containsKey(k);
    }
    //****************************************************************

    /*****************************************************************
     * @pre v is non-null
     * @post returns true iff v is the target of at least one map entry;
     * that is, v is in the range of the map
     */
    public boolean containsValue(V v) {
        return map.containsValue(v);
    }
    //****************************************************************

    /*****************************************************************
     * @pre k is a key, possibly in the map
     * @post returns the value mapped to from k, or null
     */
    public V get(K k) {
        return map.get(k);
    }
    //****************************************************************

    /*****************************************************************
     * @pre k and v are non-null
     * @post inserts a mapping from k to v in the map
     */
    public V put(K k, V v){
        return map.put(k, v);
    }
    //****************************************************************

    /*****************************************************************
     * @pre k is non-null
     * @post removes any mapping from k to a value, from the mapping
     */
    public V remove(K k) {
        return map.remove(k);
    }
    //****************************************************************

    /*****************************************************************
     * @pre other is non-null
     * @post all the mappings of other are installed in this map,
     * overriding any conflicting maps
     */
    public void putAll(IMap<K, V> other) {
        map.putAll(map);        
    }
    //****************************************************************

    /*****************************************************************
     * @post removes all map entries associated with this map
     */
    public void clear() {
        map.clear();
    }
    //****************************************************************
}
