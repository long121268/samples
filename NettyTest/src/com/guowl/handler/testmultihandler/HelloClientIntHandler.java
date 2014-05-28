package com.guowl.handler.testmultihandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloClientIntHandler extends ChannelInboundHandlerAdapter {
	private static Logger	logger	= LoggerFactory.getLogger(HelloClientIntHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("HelloClientIntHandler.channelRead");
		ByteBuf result = (ByteBuf) msg;
		byte[] result1 = new byte[result.readableBytes()];
		result.readBytes(result1);
		result.release();
		ctx.close();
		System.out.println("Server said:" + new String(result1));
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("HelloClientIntHandler.channelActive");
		String msg = "Are you ok?";
		ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
		encoded.writeBytes(msg.getBytes());
		ctx.write(encoded);
		ctx.flush();
	}
}
