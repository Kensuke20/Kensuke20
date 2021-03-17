import java.io.*;
class makeTexFile{
	public static void main(String[] args){
		try{
			printInitialize(args[0]);
		}
		catch(Exception e){
			if(args.length < 2){
				System.out.println("USAGE: java makeTexFile Output_filename Input_filename");
			}
		}
	}
	
	static void printInitialize(String filename){
		try{
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			
			fout.println("\\documentclass[a4j,11pt]{jarticle}");
			fout.println("\\usepackage[dvipdfm]{graphicx}");
			fout.println("\\usepackage[top=25truemm,bottom=30truemm,left=25truemm,right=25truemm]{geometry}\n");
			
			fout.println("\\begin{document}");
			fout.println("\\title{ }");
			fout.println("\\author{09430515\\Kensuke Ono}");
			fout.println("\\date{2020 \\month \\day}");
			fout.println("\\maketitle");
			fout.println("\n\n\n\n\n\n\n");
			
			fout.println("\\end{document}");
			
			fout.print("\n\n");
			fout.println("\\includegraphics[width=75mm]{B.jpg}");
			
			fout.close();
		}
		catch(Exception e){
			System.out.print(e);
			System.exit(1);
		}
	}
}
