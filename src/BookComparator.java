

/**
 * Created by Magdalena Polak on 11.04.2016.
 */
public final class BookComparator implements Comparator {
    // wykorzystuje wzorzec singleton
    public static final BookComparator INSTANCE = new BookComparator();

    private BookComparator() { }

    public int compare(Object o1, Object o2) throws ClassCastException {
        int porownaneNazwiska = ((Book) o1).n.compareTo(((Book) o2).n);

        if (porownaneNazwiska == 0) {
            return ((Book) o1).p.compareTo(((Book) o2).p);

        } else {
            return porownaneNazwiska;
        }
    }
}