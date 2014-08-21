package de.longor1996.binarydatatree;

import java.io.IOException;

import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public abstract class Tag
{
	private final String tagName;
	
	public Tag(String tagName)
	{
		this.tagName = tagName;
	}
	
	public String getName()
	{
		return tagName;
	}
	
	public TagType getTagType()
	{
		return TagType.get(getID());
	}
	
	public abstract int getID();
	
	public abstract void writePayload(Output output) throws IOException;
	public abstract void readPayload(Input input) throws IOException;
	
}
