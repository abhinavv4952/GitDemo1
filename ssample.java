import java.sql.ResultSet;
import java.util.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<DBCol> al=new ArrayList<>();
		int i,j,k,l;
		ResultSet rs=stmt.executeQuery();//create a statement of select statement with stmt variable
		while(rs.next()){
			DBCol db=new DBCol();
			db.setAttr1(rs.getString(1));
			db.setAttr2(rs.getInt(1));
			db.setAttr3(rs.getString(1));
			al.add(db);
		}
		//print the arraylist
	}

}
