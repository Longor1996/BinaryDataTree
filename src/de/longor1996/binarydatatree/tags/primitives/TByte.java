package de.longor1996.binarydatatree.tags.primitives;

import java.io.IOException;

import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TByte extends Tag
{
	public byte payload;
	
	public TByte(String tagName)
	{
		super(tagName);
	}
	
	public TByte(String tagName, byte value)
	{
		super(tagName);
		this.payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.BYTE.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeByte(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		payload = (byte) (input.readByte() & 0xFF);
	}
	
	public byte getPayload()
	{
		return payload;
	}
	
	public void setPayload(byte value)
	{
		payload = value;
	}
	
}
