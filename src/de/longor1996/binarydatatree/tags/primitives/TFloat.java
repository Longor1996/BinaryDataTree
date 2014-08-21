package de.longor1996.binarydatatree.tags.primitives;

import java.io.IOException;

import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TFloat extends Tag
{
	public float payload;
	
	public TFloat(String tagName)
	{
		super(tagName);
	}
	
	public TFloat(String tagName, float value)
	{
		super(tagName);
		this.payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.FLOAT.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeFloat(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		payload = input.readFloat();
	}
	
	public float getPayload()
	{
		return payload;
	}
	
	public void setPayload(float value)
	{
		payload = value;
	}
	
}
