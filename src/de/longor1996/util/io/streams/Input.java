package de.longor1996.util.io.streams;

import java.io.EOFException;
import java.io.IOException;

public interface Input
{
	public int readByte() throws IOException;
	
	public default short readShort() throws IOException
	{
        int ch3 = readByte();
        int ch4 = readByte();
        
        if((ch3 | ch4) < 0)
            throw new EOFException();
        
        return (short) ((ch3 << 8) + (ch4 << 0));
	}
	
	public default char readCharacter() throws IOException
	{
        int ch3 = readByte();
        int ch4 = readByte();
        
        if((ch3 | ch4) < 0)
            throw new EOFException();
        
        return (char) (((ch3 << 8) + (ch4 << 0)) & 0xFFFF);
	}
	
	public default int readInteger() throws IOException
	{
        int ch1 = readByte();
        int ch2 = readByte();
        int ch3 = readByte();
        int ch4 = readByte();
        
        if ((ch1 | ch2 | ch3 | ch4) < 0)
            throw new EOFException();
        
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
	}
	
	public default long readLong() throws IOException
	{
		long left = readInteger();
		long right = readInteger();
		
		return (left << 32) | right;
	}
	
	public default float readFloat() throws IOException
	{
		return Float.intBitsToFloat(readInteger());
	}
	
	public default double readDouble() throws IOException
	{
		return Double.longBitsToDouble(readLong());
	}
	
	public default String readStringZeroTerminated() throws IOException
	{
		int b = 0;
		StringBuilder builder = new StringBuilder();
		
		while(true)
		{
			b = readByte();
			
			
			// End of stream!
			if(b == -1)
				return null;
			
			// End of string!
			if(b == 0)
				return builder.toString();
			
			builder.append((char)b);
		}
	}
	
	public default String readStringLengthEncoded() throws IOException
	{
		int length = readShort();
		StringBuilder builder = new StringBuilder(length);
		
		for(int i = 0; i < length; i++)
		{
			builder.append(readCharacter());
		}
		
		return builder.toString();
	}
	
	public byte[] readBytesFully(int amount) throws IOException;
	public void readBytesFully(byte[] destination) throws IOException;
	
	
	
	public default int[] readIntegersFully(int amount) throws IOException
	{
		int[] out = new int[amount];
		for(int i = 0; i < amount; i++)
		{
			out[i] = readInteger();
		}
		return out;
	}
	
	public default int[] readIntegersFully(int[] destination) throws IOException
	{
		int amount = destination.length;
		for(int i = 0; i < amount; i++)
		{
			destination[i] = readInteger();
		}
		return destination;
	}
	
	
	
	public default float[] readFloatsFully(int amount) throws IOException
	{
		float[] out = new float[amount];
		for(int i = 0; i < amount; i++)
		{
			out[i] = readFloat();
		}
		return out;
	}
	
	public default float[] readFloatsFully(float[] destination) throws IOException
	{
		int amount = destination.length;
		for(int i = 0; i < amount; i++)
		{
			destination[i] = readFloat();
		}
		return destination;
	}
	
}
