package cn.wagentim.sitecollections.sites;

import java.net.URI;
import java.net.URISyntaxException;

public interface IWebSite
{
	String getHost();

	String getScheme();

	String getPath();

	String getUserName();

	String getPassword();

	void setPath(String path);

    URI getURI() throws URISyntaxException;

	URI getLoginURI() throws URISyntaxException;

	String getUserNameDefinition();

	String getPasswordDefinition();
}
