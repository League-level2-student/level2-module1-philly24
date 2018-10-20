package intro_to_array_lists;

import java.util.ArrayList;

public class IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> names = new ArrayList<String>();

		//2. Add five Strings to your list
		names.add("pizza");
		names.add("apple");
		names.add("bannana");
		names.add("grapes");
		names.add("ice cream");
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names);
		}
		//4. Print all the Strings using a for-each loop
		for (String string : names) {
			System.out.println(names);
		}
		//5. Print only the even numbered elements in the list.
		if (names.size()%2==0) {
			System.out.println(names);
		}
		//6. Print all the Strings in reverse order.
		for (int i = names.size() ; i <0 ; i--) {
			System.out.println("names");	
		}
		//7. Print only the Strings that have the letter 'e' in them.
		if (names.equals("e")) {
			System.out.println(names);
			//}
		}
	}

}
