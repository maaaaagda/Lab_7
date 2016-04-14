import java.util.Collections;

/**
 * Created by Magdalena Polak on 11.04.2016.
 */
public class Dictionary {

        public int TAB_SIZE = 0;
        public int TEM_SIZE = 0;
        public int TEM_Length = 3;
        public Object [] tab = new Object[0];
        public Object [] tem = new Object [TEM_Length];
        InsertSort ls = new InsertSort();

        public Dictionary(int TAB_Length) {
            assert TAB_Length > 0 : "The size has to be greater than 0";
            tab = new Object[TAB_Length];
        }
        public void add(Object value){
            if(TEM_SIZE  !=  tem.length ) {
                for (int i = 0; i < tem.length; i++) {
                    if (tem[i] == null) {
                        tem[i] = value;
                        //   System.out.println(tab[i] + " " + value);
                        TEM_SIZE++;
                        break;
                    }
                }
            }
            else
            {

                tem = ls.sort(tem);
                //skracamy tablice
                int j =0;
               // System.out.println("temsize" + TEM_SIZE);
             //  printtab(tem);
                while(j != TEM_SIZE && tem[j] != null)
                {
                    j++;
                }
                TEM_SIZE = j;
              //  System.out.println("j" + j);
                Object [] tab3 = new Object[j];
                for(int a = 0;a <j; a++)
                {
                    tab3[a] = tem[a];
                }

               // printtabClear();
                tab = merge(tab, tab3);
             //   System.out.println("0" + tab[0]);
                TAB_SIZE = tab.length + tem.length;
                Object [] tem2 = new Object[TEM_Length];
                tem = tem2;
                TEM_SIZE = 0;
                for (int i = 0; i < tem.length; i++) {
                    if (tem[i] == null) {
                        tem[i] = value;
                        //   System.out.println(tab[i] + " " + value);
                        TEM_SIZE++;
                        break;
                    }
                }

            }


        }

        public Object find(Object value) {
            Object [] tab2 = new Object[0];
            if(TEM_SIZE != 0 )
            {
                 int i =0;
                 while(i != TEM_SIZE && tem[i] != null)
                {
                    i++;
                }
                Object [] tem3 = new Object[i];
                for(int a = 0;a <i; a++)
                {
                    tem3[a] = tem[a];
                }
                tem3 = ls.sort(tem3);
               // System.out.println("tymczasowa");
                tab2 =  merge(tab, tem3);
               // printtab(tab2);
                Object [] tem2 = new Object[TEM_Length];
                tem = tem2;
                TEM_SIZE = 0;
                TAB_SIZE = tem3.length + tab.length;
                tab = tab2;
            }
            int i =0;
            tab2 = tab;
            while(tab2[i] != null)
            {
                i++;
            }


            Object [] tab3 = new Object[i];
            for(int a = 0;a <i; a++)
            {
                tab3[a] = tab2[a];
            }

            int index =  binarySearch(tab3, value);
            return index;
        }
        public  Object[] merge2(Object[] a, Object[] b) {

        Object[] answer = new Object[a.length + b.length];
        int i = 0, j = 0, k = 0;
        if(TAB_SIZE == 0)
        {
          //  System.out.println("tsaa");
            for(int g = 0; g <tem.length; g++)
            {
                tab[g] = tem[g];
            }
            return tab;
        }
        while (i < TAB_SIZE && j < b.length)
        {
            System.out.println("i" + i);
            System.out.println("l" + TAB_SIZE+ " " + b.length);
//            System.out.println("comapre" + Book.compare(a[i], b[i]));
            if (Book.compare(a[i], b[i]) <=0)
            {
                answer[k] = a[i];
                System.out.println("answer" + answer[1]);
                i++;
            }
            else
            {
                answer[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < TAB_SIZE)
        {
            answer[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length)
        {
            answer[k] = b[j];
            j++;
            k++;
        }

        return answer;
    }
        public  Object[] mymerge2(Object[] a, Object[] b) {

        Object[] answer = new Object[a.length + b.length];
        System.out.println(TAB_SIZE+ " " + b.length);
        int i = 0, j = 0, k = 0;
        if(TAB_SIZE == 0)
        {
            System.out.println("tsaa");
            for(int g = 0; g <tem.length; g++)
            {
                tab[g] = tem[g];
            }
            return tab;
        }
        while (i < TAB_SIZE && j < b.length)
        {
//            System.out.println("comapre" + Book.compare(a[i], b[i]));
            if (Book.compare(a[i], b[i]) <=0)
            {
                answer[k] = a[i];
                answer[k+1] = b[i];
                //System.out.println("answer" + answer[1]);
                i++;
                j++;
            }
            else
            {
                System.out.println("cus");
                answer[k] = b[j];
                answer[k+1] = a[j];
                j++;
                i++;
            }
            k=+2;
        }

        while (i < TAB_SIZE)
        {
            System.out.println("hjdbfjs" + i);
            answer[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length)
        {
            System.out.println("Ihjdbfjs " + j);
           // answer[k] = a[i];
            answer[k] = b[j];
            j++;
            k++;
        }

        return answer;
    }
        public int binarySearch(Object[] inputArr, Object key) {

            int start = 0;
            int end = inputArr.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (key == inputArr[mid]) {
                    return mid;
                }
                if (Book.compare(key, inputArr[mid]) <= -1) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }
        private Object[] merge(Object[] left, Object[] right) {
        Object[] result = new Object[left.length + right.length];
        ArrayIterator l = new ArrayIterator(left);
        ArrayIterator r = new ArrayIterator(right);
        l.first();
        r.first();

       // System.out.println("tabsize" + TAB_SIZE);
        if(TAB_SIZE == 0)
        {
           // System.out.println("tsaa");
            for(int i = 0; i <tem.length; i++)
            {
                tab[i] = tem[i];
            }
            return tab;
        }
        else {


            while (!l.isDone() && !r.isDone() && l.current()!=null && l.current()!=null) {
                int a = Book.compare(l.current(), r.current());
             //   System.out.println("comparee: " + a);
                if (a <= 0) {

                    for (int i = 0; i < result.length; i++) {
                        if (result[i] == null) {
                            result[i] = l.current();
                            break;
                        }
                    }

                //    System.out.println("sfdfs" + l.current().toString());
                //    System.out.println("rrfdfs" + r.current().toString());
                    l.next();

                } else {
                //    System.out.println("domparee: " + a);
                    for (int i = 0; i < result.length; i++) {
                        if (result[i] == null) {
                            result[i] = r.current();
                            break;
                        }
                    }
                    r.next();

                }
            }
            while (!l.isDone()) {
                for (int i = 0; i < result.length; i++) {
                    if (result[i] == null) {
                        result[i] = l.current();
                        break;
                    }
                }
                l.next();
            }
            while (!r.isDone()) {
                for (int i = 0; i < result.length; i++) {
                    if (result[i] == null) {
                        result[i] = r.current();
                        break;
                    }
                }
                r.next();
            }
            return result;

        }
    }
        public int size()
        {
            return tab.length;
        }
        public void printtab(Object []tak){
            for (Object atab : tak) {
                System.out.println(atab);
            }
        }
        public void printtabClear(){
            for (Object atab : tab) {
                if(atab != null)
                    System.out.println(atab);
            }
        }
    }




