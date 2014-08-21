package de.longor1996.binarydatatree.tags.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.TagUtil;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TTagList extends Tag
{
	private ArrayList<Tag> payload;
	private int type;
	
	/**
	 * This constructor may only be used by the TagUtil class.
	 **/
	public TTagList(String tagName) {
		super(tagName);
		this.payload = new ArrayList<Tag>();
	}
	
	public TTagList(String tagName, TagType type) {
		super(tagName);
		this.payload = new ArrayList<Tag>();
		this.type = type.as_int;
	}
	
	@Override
	public int getID() {
		return TagType.TAGLIST.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException
	{
		output.writeByte(type);
		output.writeInteger(payload.size());
		
		Tag tag = null;
		for(int i = 0; i < payload.size(); i++)
		{
			tag = payload.get(i);
			
			if(tag.getID() != type)
			{
				throw new IOException("Tag "+i+" in the list '"+getName()+"' is not the correct type.");
			}
			
			tag.writePayload(output);
		}
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		type = input.readByte();
		
		int length = input.readInteger();
		for(int i = 0; i < length; i++)
		{
			Tag tag = TagUtil.newInstance(type, "");
			tag.readPayload(input);
			payload.add(tag);
		}
	}
	
	public void addTag(Tag tag)
	{
		if(tag.getID() != type)
		{
			throw new IllegalArgumentException("Given tag is not of equal type to the list-type.");
		}
		
		payload.add(tag);
	}
	
	public void setTag(int index, Tag tag)
	{
		if(tag.getID() != type)
		{
			throw new IllegalArgumentException("Given tag is not of equal type to the list-type.");
		}
		
		payload.set(index, tag);
	}
	
	public Tag getTag(int index)
	{
		return payload.get(index);
	}
	
	public List<Tag> getBackingList()
	{
		return Collections.unmodifiableList(payload);
	}
	
}
