public class pair<K, V> {

    private K key;
    private V value;

    public pair(K key, V value) {
        this.key   = key;
        this.value = value;
    }


    public K getKey()            { return key; }
    public V getValue()          { return value; }
    public void setKey(K key)    { this.key = key; }
    public void setValue(V value){ this.value = value; }

    public pair<V, K> swap() {
        return new pair<>(value, key);
    }

    public static <K, V> pair<K, V> of(K key, V value) {
        return new pair<>(key, value);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pair<?, ?> other)) return false;
        return java.util.Objects.equals(key,   other.key)
            && java.util.Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(key, value);
    }

    public static void main(String[] args) {

        pair<String, Integer> p1 = new pair<>("Alice", 30);
        System.out.println("Pair p1:          " + p1);
        System.out.println("Key:              " + p1.getKey());
        System.out.println("Value:            " + p1.getValue());

        p1.setKey("Bob");
        p1.setValue(25);
        System.out.println("After mutation:   " + p1);

        pair<Double, Boolean> p2 = pair.of(3.14, true);
        System.out.println("Pair p2:          " + p2);

        pair<Boolean, Double> p2Swapped = p2.swap();
        System.out.println("p2 swapped:       " + p2Swapped);

        pair<pair<String, Integer>, Double> nested =
                pair.of(pair.of("Score", 99), 9.9);
        System.out.println("Nested pair:      " + nested);

        pair<String, Integer> a = pair.of("X", 1);
        pair<String, Integer> b = pair.of("X", 1);
        pair<String, Integer> c = pair.of("Y", 2);
        System.out.println("a.equals(b):      " + a.equals(b));
        System.out.println("a.equals(c):      " + a.equals(c));
        System.out.println("hashCode match:   " + (a.hashCode() == b.hashCode()));
    }
}