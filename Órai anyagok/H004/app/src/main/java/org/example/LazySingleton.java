package main.java.org.example;

public class LazySingleton {
    private static volatile LazySingleton instance;

    private LazySingleton(){
        System.out.println("Creating lazy_instance");
    } 

    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
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
