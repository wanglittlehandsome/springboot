package com.bestway.program.common.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.base.Verify;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * 说明：序列化帮助类
 * 
 * @author J.
 * @version 1.0
 * @date 2017年9月7日
 */
public class SerializeUtils {

	private static final Kryo kryo = new Kryo();

	private SerializeUtils() {
		throw new AssertionError();
	}

	/**
	 * 
	 * 说明：序列化对象
	 * 
	 * @author J.
	 * @param value
	 * @return
	 * @time：2017年9月7日 上午10:26:58
	 */
	public static <T extends Serializable> byte[] serialize(T value) {
		Verify.verifyNotNull(value);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (Output output = new Output(baos)) {
			kryo.writeClassAndObject(output, value);
			output.flush();
			return baos.toByteArray();
		}
	}

	/**
	 * 
	 * 说明：反序列化对象
	 * 
	 * @author J.
	 * @param bits
	 * @return
	 * @time：2017年9月7日 上午10:27:09
	 */
	public static Object deserialize(byte[] bits) {
		if (Objects.isNull(bits) || bits.length == 0) {
			return null;
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(bits);
		try (Input ois = new Input(bais)) {
			return kryo.readClassAndObject(ois);
		}
	}
}
