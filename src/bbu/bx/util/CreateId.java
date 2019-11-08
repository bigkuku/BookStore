package bbu.bx.util;

import java.util.UUID;
/**
 * 生成一个id
 * @author 陶程凯
 *
 */
public class CreateId {
	public	static String getId() {
		UUID uuid=UUID.randomUUID();
		String str=uuid.toString();
		str=str.replaceAll("-", "");
		return str;
	}
}
