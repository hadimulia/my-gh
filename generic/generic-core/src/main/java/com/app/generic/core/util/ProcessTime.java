package com.app.generic.core.util;

import org.springframework.stereotype.Component;

@Component
public class ProcessTime {
	long startTime;
	long estimatedTime;
	long memory;
	Runtime runtime;
	private static final long MEGABYTE = 1024L * 1024L;
	
	public void startTime(){
		startTime = System.nanoTime(); 
	}
	
	public void endGetDataTime(){
		estimatedTime = System.nanoTime() - startTime; //check different
		System.out.println("-------------------------------");
	    System.out.println("Load Data elapsed in : " + estimatedTime/1.0E09 + " seconds");
	}
	
	public void endCalculateDataTime(){
		estimatedTime = System.nanoTime() - startTime; //check different
		System.out.println("-------------------------------");
	    System.out.println("Process Data elapsed in : " + estimatedTime/1.0E09 + " seconds");
	}
	
	public void endInsertDataTime(){
		estimatedTime = System.nanoTime() - startTime; //check different
		System.out.println("-------------------------------");
	    System.out.println("Insert Data elapsed in : " + estimatedTime/1.0E09 + " seconds");
	}
	
	public void getMemoryUsed(){
		runtime = Runtime.getRuntime();
		runtime.gc();  // Run the garbage collector
		memory = runtime.totalMemory() - runtime.freeMemory(); //calculate the used memory
		System.out.println("-------------------------------");
		System.out.println("Used memory is bytes: " + memory);
		System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
		System.out.println("-------------------------------");
	}
	
	public static long bytesToMegabytes(long bytes){
		return bytes / MEGABYTE;
	}
	
	public void clearTime(){
		startTime = 0;
		estimatedTime = 0;
	}
}