lastouccurence(){
	String str="hello world string bye";
	int i,j,k,l;
	int flag=0;	
String[] s1=str.split(" ");
	for(i=s1.length-1;i>=0;i--){
		if(s1[i].equals("string")){
		flag=1;
		System.out.println("found");
		break;	
}

	}
	if(flag==0){
System.out.println("not found");}
}
}
