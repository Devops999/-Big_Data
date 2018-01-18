package com.niit;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
//import org.w3c.dom.Text;

public class Query4Partitioner extends Partitioner<Text,LongWritable> {
	public int getPartition(Text key,LongWritable value,int numReduceTask){
		String[] str = key.toString().split("\t");
		if(str.equals("2011"))

			return 0;
		if(str.equals("2012"))
			return 1;
		if(str.equals("2013"))
			return 2;
		if(str.equals("2014"))
			return 3;
		if(str.equals("2015"))
			return 4;
		if(str.equals("2016"))
			return 5;
		else
			return 6;
		
		
		
	
		
	}

}
