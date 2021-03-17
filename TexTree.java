import java.io.*;
class TexTree{
	public static void main(String[] args){
		String s;
		int tmp, count = 0;
		Stack stack = new Stack();
		SNode top = new SNode();
		
		top = stack.StackCreate();
		
		try{
			BufferedReader fin = new BufferedReader(new FileReader(args[0]));
			
			while((s = fin.readLine()) != null){
				tmp = s.indexOf("\\begin");
				if(tmp != -1){
					count++;
					stack.push(top, count);
					insertTab(count, 0);
					System.out.println(count + ": " + s.substring(tmp));
					insertTab(count + 1, 1);
				}
				
				tmp = s.indexOf("\\end");
				if(tmp != -1){
					insertTab(count, 0);
					System.out.println(stack.pop(top) + ": " + s.substring(tmp));
					insertTab(count, 1);
					count--;
				}
			}
			fin.close();
		}
		catch(Exception e){
			System.out.print(e);
		}
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