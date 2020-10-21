import static spark.Spark.*;

public class App {

        public static void main(String[] args) {
            port(getHerokuAssignedPort());
            get("/hello", (req, res) -> "Hello Heroku World");
        }

        static int getHerokuAssignedPort() {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (processBuilder.environment().get("PORT") != null) {
                return Integer.parseInt(processBuilder.environment().get("PORT"));
            }
            return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
        }

    }

