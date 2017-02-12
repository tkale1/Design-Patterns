package wordCount.visitors.DSProcessingVisitorI;

import java.io.IOException;

import wordCount.dsForStrings.BSTInterface;

/**
 * @author tanmaykale
 * Interface which contains visit method
 */
public interface Visitor
{
	public void visit(BSTInterface tree) throws IOException;
}