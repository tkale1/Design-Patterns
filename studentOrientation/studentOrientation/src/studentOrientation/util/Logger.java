package studentOrientation.util;

public class Logger {

	public static enum DebugLevel {
		NONE, CONSTRUCTOR, VALUESET;
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.NONE;
			break;
		case 1:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 2:
			debugLevel = DebugLevel.VALUESET;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	// @return None
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}

// public class Logger {
//
// public static enum DebugLevel {
// NONE, PRINT_DATA, CONSTRUCTOR
// };
//
// private static DebugLevel debugLevel;
//
// /**
// * Sets debug value for debugging purpose.
// *
// * @param levelIn
// * value of the debug level
// */
// public static void setDebugValue(int levelIn) {
// switch (levelIn) {
// case 0:
// debugLevel = DebugLevel.NONE;
// break;
// case 1:
// debugLevel = DebugLevel.PRINT_DATA;
// break;
// case 2:
// debugLevel = DebugLevel.CONSTRUCTOR;
// break;
// }
// }
//
// /**
// * Sets debug value for debugging purpose.
// *
// * @param levelIn
// * value of the debug level
// */
// public static void setDebugValue(DebugLevel levelIn) {
// debugLevel = levelIn;
// }
//
// /**
// * Writes a message associated with the debug level value.
// *
// * @param message
// * message to be printed on console.
// * @param levelIn
// * debug level provided by user.
// */
// public static void writeMessage(String message, DebugLevel levelIn) {
// if (levelIn == debugLevel)
// System.out.println(message);
// }
//
// public String toString() {
// return "Debug Level is " + debugLevel;
// }
// }