package cn.wagentim.buymanager.utils;

public final class Validator
{
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
}
