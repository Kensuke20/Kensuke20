import java.io.*;

class RemoveComments{
	public static void main(String[] args){
		BufferedReader fin;
		PrintWriter fout;
		String input_s, output_s;
		int n;
		try{
			fin = new BufferedReader(new FileReader("tmp_" + args[0]));
			fout = new PrintWriter(new BufferedWriter(new FileWriter(args[0])));
			while((input_s = fin.readLine()) != null){
				n = input_s.indexOf("//");
				if(n >= 0){
					output_s = input_s.substring(0, n); 
				}
				else{
					output_s = input_s;
				}
				fout.println(output_s);
			}
			fin.close();
			fout.close();
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(1);
		}
	}
}
