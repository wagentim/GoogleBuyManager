package cn.wagentim.buymanager.utils;

public class HTMLHelper
{
    public static final String ErrorPage(String errorMessage)
    {
        return getBodyBefore().append(errorMessage).append(getBodyEnd()).toString();
    }

    private static final StringBuffer getBodyBefore()
    {
        return new StringBuffer().append("<html><header></header><body>");
    }

    private static final String getBodyEnd()
    {
        return "</body></html>";
    }

}
