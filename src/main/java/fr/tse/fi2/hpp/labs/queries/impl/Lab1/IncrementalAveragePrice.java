package fr.tse.fi2.hpp.labs.queries.impl.Lab1;

import fr.tse.fi2.hpp.labs.beans.DebsRecord;
import fr.tse.fi2.hpp.labs.beans.measure.QueryProcessorMeasure;
import fr.tse.fi2.hpp.labs.queries.AbstractQueryProcessor;

public class IncrementalAveragePrice extends AbstractQueryProcessor {

	private int nb = 0;
	private float sum = 0;
	
	public IncrementalAveragePrice(QueryProcessorMeasure measure) {
		super(measure);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void process(DebsRecord record) {
		nb++;
		sum += record.getFare_amount();
		writeLine("current mean : " + (sum / nb));
	}


}
