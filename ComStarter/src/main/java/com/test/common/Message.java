package com.test.common;

import com.github.arunsoman.ipc.mappedbus.MappedBusMessage;
import com.github.arunsoman.ipc.mappedbus.MemoryMappedFile;

public class Message implements MappedBusMessage {

	public static final int TYPE = 0;
	private String message;

	private final static int offset = 0;
	private final static int length = 1024;

	public String getMessage() {
		return message;
	}

	public Message(String msg) {
		message = msg;
	}

	@Override
	public void write(MemoryMappedFile mem, long pos) {
		byte[] data = message.getBytes();
		mem.setBytes(pos, data, offset, length);
	}

	@Override
	public void read(MemoryMappedFile mem, long pos) {
		byte[] data = new byte[length];
		mem.getBytes(pos, data, offset, length);
		message = new String(data);
	}

	@Override
	public int type() {
		return TYPE;
	}

}
