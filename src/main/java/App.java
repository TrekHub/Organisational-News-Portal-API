import  static  spark.Spark.*;

public class App {
    public  static  void main(String[] args){



        get("/", (request, response) -> {
            return "Hello Ted";
        });

    }
}