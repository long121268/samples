1��handlerִ����ɺ�ִ����һ��handler������ctx.fireChannelRead(msg)����

2����handler��д���ݣ�����ת����ByteBuf�������ж�Ӧ��Encoder��

3��ÿ��handler�е�context�Ƕ����ģ�����Ӱ�졣

4����δ�����outboundhandler��
	encoder �����ڰ���write������decoder֮ǰ����
	decoder�б������write���������ܴ���encoder

5��inbound��ִ��˳���ȷ������ִ�У�������12345��˳��ִ�С�
outbound��ִ��˳�򣺺�������ִ�У�������54321��˳��ִ�С�
	












