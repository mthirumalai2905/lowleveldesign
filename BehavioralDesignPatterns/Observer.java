import java.util.*;

// Subject (Observable)
interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers(String message);
}

// Concrete Subject
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
    
    public void setNews(String news) {
        notifyObservers(news);
    }
}

// Observer
interface Observer {
    void update(String message);
}

// Concrete Observer
class NewsChannel implements Observer {
    private String name;
    
    public NewsChannel(String name) {
        this.name = name;
    }
    
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        
        NewsChannel cnn = new NewsChannel("CNN");
        NewsChannel bbc = new NewsChannel("BBC");
        
        agency.attach(cnn);
        agency.attach(bbc);
        
        agency.setNews("Breaking News: Observer Pattern Implemented!");
    }
}
