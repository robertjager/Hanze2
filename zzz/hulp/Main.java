package nl.hanze.zzz.hulp;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args)
	{
		Postcode pc = new Postcode();
		ArrayList<Postcode>postcodes=(ArrayList<Postcode>)pc.readAll();
		System.out.println(postcodes.size());
	}
}
