package de.longor1996.binarydatatree;

import java.util.HashMap;

public enum TagType
{
	/** A tag that marks the end of a compound-tag. **/
	END(0, "End"),
	
	/**
	 * A tag that contains a map of tags of any types.
	 * In other words: This tag can store ANY other tag, at the cost of memory and performance.
	 **/
	COMPOUND(1, "TagCompound"),
	
	/**
	 * A tag that stores any amount of tags of a single type.
	 * 
	 * Or in other words: <pre>List(generic E) list;</pre>
	 **/
	TAGLIST(2, "TagList"),
	
	
	
	
	
	
	
	/** A tag that stores either 0(false) or 1(true). **/
	BOOLEAN(0x09, "Boolean"),
	
	/** A tag that stores a full number from 0 to 255. **/
	BYTE(0x0A, "Byte"),
	
	/** A tag that stores a full number from 0 to 65535. **/
	CHAR(0x0B, "Char"),
	
	/** A tag that stores a full number from -32,768 to 32,767 **/
	SHORT(0x0C, "Short"),
	
	/** A tag that stores a full number from -2,147,483,648 to 2,147,483,647 **/
	INTEGER(0x0D, "Integer"),
	
	/** A tag that stores a full number from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 **/
	LONG(0x0E, "Long"),
	
	/**
	 * A tag that stores a floating point number,
	 * that can range from 1.40129846432481707e-45 to 3.40282346638528860e+38,
	 * both positive and negative
	 **/
	FLOAT(0x0F, "Float"),
	
	/**
	 * A tag that stores a floating point number,
	 * that can range from 4.94065645841246544e-324d to 1.79769313486231570e+308d,
	 * both positive and negative
	 **/
	DOUBLE(0x10, "Double"),
	
	/**
	 * A tag that contains a string with its length.
	 * The length is defined as two bytes N,
	 * and the actual string is defined as N*2 bytes long and immediately follows the length in data.
	 **/
	STRING_LENCODE(0x11, "StringLENCODE"),
	
	/**
	 * A tag that contains a zero-terminated string.
	 **/
	STRING_ZEROTERMINATE(0x12, "StringZEROTERMINATE"),
	
	/**
	 * A tag that contains a string of exactly 256 characters.
	 **/
	// STRING_256(0x13, "String256"),          /// XXX: Most certainly a bad idea? Useless? Remove?
	
	/**
	 * A tag that stores a single UUID as 128 bit integer.
	 **/
	UUID(0x14, "UUID"),
	
	/**
	 * A tag that stores a byte-array with a maximum size of 2,147,483,647 elements.
	 **/
	BYTEARRAY(0x15, "ByteArray"), 
	
	/**
	 * A tag that stores a integer(32)-array with a maximum size of 2,147,483,647 elements.
	 **/
	INTARRAY(0x16, "IntArray"), 
	
	/**
	 * A tag that stores a array of 32-bit floating point numbers, with a maximum size of 2,147,483,647 elements.
	 **/
	FLOATARRAY(0x17, "FloatArray"), 
	
	/**
	 * A tag that stores a array of booleans.
	 **/
	BOOLARRAY(0x18, "BoolArray"), 
	
	
	
	
	
	
	
	/**
	 * A tag that stores 3 32-bit floating point numbers. ('Vector3f')
	 **/
	TUPLE3F(0x20, "Tuple3f"),
	
	/**
	 * A tag that stores 3 64-bit floating point numbers. ('Vector3d')
	 **/
	TUPLE3D(0x21, "Tuple3d"),
	
	/**
	 * A tag that stores 4 32-bit floating point numbers. ('Vector4f')
	 **/
	TUPLE4F(0x22, "Tuple4f"),
	
	/**
	 * A tag that stores 4 64-bit floating point numbers. ('Vector4d')
	 **/
	TUPLE4D(0x23, "Tuple4d"),
	
	
	
	
	
	
	
	;//////////////////////////////////////////////////////////////////////////
	
	public final int as_int;
	public final byte as_byt;
	public final String as_str;
	
	private TagType(int ID, String NAME)
	{
		as_int = ID;
		as_byt = (byte) (ID& 0xFF);
		as_str = NAME;
	}
	
	private static final HashMap<String, TagType> mapping_str_oc;
	private static final TagType[] mapping_id_oc;
	static
	{
		TagType[] codes = TagType.values();
		int count = codes.length;
		
		
		mapping_str_oc = new HashMap<String, TagType>(count);
		for(TagType code : codes)
		{
			mapping_str_oc.put(code.as_str, code);
		}
		
		mapping_id_oc = new TagType[count];
		System.arraycopy(codes, 0, mapping_id_oc, 0, count);
	}
	
	public static final TagType get(String NAME)
	{
		return mapping_str_oc.get(NAME);
	}
	
	public static final TagType get(int ID)
	{
		return mapping_id_oc[ID];
	}
	
}
