package InputData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataTransform {
	public static void main(String[] args){
		BufferedReader in;
		try{
			if(args.length == 0)
				throw new IOException();
			//reading file
			in = new BufferedReader(new FileReader(args[0]));
			String line = "";			
			
			while((line = in.readLine()) != null){								
				System.out.println(line);			
			}
			
			in.close();
		}
		catch (IOException e) {
		System.out.println("Invalid argument or File not found");
	}
		
	}
}
