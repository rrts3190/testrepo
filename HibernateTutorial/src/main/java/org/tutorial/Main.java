package org.tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ItemCollection implements Iterable<Item> {
    private List<Item> items;

    public ItemCollection() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator<Item> {
        private int currentIndex;

        public ItemIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < items.size();
        }

        @Override
        public Item next() {
            return items.get(currentIndex++);
        }

        @Override
        public void remove() {
            items.remove(currentIndex - 1);
        }
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ItemCollection collection = new ItemCollection();
        collection.addItem(new Item("Item 1"));
        collection.addItem(new Item("Item 2"));
        collection.addItem(new Item("Item 3"));

        Iterator<Item> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item.getName());
        }
    }
}