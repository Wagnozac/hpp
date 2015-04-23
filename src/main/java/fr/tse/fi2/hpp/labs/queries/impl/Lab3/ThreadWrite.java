package fr.tse.fi2.hpp.labs.queries.impl.Lab3;

import java.util.NoSuchElementException;

import fr.tse.fi2.hpp.labs.beans.DebsRecord;
import fr.tse.fi2.hpp.labs.beans.measure.QueryProcessorMeasure;
import fr.tse.fi2.hpp.labs.queries.AbstractQueryProcessor;

public class ThreadWrite extends AbstractQueryProcessor{
	public ThreadWrite(QueryProcessorMeasure measure)
	{
		super(measure);
	}
	public void write(String s){
		
	}
	
	@Override
	protected void process(DebsRecord record) {
		// TODO Auto-generated method stub
		writeLine("somme : " + sumList.poll());

	}

}
