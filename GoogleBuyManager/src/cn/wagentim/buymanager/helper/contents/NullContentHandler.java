package cn.wagentim.buymanager.helper.contents;

public class NullContentHandler implements IContentHandler
{

	@Override
	public String processLine(String lineContent)
	{
		return lineContent;
	}

}
