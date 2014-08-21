package de.longor1996.binarydatatree.tags.primitives;

import java.io.IOException;

import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TShort extends Tag
{
	public short payload;
	
	public TShort(String tagName)
	{
		super(tagName);
	}
	
	public TShort(String tagName, short value)
	{
		super(tagName);
		this.payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.SHORT.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeShort(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		payload = input.readShort();
	}
	
	public short getPayload()
	{
		return payload;
	}
	
	public void setPayload(short value)
	{
		payload = value;
	}
	
}
