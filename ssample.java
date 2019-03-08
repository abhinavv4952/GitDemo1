import java.util.*;
class ssample
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number ");
		int n=sc.nextInt();
		Stack st=new Stack();
		while(n>0){
			int a=n%26;
			if(n<=26){
				st.push((char)(64+n));
				break;
			}
			if(a==0){
				st.push("Z");
				n=(n/26)-1;
				continue;
			}
			else if(a<26){
				st.push((char)(64+a));
			}
			n=n/26;
		}
		while (!st.isEmpty()){
    		System.out.print(st.pop());
		}
	}
}