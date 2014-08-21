package de.longor1996.util.io.streams;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StreamInput implements Input, AutoCloseable, Closeable
{
	InputStream ins;
	
	public StreamInput(InputStream in) throws IOException
	{
		ins = in;
	}
	
	public StreamInput(URL url) throws IOException {
		ins = url.openStream();
	}

	@Override
	public int readByte() throws IOException {
		return ins.read();
	}
	
	@Override
	public byte[] readBytesFully(int amount) throws IOException {
		byte[] b = new byte[amount];
		readFully(b, 0, amount);
		return b;
	}
	
	@Override
	public void readBytesFully(byte[] destination) throws IOException {
        readFully(destination, 0, destination.length);
	}
	
    public final void readFully(byte b[], int off, int len) throws IOException {
        if (len < 0)
            throw new IndexOutOfBoundsException();
        int n = 0;
        while (n < len) {
            int count = ins.read(b, off + n, len - n);
            if (count < 0)
                throw new EOFException();
            n += count;
        }
    }

	@Override
	public void close() throws IOException
	{
		ins.close();
	}
	
}
