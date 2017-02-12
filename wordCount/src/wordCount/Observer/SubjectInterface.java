package wordCount.Observer;

/**
 * @author tanmaykale
 * Contains method to register, remove and notify the Obeservers.
 */
public interface SubjectInterface
{
	public void registerObserver(ObserverInterface obj);
	public void removeObserver(ObserverInterface obj);
	public void notifyObservers();

}
