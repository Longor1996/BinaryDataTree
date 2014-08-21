package de.longor1996.binarydatatree.tags.primitives;

import java.io.IOException;

import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TInteger extends Tag
{
	public int payload;
	
	public TInteger(String tagName)
	{
		super(tagName);
	}
	
	public TInteger(String tagName, int value)
	{
		super(tagName);
		this.payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.INTEGER.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeInteger(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		payload = input.readInteger();
	}
	
	public int getPayload()
	{
		return payload;
	}
	
	public void setPayload(int value)
	{
		payload = value;
	}
	
}
