package registrationScheduler.util;

public abstract class ObjectPool {

	public static Integer assignedNo[] = { 0, 0, 0, 0, 0, 0, 0 };

	/**
	 * The borrowOIbject() is used to check of a
	 * subject is available to be assigned.
	 * @return the subject which is free to be allocated.
	 */
	public static Integer[] borrowObject() {
		return assignedNo;
	}

	/**
	 * the returnObject() is used to remove availibility of the object.
	 * @param courseIndex : specifies the course whos 
	 * availibility has been reduced.
	 */
	public static void returnObject(int courseIndex) {
		assignedNo[courseIndex]++;
	}

	public static int getNumActive(int courseIndex) {
		return 0;
	}

	public static int getNumIdle(int courseIndex) {
		return 0;
	}

}