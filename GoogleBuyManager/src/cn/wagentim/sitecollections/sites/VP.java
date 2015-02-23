package cn.wagentim.sitecollections.sites;

import java.net.URI;
import java.net.URISyntaxException;


public class VP extends AbstractWebSite
{
	public String getUserName()
	{
		return "wagentim@hotmail.com";
	}

	public String getPassword()
	{
		return "huang78";
	}

	@Override
	public String getHost()
	{
		return "secure.de.vente-privee.com/";
	}

	@Override
	public String getScheme()
	{
		return "https";
	}

	@Override
	public String getPath()
	{
		return "/authentication/portal/DE";
	}

	@Override
	public URI getLoginURI() throws URISyntaxException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserNameDefinition()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPasswordDefinition()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
