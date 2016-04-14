/**
 * Created by Magdalena Polak on 11.04.2016.
 */
public class InsertSort {


    public Object [] sort(Object [] objects) {
        for (int i = 1; i < objects.length; ++i) {
            Object value = objects[i],temp;
            int j;
            for (j = i; j > 0 && (BookComparator.INSTANCE).compare(value, temp=objects[j - 1])< 0; --j)
                objects[j] = temp;
            objects[j] = value;
        }
        return objects;
    }
}

