import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RouteCost {


  public static void main(String [] args) {
    Scanner inp = new Scanner(System.in);
    TreeSet<Link> links = new TreeSet<Link>();

    for (String name = inp.next(); !name.equals("done"); name = inp.next()) {
      City c1 = City.find(name);
      int length = inp.nextInt();
      City c2 = City.find(inp.next());
      Link l = new Link(c1, c2, length);
    }

    for (String name = inp.next(); !name.equals("done"); name = inp.next()) {
      City c = City.find(name);
      c.makeTree();
      if (!c.getLinksTo(City.find(inp.next()), links)) {
        System.out.println("Error: Route not found! " + name);
        return;
      }
    }

    int total = 0;
    System.out.println("The rail network consists of:");
    for (Link l : links) {
      System.out.println("  " + l);
      total += l.getLength();
    }
    System.out.println("The total cost is: " + total);
  }
}
