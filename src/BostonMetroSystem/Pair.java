package BostonMetroSystem;

/**
 * Implements the pairing needed between 2 classes to represent a neighbouring node and edge information
 */
public interface Pair<K, V> {

    /**
     * returns key data of this pair.
     * @return K
     */
    public K getKey();

    /**
     * returns value data of this pair.
     * @return V
     */
    public V getValue();
}
