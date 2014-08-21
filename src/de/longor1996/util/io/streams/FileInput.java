package de.longor1996.util.io.streams;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInput implements Input, AutoCloseable, Closeable
{
	FileInputStream ins;
	
	public FileInput(File file) throws IOException
	{
		ins = new FileInputStream(file);
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
