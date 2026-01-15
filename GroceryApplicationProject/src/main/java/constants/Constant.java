package constants;

public class Constant {
	public static final String CONFIGFILE = System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA = System.getProperty("user.dir")+"\\src\\test\\resources\\TestDataGroceryApplication.xlsx";
	public static final String VALIDCREDENTIALERROR = "User was unable to login with valid credentials";
	public static final String INVALIDUSERNAMEERROR = "User was able to login even with invalid username";
	public static final String INVALIDPASSWORDERROR = "User was able to login even with invalid password";
	public static final String INVALIDCREDENTIALERROR = "User was able to login even with invalid username and password";
	public static final String LOGOUTFAILUREERROR = "User was unable to logout";
	public static final String NEWADMINUSERERROR = "User was unable to add a new Admin User";
	public static final String SEARCHADMINUSERERROR = "User was not able to search the user details";
	public static final String RESETPAGEERROR = "User was unable to reset the Amin Users page";
	public static final String ADDNEWSERROR = "User was unable to add news";
	public static final String SEARCHNEWSERROR = "User was not able to search the news";
}
