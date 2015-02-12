package cn.wagentim.buymanager.checker;


public class Checker
{
	public static final boolean LoginUsrChecker(String[] loginInfo)
	{
		if( null == loginInfo || loginInfo.length != 2 )
		{
			return false;
		}
		
		String usr = loginInfo[0];
		String pwd = loginInfo[1];
		
		if( null == usr || null == pwd || usr.isEmpty() || pwd.isEmpty() )
		{
			return false;
		}
		
		return true;
	}
}
