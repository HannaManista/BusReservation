import java.util.ArrayList;
import java.util.List;

public class JourneyInfo {

	private String country;
	private String from_city;
	private String to_city;
	private String departure_date;
	private String price;
	
	private List<JourneyInfo> journeyInfoList = new ArrayList<JourneyInfo>();
	private JourneyInfo[] journeyInfoArray = new JourneyInfo[journeyInfoList.size()];
	
	public JourneyInfo[] getJourneyInfoArray() {
		return journeyInfoArray;
	}
	public void setJourneyInfoArray(JourneyInfo[] journeyInfoArray) {
		this.journeyInfoArray = journeyInfoArray;
	}
	public List<JourneyInfo> getJourneyInfoList() {
		return journeyInfoList;
	}
	public void setJourneyInfoList(List<JourneyInfo> journeyInfoList) {
		this.journeyInfoList = journeyInfoList;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getFrom_city() {
		return from_city;
	}
	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}
	public String getTo_city() {
		return to_city;
	}
	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	JourneyInfo(){}
	/*
	
	public JourneyInfo(String country, String from_city, String to_city, String departure_date, String departure_time, String price) {
		this.country = country;
		this.from_city = from_city;
		this.to_city = to_city;
		this.departure_date = departure_date;
		this.departure_time = departure_time;
		this.price = price;
		
	}
	*/
}
