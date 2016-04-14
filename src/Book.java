/**
 * Created by Magdalena Polak on 11.04.2016.
 */
import java.util.Comparator;
public class Book {
String n;
    String p ;
    public Book(String n, String p)
    {
        this.n = n;
        this.p = p;
    }
    public int porN(Book s) { return n.compareTo(s.n);}
    public static int compare(Object o1, Object o2) {
        int porownaneNazwiska = ((Book)o1).n.compareTo(((Book)o2).n);

        if (porownaneNazwiska == 0) {
            return ((Book)o1).p.compareTo(((Book)o2).p);

        } else {
            return porownaneNazwiska;
        }
    }
    public static Comparator<Book> c = new Comparator<Book>() {
        @Override
        public int compare(Book left, Book right) throws ClassCastException {
            return left.n.compareTo(right.n);
        }
    };
    @Override
    public String toString() {
        return n + " " +p;
    }
}
