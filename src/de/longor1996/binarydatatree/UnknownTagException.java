package de.longor1996.binarydatatree;

import java.io.IOException;

public class UnknownTagException extends IOException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4205237279899293711L;
	
	public UnknownTagException(String text)
	{
		super(text);
	}
	
}
