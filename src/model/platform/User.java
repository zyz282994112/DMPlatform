package model.platform;

import java.sql.Timestamp;

public class User {
	private Integer UserID;
	private String UserName;
	private String Profession;
	private String Company;
	private String CAddress;
	private String CPhone;
	private String CEmail;
	private String UserEmail;
	private String UserMSN;
	private String UserQQ;
	private String UserMobile;
	private String UserPhone;
	private String Password;
	private String ImagePath;
	private Integer logintag = 0;
	private Timestamp LastLoginTime;
	private Integer status;
	/**
	 * @return the userID
	 */
	public Integer getUserID() {
		return UserID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}
	/**
	 * @return the profession
	 */
	public String getProfession() {
		return Profession;
	}
	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		Profession = profession;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return Company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		Company = company;
	}
	/**
	 * @return the cAddress
	 */
	public String getCAddress() {
		return CAddress;
	}
	/**
	 * @param cAddress the cAddress to set
	 */
	public void setCAddress(String cAddress) {
		CAddress = cAddress;
	}
	/**
	 * @return the cPhone
	 */
	public String getCPhone() {
		return CPhone;
	}
	/**
	 * @param cPhone the cPhone to set
	 */
	public void setCPhone(String cPhone) {
		CPhone = cPhone;
	}
	/**
	 * @return the cEmail
	 */
	public String getCEmail() {
		return CEmail;
	}
	/**
	 * @param cEmail the cEmail to set
	 */
	public void setCEmail(String cEmail) {
		CEmail = cEmail;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return UserEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	/**
	 * @return the userMSN
	 */
	public String getUserMSN() {
		return UserMSN;
	}
	/**
	 * @param userMSN the userMSN to set
	 */
	public void setUserMSN(String userMSN) {
		UserMSN = userMSN;
	}
	/**
	 * @return the userQQ
	 */
	public String getUserQQ() {
		return UserQQ;
	}
	/**
	 * @param userQQ the userQQ to set
	 */
	public void setUserQQ(String userQQ) {
		UserQQ = userQQ;
	}
	/**
	 * @return the userMobile
	 */
	public String getUserMobile() {
		return UserMobile;
	}
	/**
	 * @param userMobile the userMobile to set
	 */
	public void setUserMobile(String userMobile) {
		UserMobile = userMobile;
	}
	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return UserPhone;
	}
	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return ImagePath;
	}
	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	
	public Integer getLogintag() {
		return logintag;
	}
	public void setLogintag(Integer logintag) {
		this.logintag = logintag;
	}
	public Timestamp getLastLoginTime() {
		return LastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		LastLoginTime = lastLoginTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
