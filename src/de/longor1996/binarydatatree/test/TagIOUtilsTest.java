package de.longor1996.binarydatatree.test;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import org.junit.Test;

import de.longor1996.binarydatatree.TagIOUtils;
import de.longor1996.binarydatatree.Tag;
import de.longor1996.binarydatatree.tags.collections.TTagCompound;

public class TagIOUtilsTest
{

	@Test
	public void writeTest()
	{
		// Write Test
		{
			TTagCompound comp = new TTagCompound("root");
			comp.putByte("aByte", (byte) 127);
			comp.putDouble("aFloat", Math.PI);
			
			for(int i = 0; i < 4; i++)
			{
				TTagCompound child = new TTagCompound("child" + i);
				child.putTuple3f("position", 1, 2, 3);
				child.putInteger("score", 58934753);
				comp.setTag(child);
			}
			
			try {
				TagIOUtils.write(comp, new File("output.bin"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void readTest()
	{
		// Read Test
		{
			Tag tag = null;
			try {
				tag = TagIOUtils.read(new File("output.bin"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			TTagCompound comp = (TTagCompound) tag;
			print(comp, "  ");
		}
	}
	
	private void print(Tag tag, String prefix)
	{
		System.out.println(prefix + "tag:" + tag.getName() + "/" + tag.getID());
		
		if(tag instanceof TTagCompound)
		{
			TTagCompound comp = (TTagCompound) tag;
			comp.convertBackingMapToTreeMap();
			
			for(Entry<String, Tag> entry : comp.getBackingMap().entrySet())
			{
				print(entry.getValue(), prefix + "  ");
			}
		}
	}

}
