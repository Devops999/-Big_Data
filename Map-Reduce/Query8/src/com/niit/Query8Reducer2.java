package com.niit;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class Query8Reducer2 extends Reducer  <DoubleWritable,Text,Text,DoubleWritable>{
	protected void reduce(DoubleWritable key,Iterable<Text>values,Context context) throws IOException, InterruptedException
	{
		int counter = 0;
	

			
			for(Text val :values)
			{
				if(counter < 5)
				{	
				 context.write(new Text(val), key);
				 counter= counter+1;
				}
			}
		
}
	}

