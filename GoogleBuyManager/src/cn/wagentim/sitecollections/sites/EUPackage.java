package cn.wagentim.sitecollections.sites;

import java.net.URI;
import java.net.URISyntaxException;


public class EUPackage extends AbstractWebSite
{
	private static final String PATH_LOGIN = "/login.do";
	private static final String PATH_NEW_ORDER = "/createPackageCN.do";
	
    @Override
    public String getHost()
    {
        // TODO Auto-generated method stub
        return "www.eupackage.com";
    }

    @Override
    public String getScheme()
    {
        // TODO Auto-generated method stub
        return "http";
    }

    @Override
    public String getPath()
    {
        // TODO Auto-generated method stub
        return path;
    }

    @Override
    public String getUserName()
    {
        // TODO Auto-generated method stub
        return "yangzhiping_101@hotmail.com";
    }

    @Override
    public String getPassword()
    {
        // TODO Auto-generated method stub
        return "huang78";
    }

	@Override
	public URI getLoginURI() throws URISyntaxException
	{
		setPath(PATH_LOGIN);
		return getURI();
	}

	@Override
	public String getUserNameDefinition()
	{
		// TODO Auto-generated method stub
		return "email";
	}

	@Override
	public String getPasswordDefinition()
	{
		return "password";
	}

	public URI getCreateNewOrderURI() throws URISyntaxException
	{
		setPath(PATH_NEW_ORDER);
		return getURI();
	}
}
