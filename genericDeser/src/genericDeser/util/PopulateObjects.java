package genericDeser.util;


import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import genericDeser.fileOperations.FileProcessorI;
import genericDeser.util.Logger;

public class PopulateObjects
{

	public FileProcessorI fileptr = null;
	private Map<Object, Integer> firstMap = new HashMap<Object, Integer>();
	private Map<Object, Integer> secondMap = new HashMap<Object, Integer>();
	private ArrayList<Object> tempObj = new ArrayList<Object>();
	
	public PopulateObjects(FileProcessorI filenameIn)
	{
		fileptr = filenameIn;
		Logger.writeMessage ("In Constructor of PopulateObjects", Logger.DebugLevel.CONSTRUCTOR);
	}

	@SuppressWarnings("rawtypes")
	public void deserObjects() {
		Logger.writeMessage ("deserObjects() called", Logger.DebugLevel.FUNCTIONCALL);
		
		String line  = null;
		String[] temp = null;
		Class<?> className = null;
		String classNameTemp = null;
		String type = null;
		String var = null;
		String value = null;
		Object obj = null;
		Method method = null;

		while((line = fileptr.readFromFile()) != null)
		{
			String lineType = line.substring(0, 3);
		    String lineType1 = line.substring(0, 4);
		    
		    if(lineType.equalsIgnoreCase("fqn"))
		    {
		    	temp = line.split("\\:");
		    	classNameTemp = temp[1];
		    		    	
		    	try
		    	{
		    		className = Class.forName(classNameTemp);
		    	}
		    	catch (ClassNotFoundException e)
		    	{
		    		System.err.println(classNameTemp + "Class not found");
					e.printStackTrace();
					System.exit(-1);		    		
		    	}
		    	finally
		    	{
		    		
		    	}
		    	try
		    	{
					obj = className.newInstance();
					tempObj.add(obj);
				}
		    	catch (InstantiationException | IllegalAccessException e)
		    	{
					System.err.println("Cannot create instance of class:" + className);
					e.printStackTrace();
					System.exit(-1);
		    	}
		    	finally
		    	{
		    		
		    	}
		    }
		    else if(lineType1.equalsIgnoreCase("type"))
		    {
		    	temp = line.split(",");
				type = temp[0].replaceFirst("type=", "").trim();
				var = temp[1].replaceFirst("var=", "").trim();
				value = temp[2].replaceFirst("value=", "").trim();
				
				Object[] paramObjects = new Object[1];
			    Class[] signature = new Class[1];

			    if(type.equalsIgnoreCase("int"))
				{
					signature[0] = Integer.TYPE;
					paramObjects[0] = new Integer(value);
				}
				else if(type.equalsIgnoreCase("String"))
				{
					signature[0] = String.class;
					paramObjects[0] = new String(value);
				}
				else if(type.equalsIgnoreCase("double"))
				{
					signature[0] = Double.class;
					paramObjects[0] = new Double(value);
				}
				else if(type.equalsIgnoreCase("Short"))
				{
					signature[0] = Short.TYPE;
					paramObjects[0] = new Short(value);
				}
				else if(type.equalsIgnoreCase("Float"))
				{
					signature[0] = Float.TYPE;
					paramObjects[0] = new Float(value);
				}
				else if(type.equalsIgnoreCase("Boolean"))
				{
					signature[0] = Boolean.class;
					paramObjects[0] = new Boolean(value);
				}
			    
			    String methodName = "set" + var;
				try
				{
					method = className.getMethod(methodName, signature);
				}
				catch (NoSuchMethodException | SecurityException e)
				{
					System.err.println("No such method:" + methodName);
					e.printStackTrace();
					System.exit(-1);

				}
				finally
				{
					
				}
				
				try
				{
					Object result = method.invoke(obj, paramObjects);
				}
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
				{
					System.err.println("No access to method:" + methodName);
					e.printStackTrace();
					System.exit(-1);
				}
				finally
				{
					
				}
				
		    }//END of if for finding "type".
		}//End of while
		addToMap(tempObj);
	}//End of deserObjects()
	
	
	public void addToMap(ArrayList<Object> tempObjIn)
	{
		for(int i=0;i<tempObj.size();i++)
		{
			if(tempObj.get(i) instanceof First)
			{
				if(firstMap.containsKey(tempObj.get(i)))
				{
					int count = firstMap.get(tempObj.get(i));
					count++;
					firstMap.put(tempObj.get(i), count);
				}
				else
				{
					firstMap.put(tempObj.get(i), 1);
				}
			}
			else if(tempObj.get(i) instanceof Second)
			{
				if(secondMap.containsKey(tempObj.get(i)))
				{
					int count = secondMap.get(tempObj.get(i));
					count++;
					secondMap.put(tempObj.get(i), count);
				}
				else
				{
					secondMap.put(tempObj.get(i), 1);
				}
			}
		}
	}//End of putInMap

	
	public void getCount()
	{
		int uniqFirstCount = firstMap.size();;
		int uniqSecondCount = secondMap.size();;
		int totalFirst = 0;	
		int totalSecond = 0;
		int count = 0;
		for(Map.Entry<Object, Integer> entry: firstMap.entrySet())
		{
			count = entry.getValue();
			totalFirst += count; 
		}
		count =0;
		for(Map.Entry<Object, Integer> entry: secondMap.entrySet())
		{
			count = entry.getValue();
			totalSecond += count; 
		}
		Logger.writeMessage ("Number of unique First objects: "+uniqFirstCount, Logger.DebugLevel.OUTPUT);
		Logger.writeMessage ("Total Number of First objects: "+ totalFirst, Logger.DebugLevel.OUTPUT);
		Logger.writeMessage ("Number of unique Second objects: "+uniqSecondCount, Logger.DebugLevel.OUTPUT);
		Logger.writeMessage ("Total Number of Second objects: "+ totalSecond, Logger.DebugLevel.OUTPUT);
	}//END of getCount()
	
}