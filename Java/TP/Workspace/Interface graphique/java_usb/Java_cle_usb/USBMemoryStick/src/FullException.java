// FullException.java

/**
 * Exception throwned when trying to add a file to a full storage device
 *
 * @author Sébastien Combéfis
 * @version 2009-03-12
 */
@SuppressWarnings ("serial")
public final class FullException extends RuntimeException
{
	/**
	 * Constructor
	 * 
	 * @pre -
	 * @post An instance of this is created
	 */
	public FullException (String msg)
	{
		super (msg);
	}
}