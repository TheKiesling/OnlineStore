/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public interface IMap<K, V>{

    //---------------------------MÉTODOS------------------------------
    /*****************************************************************
     * @post returns the number of entries in the map
     */
    public int size();
    //****************************************************************

    /*****************************************************************
     * @post returns true iff this map does not contain any entries
     */
    public boolean isEmpty();
    //****************************************************************

    /*****************************************************************
     * @pre k is non-null
     * @post returns true iff k is in the domain of the map
     */
    public boolean containsKey(K k);
    //****************************************************************

    /*****************************************************************
     * @pre v is non-null
     * @post returns true iff v is the target of at least one map entry;
     * that is, v is in the range of the map
     */
    public boolean containsValue(V v);
    //****************************************************************

    /*****************************************************************
     * @pre k is a key, possibly in the map
     * @post returns the value mapped to from k, or null
     */
    public V get(K k);
    //****************************************************************

    /*****************************************************************
     * @pre k and v are non-null
     * @post inserts a mapping from k to v in the map
     */
    public V put(K k, V v);
    //****************************************************************
    
    /*****************************************************************
     * @pre k is non-null
     * @post removes any mapping from k to a value, from the mapping
     */
    public V remove(K k);
    //****************************************************************

    /*****************************************************************
     * @pre other is non-null
     * @post all the mappings of other are installed in this map,
     * overriding any conflicting maps
     */
    public void putAll(IMap<K,V> other);
    //****************************************************************

    /*****************************************************************
     * @post removes all map entries associated with this map
     */
    public void clear();
    //****************************************************************
}