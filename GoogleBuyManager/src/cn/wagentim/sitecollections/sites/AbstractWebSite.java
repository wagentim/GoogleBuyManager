package cn.wagentim.sitecollections.sites;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

import cn.wagentim.buymanager.utils.StringConstants;

public abstract class AbstractWebSite implements IWebSite
{
    protected String path = StringConstants.EMPTY_STRING;

    @Override
    public URI getURI() throws URISyntaxException
    {
        URIBuilder builder = new URIBuilder();
        return builder.setScheme(getScheme()).setHost(getHost()).setPath(getPath()).build();
    }

    @Override
    public void setPath(String path)
    {
        this.path = path;
    }
}
