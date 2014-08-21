package de.longor1996.binarydatatree;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import de.longor1996.util.io.streams.FileInput;
import de.longor1996.util.io.streams.StreamInput;
import de.longor1996.util.io.streams.StreamOutput;

public class TagIOUtils
{
	
	public static final Tag read(String path) throws IOException
	{
		FileInput in = new FileInput(new File(path));
		Tag root = TagUtil.readTag(in);
		in.close();
		return root;
	}
	
	public static final Tag read(File file) throws IOException
	{
		FileInput in = new FileInput(file);
		Tag root = TagUtil.readTag(in);
		in.close();
		return root;
	}
	
	public static final Tag read(URL url) throws IOException
	{
		StreamInput in = new StreamInput(url);
		Tag root = TagUtil.readTag(in);
		in.close();
		return root;
	}
	
	public static final Tag read(InputStream input) throws IOException
	{
		StreamInput in = new StreamInput(input);
		Tag root = TagUtil.readTag(in);
		in.close();
		return root;
	}
	
	public static final void write(Tag rootTag, File file) throws IOException
	{
		StreamOutput out = new StreamOutput(file);
		TagUtil.writeTag(rootTag, out);
		out.close();
	}
	
	public static final void write(Tag rootTag, OutputStream output) throws IOException
	{
		StreamOutput out = new StreamOutput(output);
		TagUtil.writeTag(rootTag, out);
		out.close();
	}
	
}
