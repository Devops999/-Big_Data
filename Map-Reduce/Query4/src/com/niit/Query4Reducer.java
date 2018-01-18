package com.niit;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Query4Reducer extends Reducer<Text,LongWritable,NullWritable,Text>{
	long sum=0;
	private TreeMap<LongWritable,Text> Top5Employers = new TreeMap<LongWritable,Text>();
public void reduce(Text key,Iterable<LongWritable>values,Context context)throws IOException,InterruptedException

{
for (LongWritable val:values){
	sum += val.get();
}

Top5Employers.put(new LongWritable(sum),new Text(key +"," +sum));
if(Top5Employers.size()>5)
	Top5Employers.remove(Top5Employers.firstKey());

}
protected void cleanup(Context context) throws IOException,InterruptedException{
	for (Text t:Top5Employers.descendingMap().values())
		context.write(NullWritable.get(), t);
}
}
