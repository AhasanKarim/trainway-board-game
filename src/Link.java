import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

/* Class representing a link between cities
 */
public class Link implements Comparable<Link> {
  private City city1;
  private City city2;
  private int length;
  /* true if and only if this link is part of the set of shortest paths */
  public boolean used = false;
  public boolean isOneWay = false;


  /* Construct a Link between c1 and c2 with length len
   * The City alphanumerically smaller is stored as city1 and the other will be city2
   * add the link to both cities
   */
  public Link(City c1, City c2, int len) {
    if (c1.compareTo(c2) < 0) {
      city1 = c1;
      city2 = c2;
    }
    else {
      if (c1.compareTo(c2) < 0){
        city1 = c1;
        city2 =c2;


      }

      else{
        city1 = c2;
        city2 = c1;

      }
      c2.addLink(this);

    }
    length = len;
    c1.addLink(this);
  }

  /* return the length of this link */
  public int getLength() {
    return length;
  }

  /* get the opposite city from c
   * return city1 if c is city2
   * return city2 if c is city1
   * behaviour is unspecified if c is not city1 or city2
   */
  public City getAdj(City c) {

    if(isOneWay){
      return city2;
    }

     return c == city1 ? city2 : city1;
  }

  /* return true if this link is on a shortest path (i.e. used == true) and false otherwise */
  public boolean isUsed() {
    return used;
  }

  /* set used to u */
  public void setUsed(boolean u) {
    used = u;
  }

  /* return a string representation of the Link
   * e.g. "City1 3 City2"
   * The city names should be in sorted order, e.g. Halifax comes before Toronto
   */
  public String toString() {

    if(isOneWay){
      return city1.toString() + " " + length + " " + city2.toString() + " "+"one";

    }

    return city1.toString() + " " + length + " " + city2.toString();

  }

  /* compare this Link to Link l
   * returns 0 if both links have the same city1 and city2
   * return negative int if this.city1 < l.city1 or the city1 are equal and this.city2 < l.city2
   * else return a positive int
   */
  public int compareTo(Link l) {
    int diff = city1.compareTo(l.city1);
    if (diff == 0) {
      diff = city2.compareTo(l.city2);
    }
    return diff;
  }
}
