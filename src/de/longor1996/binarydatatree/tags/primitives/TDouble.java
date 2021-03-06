package de.longor1996.binarydatatree.tags.primitives;

import java.io.IOException;

import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TDouble extends Tag
{
	public double payload;
	
	public TDouble(String tagName)
	{
		super(tagName);
	}
	
	public TDouble(String tagName, double value)
	{
		super(tagName);
		this.payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.DOUBLE.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeDouble(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		payload = input.readDouble();
	}
	
	public double getPayload()
	{
		return payload;
	}
	
	public void setPayload(double value)
	{
		payload = value;
	}
	
}
