package com.guowl.handler.testobjcoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.guowl.utils.ByteBufToBytes;

public class StringDecoder extends ByteToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// 判断是否是String协议
		byte n = "n".getBytes()[0];
		byte p = in.readByte();
		// 把读取的起始位置重置
		in.resetReaderIndex();
		if (n == p) {
			ByteBufToBytes reader = new ByteBufToBytes();
			String msg = new String(reader.read(in));
			Person person = buildPerson(msg);
			out.add(person);
		} else {
			//ctx.fireChannelRead(in);
		}
	}

	private Person buildPerson(String msg) {
		Person person = new Person();
		String[] msgArray = msg.split(";|:");
		person.setName(msgArray[1]);
		person.setAge(Integer.parseInt(msgArray[3]));
		person.setSex(msgArray[5]);
		return person;
	}
}
