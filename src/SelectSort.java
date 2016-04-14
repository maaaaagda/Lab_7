/**
 * Created by Magdalena Polak on 13.04.2016.
 */
public class SelectSort
{
       public Object [] sort(Object [] objects) {
        int size = objects.length;
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check)
            {
                // System.out.println(_comparator.compare(objects[check], objects[smallest]));
                int t =(BookComparator.INSTANCE).compare(objects[check], objects[smallest]);
                if (t < 0)
                    smallest = check;
            }
            swap(objects, smallest, slot);
        }
        return objects;
    }
    private void swap(Object [] objects, int left, int right) {
        if (left != right) { // podejście optymisty
            Object temp = objects[left];
            objects[left]= objects[right];
            objects [right] = temp;
        }
    }
}