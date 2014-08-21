package de.longor1996.binarydatatree;

import java.io.IOException;

import de.longor1996.binarydatatree.tags.*;
import de.longor1996.binarydatatree.tags.arrays.*;
import de.longor1996.binarydatatree.tags.collections.*;
import de.longor1996.binarydatatree.tags.objects.*;
import de.longor1996.binarydatatree.tags.primitives.*;
import de.longor1996.binarydatatree.tags.tuples.*;
import de.longor1996.util.io.streams.*;

public class TagUtil
{
	
	/**
	 * Creates a new Tag-instance of the given tag-type ID and the given name.
	 * 
	 * @param ID The tag-type ID.
	 * @param name The name for the tag.
	 * @throws UnknownTagException If there is no Tag-Type with the given ID.
	 **/
	public static final Tag newInstance(int ID, String name) throws UnknownTagException
	{
		switch(ID)
		{
		case 0: return new TEnd();
		case 1: return new TTagCompound(name);
		case 2: return new TTagList(name);
		
		// primitives
		case 0x09: return new TBoolean(name);
		case 0x0A: return new TByte(name);
		case 0x0B: return new TChar(name);
		case 0x0C: return new TShort(name);
		case 0x0D: return new TInteger(name);
		case 0x0E: return new TLong(name);
		case 0x0F: return new TFloat(name);
		case 0x10: return new TDouble(name);
		
		// objects
		case 0x11: return new TStringLEncode(name);
		case 0x12: return new TStringZeroTerminated(name);
		case 0x14: return new TUUID(name);
		
		// arrays
		case 0x15: return new TByteArray(name);
		case 0x16: return new TIntArray(name);
		case 0x17: return new TFloatArray(name);
		
		// tuples
		case 0x20: return new TTuple3f(name);
		case 0x21: return new TTuple3d(name);
		
			default: throw new UnknownTagException("Unknown Tag-Type ID.");
		}
	}
	
	public static final Tag readTag(Input input) throws IOException
	{
		int tagId = input.readByte();
		
		if(tagId == -1)
		{
			throw new IOException("Unexpected end of stream.");
		}
		
		if(tagId == TagType.END.as_int)
			return new TEnd();
		
		String tagName = input.readStringZeroTerminated();
		
		Tag tag = TagUtil.newInstance(tagId, tagName);
		tag.readPayload(input);
		return tag;
	}
	
	public static final void writeTag(Tag tag, Output output) throws IOException
	{
		int tid = tag.getID();
		output.writeByte(tid);
		
		if(tid == TagType.END.as_int)
			throw new IOException("A end-tag should be written to the ouput trough the 'writeEndTag' method.");
		
		output.writeStringZeroTerminated(tag.getName());
		tag.writePayload(output);
	}
	
	public static final void writeEndTag(Output output) throws IOException
	{
		int tid = TagType.END.as_int;
		output.writeByte(tid);
	}
	
}
