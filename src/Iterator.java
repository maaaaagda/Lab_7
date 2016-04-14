/**
 * Created by Magdalena Polak on 11.04.2016.
 */

public interface Iterator
{
    public void first();
    public void last();
    public void next();
    public boolean isDone();
    public void previous();
    public Object current() throws Exception;

}
