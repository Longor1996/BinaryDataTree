package de.longor1996.binarydatatree.tags.arrays;

import java.io.IOException;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TByteArray extends Tag
{
	public byte[] payload;
	
	public TByteArray(String tagName) {
		super(tagName);
	}
	
	public TByteArray(String tagName, byte[] value) {
		super(tagName);
		payload = value;
	}
	
	public TByteArray(String tagName, int arraySize) {
		super(tagName);
		payload = new byte[arraySize];
	}
	
	@Override
	public int getID() {
		return TagType.BYTEARRAY.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeInteger(payload.length);
		output.writeBytes(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		int length = input.readInteger();
		payload = input.readBytesFully(length);
	}
	
	public byte[] getPayload()
	{
		return payload;
	}
	
	public void setPayload(byte[] value)
	{
		payload = value;
	}
	
	public void setByte(int index, byte value)
	{
		payload[index] = value;
	}
	
	public byte getByte(int index)
	{
		return payload[index];
	}
	
}
