package de.longor1996.binarydatatree.tags.objects;

import java.io.IOException;
import java.util.UUID;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TUUID extends Tag
{
	public UUID payload;
	
	public TUUID(String tagName)
	{
		super(tagName);
	}

	@Override
	public int getID() {
		return TagType.UUID.as_int;
	}

	@Override
	public void writePayload(Output output) throws IOException
	{
		output.writeLong(payload.getLeastSignificantBits());
		output.writeLong(payload.getMostSignificantBits());
	}

	@Override
	public void readPayload(Input input) throws IOException
	{
		long least = input.readLong();
		long most = input.readLong();
		payload = new UUID(most, least);
	}
	
	public UUID getPayload()
	{
		return payload;
	}
	
	public void setPayload(UUID value)
	{
		payload = value;
	}
	
	public void setPayload(long most, long least)
	{
		payload = new UUID(most, least);
	}
	
}
