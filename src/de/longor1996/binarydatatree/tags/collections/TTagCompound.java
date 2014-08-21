package de.longor1996.binarydatatree.tags.collections;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagUtil;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.binarydatatree.tags.TEnd;
import de.longor1996.binarydatatree.tags.arrays.*;
import de.longor1996.binarydatatree.tags.primitives.*;
import de.longor1996.binarydatatree.tags.tuples.*;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TTagCompound extends Tag
{
	public AbstractMap<String, Tag> payload;
	
	public TTagCompound(String tagName)
	{
		super(tagName);
		payload = new HashMap<String, Tag>();
	}
	
	public TTagCompound(String tagName, boolean useTreeMap)
	{
		super(tagName);
		payload = useTreeMap ? new TreeMap<String, Tag>() : new HashMap<String, Tag>();
	}
	
	public void convertBackingMapToTreeMap()
	{
		if(payload instanceof TreeMap)
		{
			// Already is a TreeMap!
			return;
		}
		
		AbstractMap<String, Tag> n = new TreeMap<String, Tag>();
		n.putAll(payload);
		payload = n;
	}
	
	public void convertBackingMapToHashMap()
	{
		if(payload instanceof HashMap)
		{
			// Already is a HashMap!
			return;
		}
		
		AbstractMap<String, Tag> n = new HashMap<String, Tag>();
		n.putAll(payload);
		payload = n;
	}
	
	@Override
	public int getID() {
		return TagType.COMPOUND.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException
	{
		for(Map.Entry<String, Tag> entry : payload.entrySet())
		{
			Tag tag = entry.getValue();
			TagUtil.writeTag(tag, output);
		}
		
		TagUtil.writeEndTag(output);
	}
	
	@Override
	public void readPayload(Input input) throws IOException
	{
		while(true)
		{
			Tag tag = TagUtil.readTag(input);
			
			if(tag instanceof TEnd)
				break;
			
			payload.put(tag.getName(), tag);
		}
	}
	
	
	public final Map<String, Tag> getBackingMap()
	{
		return Collections.unmodifiableMap(payload);
	}
	
	
	
	
	
	public final Tag getTag(String name)
	{
		return payload.get(name);
	}
	
	public final Tag getTag(String name, Tag defaultValue)
	{
		return payload.getOrDefault(name, defaultValue);
	}
	
	public final void setTag(Tag tag)
	{
		payload.put(tag.getName(), tag);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public final void putBoolean(String name, boolean value)
	{
		setTag(new TBoolean(name, value));
	}
	
	public final void putByte(String name, byte value)
	{
		setTag(new TByte(name, value));
	}
	
	public final void putShort(String name, short value)
	{
		setTag(new TShort(name, value));
	}
	
	public final void putCharacter(String name, char value)
	{
		setTag(new TChar(name, value));
	}
	
	public final void putInteger(String name, int value)
	{
		setTag(new TInteger(name, value));
	}
	
	public final void putLong(String name, long value)
	{
		setTag(new TLong(name, value));
	}
	
	public final void putFloat(String name, float value)
	{
		setTag(new TFloat(name, value));
	}
	
	public final void putDouble(String name, double value)
	{
		setTag(new TDouble(name, value));
	}
	
	
	
	
	
	public final void putTuple3f(String name, float x, float y, float z)
	{
		setTag(new TTuple3f(name, x, y, z));
	}
	
	public final void putTuple3d(String name, double x, double y, double z)
	{
		setTag(new TTuple3d(name, x, y, z));
	}
	
	public final void putByteArray(String name, byte[] value)
	{
		setTag(new TByteArray(name, value));
	}
	
	public final void putIntArray(String name, int[] value)
	{
		setTag(new TIntArray(name, value));
	}
	
	public final void putFloatArray(String name, float[] value)
	{
		setTag(new TFloatArray(name, value));
	}
	
	
	
	
	
	
	public final TTagCompound getTagCompound(String name)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TTagCompound)
		{
			return ((TTagCompound) tag);
		}
		
		return null;
	}
	
	public final boolean getBoolean(String name, boolean dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TBoolean)
		{
			return ((TBoolean) tag).getPayload();
		}
		
		return dv;
	}
	
	public final byte getByte(String name, byte dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TByte)
		{
			return ((TByte) tag).getPayload();
		}
		
		return dv;
	}
	
	public final short getShort(String name, short dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TShort)
		{
			return ((TShort) tag).getPayload();
		}
		
		return dv;
	}
	
	public final char getCharacter(String name, char dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TChar)
		{
			return ((TChar) tag).getPayload();
		}
		
		return dv;
	}
	
	public final int getInteger(String name, int dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TInteger)
		{
			return ((TInteger) tag).getPayload();
		}
		
		return dv;
	}
	
	public final long getLong(String name, long dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TLong)
		{
			return ((TLong) tag).getPayload();
		}
		
		return dv;
	}
	
	public final float getFloat(String name, float dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TFloat)
		{
			return ((TFloat) tag).getPayload();
		}
		
		return dv;
	}
	
	public final double getDouble(String name, double dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TDouble)
		{
			return ((TDouble) tag).getPayload();
		}
		
		return dv;
	}
	
	
	
	
	public final byte[] getByteArray(String name, byte[] dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TByteArray)
		{
			return ((TByteArray) tag).getPayload();
		}
		
		return dv;
	}
	
	public final int[] getIntArray(String name, int[] dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TIntArray)
		{
			return ((TIntArray) tag).getPayload();
		}
		
		return dv;
	}
	
	public final float[] getFloatArray(String name, float[] dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TFloatArray)
		{
			return ((TFloatArray) tag).getPayload();
		}
		
		return dv;
	}
	
	public final TTuple3f getTuple3f(String name, TTuple3f dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TTuple3f)
		{
			return ((TTuple3f) tag);
		}
		
		return dv;
	}
	
	public final TTuple3d getTuple3d(String name, TTuple3d dv)
	{
		Tag tag = payload.get(name);
		
		if(tag instanceof TTuple3d)
		{
			return ((TTuple3d) tag);
		}
		
		return dv;
	}
	
}
