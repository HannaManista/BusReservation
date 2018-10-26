import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DBConnect {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	
	public DBConnect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BUS_DATA","root","Muzyka00");
			st = con.createStatement();
		}
		catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}


	public ArrayList<JourneyInfo> getByExpression(String expression) {
		try {
			rs = st.executeQuery(expression);
			ArrayList<JourneyInfo> journeyInfoList = new ArrayList<JourneyInfo>();
			while(rs.next()) {
				JourneyInfo journeyInfo = new JourneyInfo();
				journeyInfo.setCountry(rs.getString("country"));
				journeyInfo.setTo_city(rs.getString("to_city"));
				journeyInfo.setFrom_city(rs.getString("from_city"));
				journeyInfo.setDeparture_date(rs.getString("departure_date"));
				journeyInfo.setPrice(rs.getString("price"));
				journeyInfoList.add(journeyInfo);
			}
			return(journeyInfoList);
		}
		catch(Exception ex) {
			System.out.println("Error: "+ex);
			}
		return null;
		}
	
	public HashSet<String> getStringHashSetByExpression(String expression, String columnName){
		try {
			rs = st.executeQuery(expression);
			HashSet<String> comboHashSet = new HashSet<String>();
			while(rs.next())	{
				comboHashSet.add(rs.getString(columnName));
			}
			return comboHashSet;
		}
		catch(Exception ex){
			System.out.println("Error: "+ex);
		}
		return null;
	}
	
	}
	/*public void getData() {
		try {
			String query = "select * from mock_data where from_city like \"M%\" ";
			rs = st.executeQuery(query);
			System.out.println("Records from Database");
			while(rs.next()) {
				System.out.println(rs.getString("from_city"));
			}*/
			//journeyInfo = new JourneyInfo(country, from_city, to_city, departure_date, departure_time, price);
//			while(rs.next()) {
//			 //System.out.println("wewnatrz while");
//				String country = rs.getString("country");
//				String from_city = rs.getString("from_city");
//				ui.comboBoxFrom.addItem(rs.getString("from_city"));
//				String to_city = rs.getString("to_city");
//				ui.comboBoxTo.addItem(to_city);
//				String departure_date = rs.getString("departure_date");
//				String departure_time = rs.getString("departure_time");
//				String price = rs.getString("price");
//				//System.out.println("Country: "+journeyInfo.getCountry()+"  "+"from_city: "+journeyInfo.getFrom_city()+"	"+"to_city "+journeyInfo.getTo_city()+"	"+"departure date and time: "+journeyInfo.getDeparture_date()+" "+journeyInfo.getDeparture_time()+"	"+"price: "+journeyInfo.getPrice());
//				System.out.println("Country: "+country+"  "+"from_city: "+from_city+"	"+"to_city "+to_city+"	"+"departure date and time: "+departure_date+" "+departure_time+"	"+"price: "+price);
//			}
		/*}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
}
*/

/*
*
	journeyInfo.setCountry(rs.getString("country"));
	journeyInfo.setFrom_city(rs.getString("from_city"));
	ui.comboBoxFrom.addItem(journeyInfo.getFrom_city());
	journeyInfo.setTo_city(rs.getString("to_city"));
	ui.comboBoxFrom.addItem(journeyInfo.getTo_city());
	journeyInfo.setDeparture_date(rs.getString("departure_date"));
	journeyInfo.setDeparture_time(rs.getString("departure_time"));
	journeyInfo.setPrice(rs.getString("price"));	*/