package registrationScheduler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import registrationScheduler.store.Results;

/**
 * @author tanmaykale
 * The StoreDataClass class contains the main 
 * Registration Scheduler algorithm.
 * The class has a method storeData() 
 * which two arugments.
 * 1. String line which is obatined by from the file
 * one by one by the worker thread using the Filereader object.
 * 2. The object of the results class to use the methods 
 * of the Results class and its data members.
 */
public class StoreDataClass {

	public List<Integer> pref1;
	public List<Integer> pref2;
	public List<Integer> pref3;
	public List<Integer> pref4;
	public List<Integer> pref5;
	public List<Integer> pref6;
	public List<Integer> pref7;

	int preference[];
	String line;
	int i = 0;
	List<Integer> allocated;
	Results rs;
	/**
	 * The Constructor of the StoreDataClass class
	 * initializes all the necessary data structures.
	 */
	public StoreDataClass() {
		Logger.writeMessage("In Constructor of a storeDataClass", Logger.DebugLevel.CONSTRUCTOR);
		pref1 = new ArrayList<Integer>();
		pref2 = new ArrayList<Integer>();
		pref3 = new ArrayList<Integer>();
		pref4 = new ArrayList<Integer>();
		pref5 = new ArrayList<Integer>();
		pref6 = new ArrayList<Integer>();
		pref7 = new ArrayList<Integer>();
		preference = new int[7];
		allocated = new ArrayList<Integer>();
	}
	/**
	 * The storeData() is used to split the line read by the
	 * worker thread and store it in its individual data structure.
	 * After storing all the data members the methods runs the 
	 * algorithm used to allocate subjects to the file and 
	 * after allocation stores assigns the courses to the 
	 * respective student.
	 * @param LineIn
	*/
	public synchronized void storeData(String LineIn, Results rsIn) {
		rs=rsIn;
		line = LineIn;
		String split[] = line.split("\\s+");
		for (int k = 0; k < 7; k++)
			allocated.add(k, 0);
		rs.setName(split[0], i);
		pref1.add(Integer.parseInt(split[1])); // read and adding 'pref1'
		pref2.add(Integer.parseInt(split[2])); // read and adding 'pref2'
		pref3.add(Integer.parseInt(split[3])); // read and adding 'pref3'
		pref4.add(Integer.parseInt(split[4]));// read and adding 'pref4'
		pref5.add(Integer.parseInt(split[5]));// read and adding 'pref5'
		pref6.add(Integer.parseInt(split[6]));// read and adding 'pref6'
		pref7.add(Integer.parseInt(split[7]));// read and adding 'pref7'

		preference[0] = pref1.get(i);
		preference[1] = pref2.get(i);
		preference[2] = pref3.get(i);
		preference[3] = pref4.get(i);
		preference[4] = pref5.get(i);
		preference[5] = pref6.get(i);
		preference[6] = pref7.get(i);
		int flag = 0;
		int sum = 0;
		for (int a = 1; a <= 7; a++) {
			for (int b = 0; b < 7; b++) {
				if (preference[b] == a) {
					flag = 1;
				} else {
					flag = 0;
				}
				if (flag == 1 && sum < 5) {

					List<Integer> tempList = Arrays.asList(ObjectPool.borrowObject());
					int min = Collections.min(tempList);
					int index = tempList.indexOf(min);

					if (allocated.get(index) == 0) {
						rs.addsubject(sum, index, i, preference[index]);
						allocated.set(index, 1);
						ObjectPool.returnObject(index);
					} else {
						List<Integer> tempList1 = new ArrayList<Integer>();
						tempList1.addAll(tempList);
						for (int k = 0; k < 7; k++) {
							tempList1.set(index, 999);
							min = Collections.min(tempList1);
							index = tempList1.indexOf(min);
							if (allocated.get(index) == 0)
								break;
							else
								continue;
						}
						rs.addsubject(sum, index, i, preference[index]);
						allocated.set(index, 1);
						ObjectPool.returnObject(index);
					}
					sum += 1;
				} // end of IF with flag==1 and sum<5
			}
		}
		Logger.writeMessage(" Added a Record to the data structure", Logger.DebugLevel.ADDEDRESULT);

		//System.out.println(rs.toString(i));
		i++;
	}
}//End of StoreData class.