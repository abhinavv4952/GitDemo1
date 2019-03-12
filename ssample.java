import java.util.*;
public class Main
{
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    StringBuilder s=new StringBuilder();
    s=excel(n,s);
    System.out.println(s.reverse());
}
public static StringBuilder excel(int n,StringBuilder s){
    int rem=n%26;
    if(rem==0){
        s.append("Z");
        n=n/26-1;
    }
    else{
        s.append((char)(rem-1+'A'));
        n=n/26;
    }
    if(n!=0){
        excel(n,s);
    }
    return s;
}
}
