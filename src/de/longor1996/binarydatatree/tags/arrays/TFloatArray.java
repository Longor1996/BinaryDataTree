package de.longor1996.binarydatatree.tags.arrays;

import java.io.IOException;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TFloatArray extends Tag
{
	public float[] payload;
	
	public TFloatArray(String tagName) {
		super(tagName);
	}
	
	public TFloatArray(String tagName, float[] value) {
		super(tagName);
		payload = value;
	}
	
	public TFloatArray(String tagName, int arraySize) {
		super(tagName);
		payload = new float[arraySize];
	}
	
	@Override
	public int getID() {
		return TagType.FLOATARRAY.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeInteger(payload.length);
		output.writeFloats(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		int length = input.readInteger();
		payload = input.readFloatsFully(length);
	}
	
	public float[] getPayload()
	{
		return payload;
	}
	
	public void setPayload(float[] value)
	{
		payload = value;
	}
	
	public void setFloat(int index, float value)
	{
		payload[index] = value;
	}
	
	public float getFloat(int index)
	{
		return payload[index];
	}
	
}
