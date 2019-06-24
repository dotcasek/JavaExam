import java.util.ArrayList;
import java.util.Collections;

public class QuestionLoader {

	private ArrayList<Question> list1 = new ArrayList<>();
	private ArrayList<Question> list2 = new ArrayList<>();
	private ArrayList<Question> list3 = new ArrayList<>();
	private ArrayList<Question> list4 = new ArrayList<>();

	public QuestionLoader() {
		loadAll();
	}


	public void loadAll() {
		Question q1 = new Question("Which of the following is not a primitive data type?",
				"Class", 0, "Integer", "Double", "Character");
		Question q2 = new Question("Which keyword is used to declare a constant in java?",
				"Final", 0, "Constant", "Const", "Input");
		Question q3 = new Question("Which operator is used for assignment?",
				"=", 0, "==", "===", "====");
		Question q4 = new Question("What is the result of dividing the integers 10 by 3?",
				"3", 0, "3.333", "0", "6");
		Question q5 = new Question("Which class allows for console input?",
				"Scanner", 0, "Keyboard", "Input", "Button");
		Question q6 = new Question("All statements must end in which statement terminator?",
				"Semicolon", 0, "Exclamation Point", "Period", "Comma");
		Question q7 = new Question("Which extention is used for a java source file?",
				".java", 0, ".class", ".exe", ".dat");
		Question q8 = new Question("What is process of finding and fixing errors in a program is called?",
				"Debugging", 0, "Rerunning", "Hacking", "Milking");
		Question q9 = new Question("What does \"Hello World\".length() return?",
				"11", 0, "2", "null", "13");
		Question q10 = new Question("What is the correct format specifier for a string?",
				"%s", 0, "(String)", "println", "s");
		Question q11 = new Question("What the escape sequence for a new line?",
				"\\n", 0, "new(line)", "Line.newLine.add().getNewLine(1)", "return");
		Question q12 = new Question("A string is a sequence of?",
				"Characters", 0, "Letters", "Numbers", "Files");
		Question q13 = new Question("A while statement is a type of?",
				"Loop", 0, "Object", "Constructor", "Operation");
		Question q14 = new Question("A do while loop is what kind of loop?",
				"Post-test", 0, "Pre-test", "Infinite", "Recursive");
		Question q15 = new Question("Which keyword can end a loop?",
				"Break", 0, "End", "Terminate", "Exit");
		Question q16 = new Question("Using methods in a program assists with?",
				"All of these", 0, "Modularization", "Reusability", "Ease of use");
		Question q17 = new Question("Array index begins with the value?",
				"0", 0, "1", "2", "3");
		Question q18 = new Question("Which is a type of sorting an an array?",
				"Selection", 0, "Order", "Inorder", "Ascending");
		Question q19 = new Question("You can only use binary search if an array is?",
				"Sorted", 0, "Defined", "Initialized", "Numerical");
		Question q20 = new Question("Arrays passed to methods in java are passed by?",
				"Reference", 0, "Value", "Final", "Canoe");
		Question q21 = new Question("How many bytes are in the Integer data type?",
				"4", 0, "2", "8", "1");
		Question q22 = new Question("In order to use package members you must use which statement?",
				"Import", 0, "Use", "Inherits", "Extend");
		Question q23 = new Question("How do you print text to the console?",
				"System.out.print()", 0, "cout", "PRINTTEXT", "print.text.toConsole()");
		Question q24 = new Question("Ide for java include?",
				"All of these", 0, "Eclipse", "Netbeans", "Idea");
		Question q25 = new Question("Spell 'Java'",
				"Java", 0, "Jaava", "Javva", "Javaa");
		
		Question q26 = new Question("Getter methods are also called?",
				"Accessor", 1, "Mutator", "Static", "Recursive");
		Question q27 = new Question("Setter methods are also called?",
				"Mutator", 1, "Accessor", "Static", "Recursive");
		Question q28 = new Question("Visibility modifiers include?",
				"All of these", 1, "Public", "Private", "Protected");
		Question q29 = new Question("A constructor with no arguments is called?",
				"Default", 1, "Empty", "Null", "Private");
		Question q30 = new Question("Regex is short for?",
				"Regular Expression", 1, "Reggie Xavier", "Red Xenophobe", "Regicadexpressigon");
		Question q31 = new Question("Modifiying a method defined in the superclass in a subclass is called?",
				"Overriding", 1, "Overloading", "Implementing", "Redefining");
		Question q32 = new Question("This practice refers to defining multiple methods with the same name\n"
				+ "but different signitures.", "Overloading", 1, "Overriding", "Defining", "Polymorphism");
		Question q33 = new Question("An object that cannot be changed is called?",
				"Immutable", 1, "Final", "Anonymous", "Interface");
		Question q34 = new Question("Every class extends the _____ class",
				"Object", 1, "Integer", "Rectangle", "Primitive");
		Question q35 = new Question("What type of error is division by zero?",
				"Runtime", 1, "Compiler", "None of these", "Both of these");
		Question q36 = new Question("A stack can be described as?",
				"First in last out", 1, "First in first out", "Last in last out", "All of these");
		Question q37 = new Question("You can prevent a class from extending and overriding by declaring them as?",
				"Final", 1, "Abstract", "Null", "Pointers");
		Question q38 = new Question("Runtime errors in java are known as?",
				"Exceptions", 1, "Handlers", "Blocks", "Recursion");
		Question q39 = new Question("You can declare an exception in a header by using this keyword",
				"Throws", 1, "Catch", "Try", "Debug");
		Question q40 = new Question("How are you able to get information about exceptions?",
				"printStackTrace", 1, "Invoking", "showError", "errorReport");
		Question q41 = new Question("Which Exception might you expect from accessing\n"
				+ " an array element which does not exist? ",
				"IndexOutOfBounds", 1, "InputMismatch", "IOException", "IllegalArgumentException");
		Question q42 = new Question("The Scanner can be used to read data from?",
				"All of these", 1, "Keyboard", "File", "URL");
		Question q43 = new Question("SAbstract classes can not be ?",
				"Instantiated", 1, "Extended", "Private", "Public");
		Question q44 = new Question("Interfaces only contain?",
				"Abstract methods", 1, "Objects", "Constructors", "Destructors");
		Question q45 = new Question("How many superclasses can a class extend?",
				"1", 1, "2", "10", "100");
		Question q46 = new Question("The window which displays a scene in javafx is called a?",
				"Stage", 1, "Pane", "Node", "Parent");
		Question q47 = new Question("Mouse clicks, button presses, and key presses are known as?",
				"Events", 1, "Sources", "Input", "Automation");
		Question q48 = new Question("Event handling can be simplified using?",
				"Lambda expressions", 1, "Abbreviations", "Interfaces", "ActionEvents");
		Question q49 = new Question("The timeline class is usefull for",
				"Animation", 1, "Handling events", "Paint", "Financial Applications");
		Question q50 = new Question("Label contents can be parsed with which method?",
				"getText()", 1, "parseText()", "getString()", "toString()");

	
		Question q51 = new Question("setWidth(400) 400 is measured in what unit?",
				"Pixels", 2, "Inches", "Baud", "Milimeters");
		Question q52 = new Question("Which will test if a radioButton is pressed?",
				"isSelected()", 2, "isPressed()", "isPushed()", "isActive()");
		Question q53 = new Question("Sliders use what event handler?",
				"Listener", 2, "MouseEvent", "SliderEvent", "All of these");
		Question q54 = new Question("ComboBox items are stored as a(n)?",
				"Observable list", 2, "Array", "File", "Stack");
		Question q55 = new Question("All Recursive calls must have (a)?",
				"Base case", 2, "Parameters", "Loop", "All of these");
		Question q56 = new Question("Which of the following are sorting Algorithms?",
				"All of these", 2, "Bubble", "Selection", "Insertion");
		Question q57 = new Question("Types of binary tree traversal include?",
				"All of these", 2, "Pre order", "Post order", "In order");
		Question q58 = new Question("What is the output of the Following?\n"
				+ "int i = 3 * 2 + 2 % 3;\n"
				+ "System.out.println(i);",
				"8", 2, "6", "7", "4");
		Question q59 = new Question("Given public double cost() What is double?",
				"Return type", 2, "Access specifier", "Argument", "Parameter");
		Question q60 = new Question("Sun Microsystems is now known as?",
				"Oracle", 2, "Solaris", "Apple", "Linux");
		Question q61 = new Question("Java ?",
				"0", 2, "1", "2", "3");
		Question q62 = new Question("What do the double slash (//) represent?",
				"Comments", 2, "Long division", "Errors", "Assignment");
		Question q63 = new Question("Which ways are there to implemet a GUI in Java?",
				"All of these", 2, "Javafx", "Swing", "AWT");
		Question q64 = new Question("In order to use databases you must first install the jdbc?",
				"Driver", 2, "Interface", "Firmware", "Operating system");
		Question q65 = new Question("Databases are organized into?",
				"Tables", 2, "Chairs", "Blocks", "All of these");
		Question q66 = new Question("Java uses ____ to repeat sql instructions?",
				"Prepared statements", 2, "Result set", "Metadata", "Xml");
		Question q67 = new Question("Applets use this instead of main?",
				"Init", 2, "Run", "Start", "Restart");
		Question q68 = new Question("Which datatypes can be stored in an arraylist?",
				"All of these", 2, "Objects", "Strings", "Double");
		Question q69 = new Question("Memory is allocated in java by using which keyword?",
				"New", 2, "Flush", "Malloc", "Instance");
		Question q70 = new Question("What will the following display?\n"
				+ "System.out.println(String.format(\"%.2d\", 10.101010))",
				"Will not compile", 2, "10.10", "10.101010", ".2");
		Question q71 = new Question("You can copy an array to another by using\n"
				+ "array1 = array2",
				"False", 2, "True", "", "");
		Question q72 = new Question("Java server pages allow you to run java code in?",
				"HTML", 2, "FXML", "JST", "BLT");
		Question q73 = new Question("HTML files must be run in a?",
				"Browser", 2, "Text editor", "Ide", "Terminal window");
		Question q74 = new Question("What is the output of the following?\n"
				+ "\"Java is fun\".matches(\"Java.*\")",
				"True", 2, "False", "Java", "Java is fun");
		Question q75 = new Question("Which file do you need to run in order to view an applet?",
				".class", 2, ".java", ".bin", ".exe");
		
		Question q76 = new Question("Running different tasks at the same time in a program is called?",
				"Multithreading", 3, "Modularization", "Animation", "Javafx");
		Question q77 = new Question("Using private variables and data hiding is sometimes called?",
				"Encapsulation", 3, "Inheritance", "Static", "Polymorphism");
		Question q78 = new Question("The result of a sql query is called",
				"Result set", 3, "Statement", "Return value", "All of these");
		Question q79 = new Question("Benefits of using an arrayList include?",
				"All of these", 3, "Sorting", "Shuffling", "Searching");
		Question q80 = new Question("Java applets implement what?",
				"Runnable", 3, "Serializable", "Handler", "Comparator");
		Question q81 = new Question("thread.sleep(5000) 5000 is what unit?",
				"Milisecond", 3, "Integer", "Seconds", "Double");
		Question q82 = new Question("A queue can be described as?",
				"First in first out", 3, "Last in first out", "first in last out", "None of these");
		Question q83 = new Question("ByteStreams use this method to write data?",
				"flush()", 3, "write()", "out()", "None of these");
		Question q84 = new Question("In order to write an object to a file it must be?",
				"Serialized", 3, "Initialized", "Concurrent", "Binary tree");
		Question q85 = new Question("Objects in a parent node are called?",
				"Children", 3, "Subsidies", "Modules", "None of these");
		Question q86 = new Question("Java can perform garbage collection by using which command?",
				"System.gc()", 3, "gc.collect()", "dumpAll()", "exit(0)");
		Question q87 = new Question("Which block of code generally follows a try block?",
				"Catch", 3, "Return", "For loop", "Recursion");
		Question q88 = new Question("Radio buttons are part of what"
				+ " which allows only one to be selected at a time?",
				"Togglegroup", 3, "RadioGroup", "Gathering", "None of these");
		Question q89 = new Question("Comparator can return values of?",
				"All of these", 3, "0", "1", "-1");
		Question q90 = new Question("In binary search after every iteration "
				+ "the range of the search is decreased by?",
				"Half", 3, "One", "Two", "Ten");
		Question q91 = new Question("Hex code for black is?",
				"#000000", 3, "#FFFFFF", "#00FF00", "#FF0000");
		Question q92 = new Question("Integer.toHexString(15) returns?",
				"f", 3, "15", "Does not compile", "0");
		Question q93 = new Question("What must you import in order to play media files such as mp3s?",
				"MediaPlayer", 3, "SoundPlayer", "mp3Player", "AudioPlayer");
		Question q94 = new Question("What is a java application which runs in a browser?",
				"Applet", 3, "Web site", "Java server page", "None of these");
		Question q95 = new Question("A __ uses TCP for data transmission ?",
				"Stream socket", 3, "Server", "outputStream", "none of these");
		Question q96 = new Question("A ___ uses UDP for data transmission?",
				"Datagram socket", 3, "Server", "outputStream", "None of these");
		Question q97 = new Question("<T> represents?",
				"Generic type", 3, "Template", "Tree", "All of these");
		Question q98 = new Question("setStyle() uses ___ to add style to your program?",
				"CSS", 3, "XML", "Color", "None of these");
		Question q99 = new Question("Try with resources automatically?",
				"Closes files", 3, "Catches Exception", "Throws Exception", "All of these");
		Question q100 = new Question("Random access files can read and write data from?",
				"Anywhere in the file", 3, "Only The beginning", "Only The end", "Only The middle");
		
		list1.add(q1);
		list1.add(q2);
		list1.add(q3);
		list1.add(q4);
		list1.add(q5);
		list1.add(q6);
		list1.add(q7);
		list1.add(q8);
		list1.add(q9);
		list1.add(q10);
		list1.add(q11);
		list1.add(q12);
		list1.add(q13);
		list1.add(q14);
		list1.add(q15);
		list1.add(q16);
		list1.add(q17);
		list1.add(q18);
		list1.add(q19);
		list1.add(q20);
		list1.add(q21);
		list1.add(q22);
		list1.add(q23);
		list1.add(q24);
		list1.add(q25);
		
		list2.add(q26);
		list2.add(q27);
		list2.add(q28);
		list2.add(q29);
		list2.add(q30);
		list2.add(q31);
		list2.add(q32);
		list2.add(q33);
		list2.add(q34);
		list2.add(q35);
		list2.add(q36);
		list2.add(q37);
		list2.add(q38);
		list2.add(q39);
		list2.add(q40);
		list2.add(q41);
		list2.add(q42);
		list2.add(q43);
		list2.add(q44);
		list2.add(q45);
		list2.add(q46);
		list2.add(q47);
		list2.add(q48);
		list2.add(q49);
		list2.add(q50);
		
		list3.add(q51);
		list3.add(q52);
		list3.add(q53);
		list3.add(q54);
		list3.add(q55);
		list3.add(q56);
		list3.add(q57);
		list3.add(q58);
		list3.add(q59);
		list3.add(q60);
		list3.add(q61);
		list3.add(q62);
		list3.add(q63);
		list3.add(q64);
		list3.add(q65);
		list3.add(q66);
		list3.add(q67);
		list3.add(q68);
		list3.add(q69);
		list3.add(q70);
		list3.add(q71);
		list3.add(q72);
		list3.add(q73);
		list3.add(q74);
		list3.add(q75);
		
		list4.add(q76);
		list4.add(q77);
		list4.add(q78);
		list4.add(q79);
		list4.add(q80);
		list4.add(q81);
		list4.add(q82);
		list4.add(q83);
		list4.add(q84);
		list4.add(q85);
		list4.add(q86);
		list4.add(q87);
		list4.add(q88);
		list4.add(q89);
		list4.add(q90);
		list4.add(q91);
		list4.add(q92);
		list4.add(q93);
		list4.add(q94);
		list4.add(q95);
		list4.add(q96);
		list4.add(q97);
		list4.add(q98);
		list4.add(q99);
		list4.add(q100);
		
		Collections.shuffle(list1);
		Collections.shuffle(list2);
		Collections.shuffle(list3);
		Collections.shuffle(list4);
	}

	public ArrayList<Question> pop(ArrayList<Question> l) {

		l.remove(0);
		return l;

	}

	public ArrayList<Question> select(int d) {

		ArrayList<Question> list = null;

		switch (d) {

		case 0:
			list = list1;
			break;
		case 1:
			list = list2;
			break;
		case 2:
			list = list3;
			break;
		case 3:
			list = list4;
			break;
		}

		return list;
	}
}
