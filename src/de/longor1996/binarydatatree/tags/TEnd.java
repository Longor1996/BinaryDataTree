package de.longor1996.binarydatatree.tags;

import java.io.IOException;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TEnd extends Tag
{
	
	public TEnd()
	{
		super("");
	}
	
	@Override
	public int getID()
	{
		return TagType.END.as_int; // This will ALWAYS be zero!
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		// don't do anything at all!
	}

	@Override
	public void readPayload(Input input) throws IOException {
		// don't do anything at all!
	}
	
}
