package backEndCourse.vacationTasks.homeTask.generics.task09;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Map<K, V> {
    private final Set<MapItem> items;

    public Map() {
        this.items = new HashSet<>();
    }

    public void put(K key, V value) {
        items.add(new MapItem(key, value));
    }

    public V get(K key) {
        for (MapItem item : items) {
            if (item.getKey().equals(key)) {
                return item.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        for (MapItem item : items) {
            if (item.getKey().equals(key)) {
                items.remove(item);
                break;
            }
        }
    }

    public int size() {
        return items.size();
    }

    public Set<MapItem> getAll() {
        return items;
    }

    public class MapItem {
        private final K key;
        private final V value;

        public MapItem(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            MapItem mapItem = (MapItem) o;
            return Objects.equals(key, mapItem.key);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }

        @Override
        public String toString() {
            return "MapItem: " + "key= " + key + ", value= " + value;
        }
    }
}
