package tourPackage;


import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.MySqlConnection;

public class TourModel {
	
	private String tourName;
	private String sourceName;
	private String destinationName;
	private String viaPoint1;
	private String viaPoint2;
	private String tourDate;
	private String travelAgent;	
	
	/**
	 * @param tourName
	 * @param sourceName
	 * @param destinationName
	 * @param viaPoint1
	 * @param viaPoint2
	 * @param tourDate
	 * @param travelAgent
	 */
	public TourModel(String tourName, String sourceName,
			String destinationName, String viaPoint1, String viaPoint2,
			String tourDate, String travelAgent) {
		super();
		this.tourName = tourName;
		this.sourceName = sourceName;
		this.destinationName = destinationName;
		this.viaPoint1 = viaPoint1;
		this.viaPoint2 = viaPoint2;
		this.tourDate = tourDate;
		this.travelAgent = travelAgent;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TourModel ["
				+ (tourName != null ? "tourName=" + tourName + ", " : "")
				+ (sourceName != null ? "sourceName=" + sourceName + ", " : "")
				+ (destinationName != null ? "destinationName="
						+ destinationName + ", " : "")
				+ ((viaPoint1 != null || viaPoint1!= "") ? "viaPoint1=" + viaPoint1 + ", " : "")
				+ ((viaPoint2 != null || viaPoint2!= "")?"viaPoint2=" + viaPoint2 + ", " : "")
				+ (tourDate != null ? "tourDate=" + tourDate + ", " : "")
				+ (travelAgent != null ? "travelAgent=" + travelAgent : "")
				+ "]";
	}




	public int saveInDatabase(){
		
		int result;
		
		Connection conn=null;
		PreparedStatement pst = null;
		
		try {
			
			conn = MySqlConnection.getConnection();
			pst = conn.prepareStatement("insert into tourdata (tourname,sourcename,destinationname,viapoint1,viapoint2,tourdate,travelagent) values (?,?,?,?,?,?,?)");
			
			pst.setString(1,tourName);
			pst.setString(2,sourceName);
			pst.setString(3,destinationName);
			pst.setString(4,viaPoint1);
			pst.setString(5,viaPoint2);
			pst.setString(6,tourDate);
			pst.setString(7,travelAgent);
			
			result = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			result = 0;
		}
		
		
		return result;
		
		
	}
	
	/**
	 * @return the tourName
	 */
	public String getTourName() {
		return tourName;
	}
	/**
	 * @param tourName the tourName to set
	 */
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	/**
	 * @return the sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}
	/**
	 * @param sourceName the sourceName to set
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	/**
	 * @return the destinationName
	 */
	public String getDestinationName() {
		return destinationName;
	}
	/**
	 * @param destinationName the destinationName to set
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	/**
	 * @return the viaPoint1
	 */
	public String getViaPoint1() {
		return viaPoint1;
	}
	/**
	 * @param viaPoint1 the viaPoint1 to set
	 */
	public void setViaPoint1(String viaPoint1) {
		this.viaPoint1 = viaPoint1;
	}
	/**
	 * @return the viaPoint2
	 */
	public String getViaPoint2() {
		return viaPoint2;
	}
	/**
	 * @param viaPoint2 the viaPoint2 to set
	 */
	public void setViaPoint2(String viaPoint2) {
		this.viaPoint2 = viaPoint2;
	}
	/**
	 * @return the tourDate
	 */
	public String getTourDate() {
		return tourDate;
	}
	/**
	 * @param tourDate the tourDate to set
	 */
	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}
	/**
	 * @return the travelAgent
	 */
	public String getTravelAgent() {
		return travelAgent;
	}
	/**
	 * @param travelAgent the travelAgent to set
	 */
	public void setTravelAgent(String travelAgent) {
		this.travelAgent = travelAgent;
	}
	
	
}
