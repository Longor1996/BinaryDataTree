package de.longor1996.util.io.streams;

import java.io.IOException;

public interface Output
{
	public void writeByte(int value) throws IOException;
	
	public default void writeShort(short value) throws IOException
	{
		writeByte((value >> 8) & 0xFF);
		writeByte((value) & 0xFF);
	}
	
	public default void writeCharacter(char value) throws IOException
	{
		writeByte((value >> 8) & 0xFF);
		writeByte((value) & 0xFF);
	}
	
	public default void writeInteger(int value) throws IOException
	{
		writeByte((value >> 24) & 0xFF);
		writeByte((value >> 16) & 0xFF);
		writeByte((value >> 8) & 0xFF);
		writeByte((value) & 0xFF);
	}
	
	public default void writeLong(long value) throws IOException
	{
		writeByte((int) ((value >> 56) & 0xFF));
		writeByte((int) ((value >> 48) & 0xFF));
		writeByte((int) ((value >> 40) & 0xFF));
		writeByte((int) ((value >> 32) & 0xFF));
		writeByte((int) ((value >> 24) & 0xFF));
		writeByte((int) ((value >> 16) & 0xFF));
		writeByte((int) ((value >> 8) & 0xFF));
		writeByte((int) ((value) & 0xFF));
	}
	
	public default void writeFloat(float value) throws IOException
	{
		writeInteger(Float.floatToRawIntBits(value));
	}
	
	public default void writeDouble(double value) throws IOException
	{
		writeLong(Double.doubleToRawLongBits(value));
	}
	
	/** Writes a zero-terminated ASCII string. **/
	public default void writeStringZeroTerminated(String value) throws IOException
	{
		int l = value.length();
		int c = ' ';
		
		for(int i = 0; i < l; i++)
		{
			c = value.charAt(i);
			writeByte(c);
		}
		
		writeByte(0);
	}
	
	public default void writeStringLengthEncoded(String value) throws IOException
	{
		int l = value.length();
		
		if(l > Short.MAX_VALUE-1)
		{
			throw new IllegalArgumentException("The given string is too big: " + l);
		}
		
		writeShort((short) l);
		char c = ' ';
		
		for(int i = 0; i < l; i++)
		{
			c = value.charAt(i);
			writeCharacter(c);
		}
	}
	
	public default void writeBytes(byte[] value) throws IOException
	{
		int l = value.length;
		for(int i = 0; i < l; i++)
			writeByte(value[i]);
	}
	
	public default void writeIntegers(int[] value) throws IOException
	{
		int l = value.length;
		for(int i = 0; i < l; i++)
			writeInteger(value[i]);
	}
	
	public default void writeFloats(float[] value) throws IOException
	{
		int l = value.length;
		for(int i = 0; i < l; i++)
			writeFloat(value[i]);
	}
}
