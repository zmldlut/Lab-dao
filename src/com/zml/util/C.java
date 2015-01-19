package com.zml.util;

public class C {
	//电脑预约系统
	public static final class code {
        public static final int login   = 1000;
        public static final int device_list         = 1001;
        public static final int order_list          = 1002;
        public static final int report              = 1003;
        public static final int password            = 1004;
        public static final int order            	= 1005;
        
        public static final int logout  = 1001;
        public static final int notice  = 1002;
        public static final int error   = 1003;
    }
	
	/*和网关通信*/
	
	//包类型
	public static final class packet {
		//数据包类型
		public static final int DOOROPENPACKETTYPE 		= 1003;
		public static final int CURTIONPACKETTYPE		= 1005;
		public static final int LAMPPACKETTYPE			= 1006;

		//json数据中的key
		public static final String SYN = "syn";
		public static final String PACKETTYPE = "packetType";
		public static final String CMD = "command";
		public static final String USERID = "userID";
		public static final String ACK = "ack";
	}
	
	//命令
	public static final class cmd {
		public static final int open_door 			= 1000;
		public static final int open_curtain		= 1001;
		public static final int close_curtain		= 1002;
		public static final int open_lamp			= 1003;
		public static final int close_lamp			= 1004;
	}
}
