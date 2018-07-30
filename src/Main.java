import com.itso.imdb.client.Client;
import com.itso.imdb.server.IMDb_Server;

import java.io.*;


/**
 * Used to perform some tests
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

      Thread client = new Thread(new Client());
      client.start();
      client.join();
      Thread secondClient = new Thread(new Client());
      secondClient.start();
      secondClient.join();

    }
}
