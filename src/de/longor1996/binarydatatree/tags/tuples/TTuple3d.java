package de.longor1996.binarydatatree.tags.tuples;

import java.io.IOException;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TTuple3d extends Tag
{
	public double x = 0,y = 0,z = 0;
	
	public TTuple3d(String tagName) {
		super(tagName);
	}
	
	public TTuple3d(String tagName, float x, float y, float z) {
		super(tagName);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public TTuple3d(String tagName, double x, double y, double z) {
		super(tagName);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public int getID() {
		return TagType.TUPLE3D.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeDouble(x);
		output.writeDouble(y);
		output.writeDouble(z);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		x = input.readDouble();
		y = input.readDouble();
		z = input.readDouble();
	}
	
	public float getXf()
	{
		return (float) x;
	}
	
	public float getYf()
	{
		return (float) y;
	}
	
	public float getZf()
	{
		return (float) z;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public double getZ()
	{
		return z;
	}
	
	public void setX(double val)
	{
		this.x = val;
	}
	
	public void setY(double val)
	{
		this.y = val;
	}
	
	public void setZ(double val)
	{
		this.z = val;
	}
	
	public void set(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void set(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
