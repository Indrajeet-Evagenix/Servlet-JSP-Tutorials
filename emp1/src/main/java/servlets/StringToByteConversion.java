package servlets;

public class StringToByteConversion {

	public static byte[] stringToByte(String str[]) {
		byte[] bytes = new byte[str.length];

		for (int i = 0; i < str.length; i++) {
			bytes[i] = Byte.parseByte(str[i]);
		}
		return bytes;
	}

}
