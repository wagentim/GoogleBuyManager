package cn.wagentim.buymanager.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.gson.Gson;

public final class Utils
{
	private static final Gson json = new Gson();

	public static final String toJson(Object object)
	{
		if( null == object )
		{
			return StringConstants.EMPTY_STRING;
		}

		return json.toJson(object);
	}

	public static boolean isNullOrEmpty(final CharSequence s)
    {
        return s == null || s.length() == 0;
    }

	public static boolean isNullOrEmpty(final CharSequence[] s)
    {
	    boolean result = false;
	    for(int i = 0; i < s.length; i++)
	    {
	        result &= isNullOrEmpty(s[i]);
	    }
        return result;
    }

	public static String getMD5Encode(String userName, String password)
    {
	    StringBuffer sb = new StringBuffer();
	    sb.append(userName).append(";").append(password).append(";").append(System.currentTimeMillis());
	    return getMD5Encode(sb.toString());
    }

	public static String getMD5Encode(String input)
	{
	    try
        {
            byte[] bytesContent = input.getBytes("utf-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theDigest = md.digest(bytesContent);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < theDigest.length; i++)
            {
             sb.append(Integer.toString((theDigest[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();

        }
        catch ( UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        catch ( NoSuchAlgorithmException e )
        {
            e.printStackTrace();
        }

	    return StringConstants.EMPTY_STRING;
	}
}
