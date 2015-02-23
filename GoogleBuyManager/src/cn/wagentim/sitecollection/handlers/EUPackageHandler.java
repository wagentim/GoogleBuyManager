package cn.wagentim.sitecollection.handlers;

import java.net.URISyntaxException;

import org.apache.http.impl.client.BasicCookieStore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.wagentim.connecthelper.connector.GetPageContent;
import cn.wagentim.connecthelper.connector.PostAuthentication;
import cn.wagentim.sitecollection.handlers.basic.AbstractSiteHandler;
import cn.wagentim.sitecollections.sites.EUPackage;
import cn.wagentim.sitecollections.sites.IWebSite;

public class EUPackageHandler extends AbstractSiteHandler
{
    private IWebSite site = new EUPackage();
    private BasicCookieStore cookieStore = null;

    public void run()
    {
    	PostAuthentication login = new PostAuthentication(site);
    	login.run();
    	cookieStore = login.getCookieStore();
    	GetPageContent page;
    	try
		{
			page = new GetPageContent(((EUPackage)site).getCreateNewOrderURI());
		} catch (URISyntaxException e)
		{
			page = null;
		}
    	
    	if( page != null )
    	{
    		page.setCookieStore(cookieStore);
    		page.run();
    		Document html = Jsoup.parse(page.getPageContent());
    		Elements scripts = html.getElementsByTag("script");
    		for(Element e : scripts)
    		{
    			for (DataNode node : e.dataNodes()) 
    			{
    	            System.out.println(node.getWholeData());
    	        }
    		}
    	}
    }

    public static void main(String[] args)
    {
        EUPackageHandler handler = new EUPackageHandler();
        handler.run();

    }
}
