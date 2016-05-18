package com.ping.log;

import java.io.RandomAccessFile;

public class LogFileVo {

	
	private RandomAccessFile file = null;
	
	private long position ;
	
	private String datestr;
	
	public LogFileVo(RandomAccessFile file,long position,String datestr){
		this.file = file;
		this.position = position;
		this.datestr = datestr;
	}

	public RandomAccessFile getFile() {
		return file;
	}

	public void setFile(RandomAccessFile file) {
		this.file = file;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public String getDatestr() {
		return datestr;
	}

	public void setDatestr(String datestr) {
		this.datestr = datestr;
	}

}
