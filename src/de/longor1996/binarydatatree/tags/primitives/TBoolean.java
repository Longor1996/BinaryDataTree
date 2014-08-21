package de.longor1996.binarydatatree.tags.primitives;

import java.io.IOException;

import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TBoolean extends Tag
{
	public boolean payload;
	
	public TBoolean(String tagName)
	{
		super(tagName);
	}
	
	public TBoolean(String tagName, boolean value)
	{
		super(tagName);
		this.payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.BOOLEAN.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeByte(payload ? 1 : 0);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		payload = input.readByte() != 0;
	}
	
	public boolean getPayload()
	{
		return payload;
	}
	
	public void setPayload(boolean value)
	{
		payload = value;
	}
	
}
