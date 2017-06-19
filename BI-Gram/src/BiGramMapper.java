import java.io.IOException;
import java.util.ArrayList;

import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BiGramMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	ArrayList<String> ls=new ArrayList<String>();
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		StringTokenizer words=new StringTokenizer(value.toString(), " ");
		while(words.hasMoreTokens())
		{
			String word=words.nextToken();
			ls.add(word);
		}
		
		
	}

	@Override
	protected void cleanup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		for (int i = 0; i < ls.size()-1; i++) {
			context.write(new Text(ls.get(i)+" "+ls.get(i+1)), new IntWritable(1));
		}
	}
	
}
