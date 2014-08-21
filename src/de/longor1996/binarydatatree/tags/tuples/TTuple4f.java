package de.longor1996.binarydatatree.tags.tuples;

import java.io.IOException;

import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.TagType;
import de.longor1996.util.io.streams.Input;
import de.longor1996.util.io.streams.Output;

public class TTuple4f extends Tag
{
	public float x = 0,y = 0,z = 0,w = 1;
	
	public TTuple4f(String tagName) {
		super(tagName);
	}
	
	public TTuple4f(String tagName, float x, float y, float z, float w) {
		super(tagName);
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public TTuple4f(String tagName, double x, double y, double z, double w) {
		super(tagName);
		this.x = (float) x;
		this.y = (float) y;
		this.z = (float) z;
		this.w = (float) w;
	}
	
	@Override
	public int getID() {
		return TagType.TUPLE3F.as_int;
	}
	
	@Override
	public void writePayload(Output output) throws IOException {
		output.writeFloat(x);
		output.writeFloat(y);
		output.writeFloat(z);
		output.writeFloat(w);
	}
	
	@Override
	public void readPayload(Input input) throws IOException {
		x = input.readFloat();
		y = input.readFloat();
		z = input.readFloat();
		w = input.readFloat();
	}
	
	public double getXd()
	{
		return x;
	}
	
	public double getYd()
	{
		return y;
	}
	
	public double getZd()
	{
		return z;
	}
	
	public double getWd()
	{
		return w;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getZ()
	{
		return z;
	}
	
	public float getW()
	{
		return w;
	}
	
	public void setX(float val)
	{
		this.x = val;
	}
	
	public void setY(float val)
	{
		this.y = val;
	}
	
	public void setZ(float val)
	{
		this.z = val;
	}
	
	public void setW(float val)
	{
		this.w = val;
	}
	
	public void set(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public void set(double x, double y, double z, double w)
	{
		this.x = (float) x;
		this.y = (float) y;
		this.z = (float) z;
		this.w = (float) w;
	}
	
}
