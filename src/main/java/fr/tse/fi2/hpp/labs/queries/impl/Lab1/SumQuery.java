package fr.tse.fi2.hpp.labs.queries.impl.Lab1;

import fr.tse.fi2.hpp.labs.beans.DebsRecord;
import fr.tse.fi2.hpp.labs.beans.measure.QueryProcessorMeasure;
import fr.tse.fi2.hpp.labs.queries.AbstractQueryProcessor;

public class SumQuery extends AbstractQueryProcessor {

	private float sum=0;
	
	public SumQuery(QueryProcessorMeasure measure) {
		super(measure);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void process(DebsRecord record) {
		// TODO Auto-generated method stub
		sum+=record.getFare_amount();
		writeLine("somme "+ sum);
	}

}
