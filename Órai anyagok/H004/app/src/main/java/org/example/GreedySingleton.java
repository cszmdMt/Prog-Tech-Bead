package main.java.org.example;

public class GreedySingleton {
    //Mohó singleton
    private static GreedySingleton instance = new GreedySingleton();

    private GreedySingleton(){
        System.out.println("Creating greedy instance");
    }

    public static GreedySingleton getInstance() {
        if (instance == null) {
            instance = new GreedySingleton();
        }

        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    public String getPassword() {
        return "12345678";
    }
}
