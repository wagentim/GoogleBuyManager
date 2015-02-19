package cn.wagentim.buymanager.utils;

public interface Constants
{
    public static final int ERROR_INT = -1;
    public static final Long ERROR_LONG = -1L;
    /** the Authentication will last one day */
    public static final Long AUTH_TIME_OUT = Long.valueOf(1000 * 60 * 60 * 24);
	
    // --------------- Template File Constants ---------------
    
    public static final String TEMPLAGE_SUFFIX = "tmp";
    public static final String TEMPLATE_LOCATION = "/templates/";
    
    // --------------- Language Constants ---------------
    
    public static final String LANG_TXT_PREFIX = "lang(";
    public static final String LANG_TXT_SUFFIX = ")";
    public static final String LANG_FILE_CHINESE = "i18n/chinese.lang";
    public static final String LANG_FILE_ENGLISH = "i18n/english.lang";
    
    // --------------- HTML Constants ---------------
    
    public static final String CONTENT_TYPE_HTML = "text/html";
    public static final String CONTENT_CHAR_SET_UTF8 = "utf-8";
}
