package de.longor1996.binarydatatree.tags.primitives;

import java.io.IOException;

import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TLong extends Tag
{
	public long payload;
	
	public TLong(String tagName)
	{
		super(tagName);
	}
	
	public TLong(String tagName, long value)
	{
		super(tagName);
		this.payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.LONG.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeLong(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		payload = input.readLong();
	}
	
	public long getPayload()
	{
		return payload;
	}
	
	public void setPayload(long value)
	{
		payload = value;
	}
	
}
