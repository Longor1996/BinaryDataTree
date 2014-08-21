package de.longor1996.binarydatatree.tags.arrays;

import java.io.IOException;
import java.util.BitSet;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TBoolArray extends Tag
{
	private BitSet payload;
	
	public TBoolArray(String tagName)
	{
		super(tagName);
		payload = new BitSet();
	}
	
	public TBoolArray(String tagName, BitSet value)
	{
		super(tagName);
		payload = value;
	}
	
	@Override
	public int getID() {
		return TagType.BOOLARRAY.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		byte[] bytes = payload.toByteArray();
		output.writeByte(bytes.length);
		output.writeBytes(bytes);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		int length = input.readByte();
		byte[] bytes = input.readBytesFully(length);
		payload = BitSet.valueOf(bytes);
	}
	
	public BitSet getBitSet()
	{
		return payload;
	}
	
}
