package cn.wagentim.buymanager.helper.contents;

import cn.wagentim.buymanager.utils.Constants;
import cn.wagentim.buymanager.utils.LanguageManager;
import cn.wagentim.buymanager.utils.StringConstants;

public class TemplateLineHandler implements IContentHandler
{
	@Override
	public String processLine(String lineContent)
	{
		StringBuffer sb = new StringBuffer(lineContent);
		
		replaceText(sb);
	
		return sb.toString();
	}
	
	private void replaceText(StringBuffer lineContent)
	{
		int beginIndex = lineContent.indexOf(Constants.LANG_TXT_PREFIX);
		
		if( beginIndex < 0 )
		{
			return;
		}
		else
		{
			int endIndex = lineContent.substring(beginIndex).indexOf(Constants.LANG_TXT_SUFFIX) + beginIndex;
			int replTxtBeginIndex = (beginIndex + Constants.LANG_TXT_PREFIX.length());
			if( endIndex <= replTxtBeginIndex )
			{
				lineContent.replace(beginIndex, endIndex, StringConstants.EMPTY_STRING);
			}
			else
			{
				
				String replTxtContent = lineContent.substring(replTxtBeginIndex, endIndex);
				lineContent.replace(beginIndex, endIndex, LanguageManager.instance.getReplaceText(replTxtContent));
			}
		}
		
	}

}
