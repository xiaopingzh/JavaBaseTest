//package com.ping.hash;
//
//import java.security.MessageDigest;
//import java.util.SortedMap;
//import java.util.TreeMap;
//
///**
// * 一致性Hash与虚拟节点
// * @author 
// *
// * 2016年1月8日 下午5:56:46
// */
//public class HashTest {
//	
//	
//	
//	private String[] servers = new String[]{};
//	
//	private Integer[] weights = new Integer[]{};
//	
//	private SortedMap<Long, String> consistentBuckets = new TreeMap<Long,String>();
//	
//	private int totalWeight;
//	
//	/**
//	 * 初始化实体与虚拟节点，另外可以设置实体节点的权重来设置不同节点虚拟节点的个数
//	 */
//	public void testPutKey(){
//		// 采用有序map来模拟环
//		this.consistentBuckets = new TreeMap();
//
//		MessageDigest md5 = MD5.get();//用MD5来计算key和server的hash值
//
//		// 计算总权重
//		if ( this.totalWeight == 0){
//			for ( int i = 0; i < this.weights.length; i++ ){
//				this.totalWeight += ( this.weights[i] == null ) ? 1 : this.weights[i];
//			}
//		}else{
//			this.totalWeight = this.servers.length;
//		}
//
//		// 为每个server分配虚拟节点
//		for ( int i = 0; i < servers.length; i++ ) {
//			// 计算当前server的权重
//			int thisWeight = 1;
//			if ( this.weights != null && this.weights[i] != null )
//				thisWeight = this.weights[i];
//
//			// factor用来控制每个server分配的虚拟节点数量
//			// 权重都相同时，factor=40
//			// 权重不同时，factor=40*server总数*该server权重所占的百分比
//			// 总的来说，权重越大，factor越大，可以分配越多的虚拟节点
//			double factor = Math.floor( ((double)(40 * this.servers.length * thisWeight)) / (double)this.totalWeight );
//			for ( long j = 0; j < factor; j++ ) {
//				// 每个server有factor个hash值
//				// 使用server的域名或IP加上编号来计算hash值
//				// 比如server - "172.45.155.25:11111"就有factor个数据用来生成hash值：
//				// 172.45.155.25:11111-1, 172.45.155.25:11111-2, ..., 172.45.155.25:11111-factor
//				byte[] d = md5.digest( ( servers[i] + "-" + j ).getBytes() );
//				// 每个hash值生成4个虚拟节点
//				for ( int h = 0 ; h < 4; h++ ) {
//					Long k =
//						((long)(d[3+h*4]&0xFF) << 24)
//					      | ((long)(d[2+h*4]&0xFF) << 16)
//					      | ((long)(d[1+h*4]&0xFF) << 8 )
//					      | ((long)(d[0+h*4]&0xFF));
//
//					// 在环上保存节点
//					consistentBuckets.put( k, servers[i] );
//				}
//			}
//			// 每个server一共分配4*factor个虚拟节点
//		}
//	}
//	
//	/**
//	 * 根据Object的Key值获取节点（实体或者虚拟节点）
//	 * @param key
//	 * @return
//	 */
//	public Object getNodeKey(String key){
//		// 用MD5来计算key的hash值
//		MessageDigest md5 = MD5.get();
//		md5.reset();
//		md5.update( key.getBytes() );
//		byte[] bKey = md5.digest();
//
//		// 取MD5值的低32位作为key的hash值
//		long hv = ((long)(bKey[3]&0xFF) << 24) | ((long)(bKey[2]&0xFF) << 16) | ((long)(bKey[1]&0xFF) << 8 ) | (long)(bKey[0]&0xFF);
//		// hv的tailMap的第一个虚拟节点对应的即是目标server
//		SortedMap tmap = this.consistentBuckets.tailMap( hv );
//		if(tmap.isEmpty()){
//			return this.consistentBuckets.firstKey();
//		}else{
//			return tmap.firstKey();
//		}
//	}
//	
//}
