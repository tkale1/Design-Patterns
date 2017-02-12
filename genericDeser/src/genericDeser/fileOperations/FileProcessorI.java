package genericDeser.fileOperations;

public interface FileProcessorI
{
	public String readFromFile();

	public void writeToFile();
	
	public void closeFile();
}
