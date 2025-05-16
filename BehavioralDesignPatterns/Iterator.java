import java.util.ArrayList;
import java.util.List;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

class ConcreteIterator<T> implements Iterator<T> {
    private List<T> items;
    private int index = 0;

    public ConcreteIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return index < items.size();
    }

    @Override
    public T next() {
        return hasNext() ? items.get(index++) : null;
    }
}

interface Container<T> {
    Iterator<T> getIterator();
}

class ConcreteContainer<T> implements Container<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public Iterator<T> getIterator() {
        return new ConcreteIterator<>(items);
    }
}

public class Main {
    public static void main(String[] args) {
        ConcreteContainer<String> container = new ConcreteContainer<>();
        container.addItem("A");
        container.addItem("B");
        container.addItem("C");

        Iterator<String> iterator = container.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
