package course4.week1.filterdata;

/**
 * Write a description of interface Filter here.
 * 
 * @author Bryn Lloyd 
 * @version 1
 */
public interface Filter
{
    public  boolean satisfies(QuakeEntry qe);
    public String getName();
}
