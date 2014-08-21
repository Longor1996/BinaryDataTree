package de.longor1996.util.io.streams;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamOutput implements Output, Closeable, AutoCloseable
{
	OutputStream out;
	
	public StreamOutput(OutputStream out)
	{
		this.out = out;
	}
	
	public StreamOutput(File file) throws IOException
	{
		out = new FileOutputStream(file);
	}

	@Override
	public void writeByte(int value) throws IOException {
		out.write(value);
	}

	@Override
	public void close() throws IOException {
		out.close();
	}
	
}
