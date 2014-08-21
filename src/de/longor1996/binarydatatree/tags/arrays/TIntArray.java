package de.longor1996.binarydatatree.tags.arrays;

import java.io.IOException;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TIntArray extends Tag
{
	public int[] payload;
	
	public TIntArray(String tagName) {
		super(tagName);
	}
	
	public TIntArray(String tagName, int[] value) {
		super(tagName);
		payload = value;
	}
	
	public TIntArray(String tagName, int arraySize) {
		super(tagName);
		payload = new int[arraySize];
	}
	
	@Override
	public int getID() {
		return TagType.INTARRAY.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeInteger(payload.length);
		output.writeIntegers(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		int length = input.readInteger();
		payload = input.readIntegersFully(length);
	}
	
	public int[] getPayload()
	{
		return payload;
	}
	
	public void setPayload(int[] value)
	{
		payload = value;
	}
	
	public void setInteger(int index, int value)
	{
		payload[index] = value;
	}
	
	public int getInteger(int index)
	{
		return payload[index];
	}
	
}
