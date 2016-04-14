import java.util.Comparator;

/**
 * Created by Magdalena Polak on 11.04.2016.
 */
public class Main {
    public static void main(String[] args) {

        Dictionary d = new Dictionary(100);

        Integer [] tab = {222,32,12,1111,0};
        InsertSort sc = new InsertSort();
        Book a = new Book("Pokuta", "Jackson");
        Book b = new Book("Arielka", "Disney");
        Book c = new Book("Harry", "Fredro");
        Book g = new Book("Zamek", "McAvoy");
        Book t = new Book("Potter", "Nowak");
        Book p = new Book("Atonishment", "Bem");
        Book o = new Book("Harry", "Kowalski");
        Book z = new Book("Harry", "Aowalski");
        Book zz = new Book("Harry", "Powalski");
        Book zzz = new Book("Harry", "Rowalski");
        d.add(a);
        d.add(b);
        d.add(c);
        d.add(g);
        d.add(t);
        d.add(p);
        d.add(o);
        d.add(z);
        d.add(zz);
        d.add(zzz);
      //  d.printtab();
       System.out.println("\nObiekt w liście: " + d.find(t)+ "\n");
       System.out.println("\nObiekt w liście: " + d.find(z)+"\n");
       d.printtabClear();
      /*  Object [] books = {a, b, c};
        books = sc.sort(books);
        for(Object o : books)
        {
            System.out.println(o);
        }*/



      //  d.printtab();
    }
}
