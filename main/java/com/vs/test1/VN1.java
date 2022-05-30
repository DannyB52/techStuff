package com.vs.test1;

public class VN1 {

	public static void main (String [] args) {
	new VN1().test0();
	
}


private void test0() {
	for (int i = 0; i <= 100; i++) {

		if ((i % 3 == 0) && (i % 5 == 0)) System.out.println("Visual Nuts");
		else System.out.println(i);
		
		if (i % 3 == 0) System.out.println("Visual");
		else System.out.println(i);
		if (i % 5 == 0) System.out.println("Nuts");
		else System.out.println(i);
	}
	
}


public String write(int i) {
	if ((i % 3 == 0) && (i % 5 == 0)) return "Visual Nuts";
	if (i % 3 == 0) return "Visual";
	if (i % 5 == 0) return "Nuts";
	return   Integer.toString(i);

}


}