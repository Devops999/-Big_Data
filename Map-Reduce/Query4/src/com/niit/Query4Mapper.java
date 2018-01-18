package com.niit;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public  class Query4Mapper extends Mapper<LongWritable,Text,Text,LongWritable>
{
	LongWritable one = new LongWritable(1);
	
	@Override
	public  void map (LongWritable key,Text value,Context context) throws IOException,InterruptedException
	
	{
		
		String []token = value.toString().split("\t");
		String case_status = token[1];
		String emp_name = token[2];
		String year = token[7];
		Text answer = new Text(emp_name +"\t"+ year);
		context.write(new Text(answer), one);
		
		
	}

}
