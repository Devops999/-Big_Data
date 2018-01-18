package com.niit;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable.DecreasingComparator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

	public class Query8Driver {

	    public static void main(String args[]) throws IOException, InterruptedException, ClassNotFoundException

	    {
	        Configuration conf = new Configuration();
	        Job job1 = Job.getInstance(conf, "Average prevailing wage for each job for each year");
	        

	        job1.setJarByClass(Query8Driver.class);
	        job1.setMapperClass(Query8Mapper1.class);
	        
	        if(args[2].equals("ALL")){
	        	
	        job1.setPartitionerClass(Query8Partitioner.class);
	        job1.setNumReduceTasks(6);
	        }
	        
	        job1.setReducerClass(Query8Reducer1.class);

	       // job.setNumReduceTasks(7);

	        job1.setMapOutputKeyClass(Text.class);
	        job1.setMapOutputValueClass(Text.class);

	        job1.setOutputKeyClass(Text.class);
	        job1.setOutputValueClass(Text.class);

	        FileInputFormat.addInputPath(job1, new Path(args[0]));
	        FileOutputFormat.setOutputPath(job1, new Path(args[1]));
	        job1.waitForCompletion(true);
	        
	        Job job2 = Job.getInstance(conf,"Average Prevailing Wage for each Job for Each Year");

	        job2.setJarByClass(Query8Driver.class);
	        job2.setMapperClass(Query8Mapper2.class);
	      //  if(args[2].equals("ALL"))
	       // {
	        	job2.setSortComparatorClass(DecreasingComparator.class);
	        	job2.setReducerClass(Query8Reducer2.class);
	        	job1.setMapOutputKeyClass(Text.class);
		        job1.setMapOutputValueClass(Text.class);

		        job2.setOutputKeyClass(Text.class);
		        job2.setOutputValueClass(Text.class);

		        FileInputFormat.addInputPath(job2, new Path(args[0]));
		        FileOutputFormat.setOutputPath(job2, new Path(args[1]));
		        System.exit(job2.waitForCompletion(true) ? 0 : 1);
	        	
	        
	    }

	}





