package com.niit;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Query6Mapper extends Mapper < LongWritable, Text, Text, Text > {
	//LongWritable one = new LongWritable(1);
    public void map(LongWritable key, Text value, Context context) throws IOException,
    InterruptedException {
       // if (key.get() > 0)

        {
            String[] token = value.toString().split("\t");
            String year = token[7];
            String case_status = token[1];
            
           
               // Text answer = new Text(token[2].replaceAll("\"", "") + "\t" + token[7]);
                context.write(new Text(year), new Text(case_status));
            }

}
}
