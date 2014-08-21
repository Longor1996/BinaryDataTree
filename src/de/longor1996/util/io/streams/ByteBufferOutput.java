package de.longor1996.util.io.streams;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferOutput implements Output
{
	private ByteBuffer buf;
	
	public ByteBufferOutput(int byteBufferSize)
	{
		buf = ByteBuffer.allocateDirect(byteBufferSize).order(ByteOrder.BIG_ENDIAN);
	}
	
	public ByteBufferOutput(ByteBuffer dest)
	{
		buf = dest;
	}
	
	@Override
	public void writeByte(int value) throws IOException
	{
		buf.put((byte) (value & 0xFF));
	}
	
	@Override
	public void writeBytes(byte[] value) throws IOException
	{
		buf.put(value);
	}

	@Override
	public void writeShort(short value) throws IOException {
		buf.putShort(value);
	}

	@Override
	public void writeCharacter(char value) throws IOException {
		buf.putChar(value);
	}

	@Override
	public void writeInteger(int value) throws IOException {
		buf.putInt(value);
	}

	@Override
	public void writeLong(long value) throws IOException {
		buf.putLong(value);
	}

	@Override
	public void writeFloat(float value) throws IOException {
		buf.putFloat(value);
	}

	@Override
	public void writeDouble(double value) throws IOException {
		buf.putDouble(value);
	}
	
}
