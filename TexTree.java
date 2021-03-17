import java.io.*;
class TexTree{
	public static final int MAX_STORE = 20;
	public static NameAndVal[] nameTable = new NameAndVal[MAX_STORE];

	public static void main(String[] args){
		
		String s, new_s;
		int tmp, count = 0, tableNum;
		Stack stack = new Stack();
		SNode top = new SNode();
		
		top = stack.StackCreate();
		
		for(int i = 0; i < nameTable.length; i++){
			nameTable[i] = new NameAndVal();
		}
		
		
		try{
			BufferedReader fin = new BufferedReader(new FileReader(args[0]));
			
			while((s = fin.readLine()) != null){
				tmp = s.indexOf("\\begin");
				if(tmp != -1){
					/////////////////////////////////////////////////
					
					count++;
					stack.push(top, count);
					insertTab(count, 0);
					System.out.println(count + ": " + s.substring(tmp));
					insertTab(count + 1, 1);
					
					/////////////////////////////////////////////////
					
					new_s = cutOutChar(s);
					tableNum = checkTable(new_s);
					if(tableNum < 0){
						tableNum = registTable(new_s);
						nameTable[tableNum].val_begin++;
					}
					else{
						nameTable[tableNum].val_begin++;
					}
					///////////////////////////////////////////////////
				}
				
				tmp = s.indexOf("\\end");
				if(tmp != -1){
					/////////////////////////////////////////////////
					insertTab(count, 0);
					System.out.println(stack.pop(top) + ": " + s.substring(tmp));
					insertTab(count, 1);
					count--;
					
					/////////////////////////////////////////////////
					new_s = cutOutChar(s);
					tableNum = checkTable(new_s);
					if(tableNum < 0){
						tableNum = registTable(new_s);
						nameTable[tableNum].val_end++;

					}
					else{
						nameTable[tableNum].val_end++;
					}
					///////////////////////////////////////////////////
				}
			}
			fin.close();
			
			System.out.println("---------------------------------------------------------");
			System.out.printf("             \\begin  \\end\n");
			System.out.println("---------------------------------------------------------");
			for(int n = 0; n < nameTable.length; n++){
				if(!nameTable[n].name.equals("noname")){
					System.out.printf("%-12s:  %3d    %3d\n", nameTable[n].name, nameTable[n].val_begin, nameTable[n].val_end);
				}
			}
			System.out.println("---------------------------------------------------------");
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
	
	static String cutOutChar(String input_s){
		int a, b;
		String output_s;
		
		a = input_s.indexOf('{');
		b = input_s.indexOf('}');
		output_s = input_s.substring(a + 1, b);
		
//		System.out.println(output_s + "  This is name.");
		return output_s;
	}
	
	static int checkTable(String name){
		for(int n = 0; n < nameTable.length; n++){
			if(name.equals(nameTable[n].name)){
				return n;
			}
		}
		return -1;
	}
	
	static int registTable(String newName){
		for(int i = 0; i < nameTable.length; i++){
			if(nameTable[i].name.equals("noname")){
				nameTable[i].name = newName;
				return i;
			}
		}
		return -1;
	}
	
	
	static void insertTab(int count_tab, int count_newline){
		int n, m;
		for(n = 1; n < count_tab; n++){
			System.out.print("|\t");
		}
		for(m = 0; m < count_newline; m++){
			System.out.println();
		}
	}
}


class NameAndVal{
	String name = "noname";
	int val_begin;
	int val_end;
}

class SNode{
	int data;
	SNode next;
}

class Stack{
	void push(SNode header, int val){
		SNode node = new SNode();
		node.data = val;
		node.next = header.next;
		header.next = node;
	}
	
	int pop(SNode header){
		int val;
		if(header.next == null){
			System.out.print("STACK NO VALUE");
		}
		else{
			SNode tmp = header.next;
			val = tmp.data;
			header.next = tmp.next;
			return val;
		}
		return -1;
	}
	
	SNode StackCreate(){
		SNode first = new SNode();
		first.next = null;
		
		return first;
	}
}