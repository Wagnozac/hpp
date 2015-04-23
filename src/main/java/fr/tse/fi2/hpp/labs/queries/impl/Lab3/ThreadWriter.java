package fr.tse.fi2.hpp.labs.queries.impl.Lab3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.tse.fi2.hpp.labs.queries.AbstractQueryProcessor;

public class ThreadWriter implements Runnable {

	BufferedWriter outputWriter;
	int id;
	LinkedBlockingQueue<String> q;
	public boolean poison=false;
	
	public ThreadWriter (LinkedBlockingQueue<String> q, int id)
	{
		super();
		this.q=q;
		this.id=id;	
		try {
			outputWriter = new BufferedWriter(new FileWriter(new File(
					"result/query" + id + ".txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void run() {	
		
		while (!poison){
			try {
				String line =q.take();
				writeLine(this.id,line);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		finish();
	}

	public void writeLine(int id,String line){
		try {
				
			
			outputWriter.write("somme : " + line);
			outputWriter.newLine();
			
			
		} catch (IOException e) {

		}

		
	}
	
	
	public void finish() {
		// Close writer
		try {
			outputWriter.flush();
			outputWriter.close();
		} catch (IOException e) {

		}

	}
	
	
	
	
}
