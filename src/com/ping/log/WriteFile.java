package com.ping.log;

import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author 
 *
 * 2015年12月7日 下午2:32:50
 */
public class WriteFile {
	
	public static String datapath = null;
	private static Map<String,LogFileVo> map = new ConcurrentHashMap<String,LogFileVo>();
	
	private static String DATA_FILE_PATH  = "/Users/a58/Desktop/logs/";

	static{
		try {
			datapath = DATA_FILE_PATH;
			File dir = new File(datapath);
			if(!dir.exists()){
				dir.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static void write(String fileName,String logstring){
		try {
			if(logstring == null){
				return ;
			}
			String filepath =datapath+fileName;
			logstring=logstring+"\n";
			String datestr =dateFormat(new Date(),"yyyy-MM-dd");
			LogFileVo logfile = map.get(fileName);
			if(logfile == null){
				logfile = map.get(fileName);
				if(logfile == null){
					File file = new File(filepath);
					if(!file.exists()){
						file.createNewFile();
					}
					RandomAccessFile raf = new RandomAccessFile(file,"rw");
					long position = raf.length();
					logfile = new LogFileVo(raf,position,datestr);
					map.put(fileName, logfile);
				}
			}else{
				logfile = map.get(fileName);
				if(!datestr.equals(logfile.getDatestr())){
					logfile = map.get(fileName);
					if(!datestr.equals(logfile.getDatestr())){
						logfile.getFile().close();
						File file = new File(filepath);
						if(!file.exists()){
							file.createNewFile();
						}
						RandomAccessFile raf = new RandomAccessFile(file,"rw");
						long position = raf.length();
						logfile = new LogFileVo(raf,position,datestr);
						map.put(fileName, logfile);
					}
				}
			}
			RandomAccessFile raf = logfile.getFile();
			raf.seek(logfile.getPosition());
			byte[] bys = logstring.getBytes("UTF-8");
			raf.write(bys);
			logfile.setPosition(logfile.getPosition()+bys.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(String fileName){
		String filepath = datapath+fileName;;
		if(filepath != null){
			File f = new File(filepath);
			if(f != null){
				f.delete();
			}
		}
		if(map.containsKey(fileName)){
			map.put(fileName, null);
		}
	}
	
	public static String dateFormat(Date date, String format) {
		if (null == date)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}