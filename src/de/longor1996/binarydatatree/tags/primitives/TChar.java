package de.longor1996.binarydatatree.tags.primitives;

import java.io.IOException;

import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TChar extends Tag
{
	public char payload;
	
	public TChar(String tagName)
	{
		super(tagName);
	}
	
	public TChar(String tagName, char value)
	{
		super(tagName);
		this.payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.CHAR.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeCharacter(payload);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		payload = input.readCharacter();
	}
	
	public char getPayload()
	{
		return payload;
	}
	
	public void setPayload(char value)
	{
		payload = value;
	}
	
}
