package com.niit;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Query8Partitioner2 extends Partitioner<DoubleWritable, Text>
{

	//@Override
	public int getPartition(DoubleWritable key, Text value, int numReduceTasks) {
		
		String[] token = value.toString().split("\t");
		String year = token[0];
		
		if(year.equals("2011"))
		{
			return 0 % numReduceTasks;
		}
		else if(year.equals("2012"))
		{
			return 1 % numReduceTasks;
		}
		else if(year.equals("2013"))
		{
			return 2 % numReduceTasks;
		}
		else if(year.equals("2014"))
		{
			return 3 % numReduceTasks;
		}
		else if(year.equals("2015"))
		{
			return 4 % numReduceTasks;
		}
		else
		{
			return 5 % numReduceTasks;
		}
	}
	
}