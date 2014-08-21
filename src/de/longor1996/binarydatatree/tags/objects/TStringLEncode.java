package de.longor1996.binarydatatree.tags.objects;

import java.io.IOException;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TStringLEncode extends Tag
{
	public String payload;
	
	public TStringLEncode(String tagName) {
		super(tagName);
	}
	
	public TStringLEncode(String tagName, String value) {
		super(tagName);
		payload = value;
	}

	@Override
	public int getID() {
		return TagType.STRING_LENCODE.as_int;
	}

	@Override
	public void writePayload(Output output) throws IOException {
		output.writeStringLengthEncoded(payload);
	}

	@Override
	public void readPayload(Input input) throws IOException {
		payload = input.readStringLengthEncoded();
	}
	
	public String getPayload()
	{
		return payload;
	}
	
	public void setPayload(String value)
	{
		payload = value;
	}
	
}
