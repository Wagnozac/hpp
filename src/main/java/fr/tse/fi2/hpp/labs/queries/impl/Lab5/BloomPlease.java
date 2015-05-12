package fr.tse.fi2.hpp.labs.queries.impl.Lab5;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.digests.ShortenedDigest;

import fr.tse.fi2.hpp.labs.beans.DebsRecord;
import fr.tse.fi2.hpp.labs.beans.measure.QueryProcessorMeasure;
import fr.tse.fi2.hpp.labs.queries.AbstractQueryProcessor;

public class BloomPlease extends AbstractQueryProcessor {
	
	private static BitSet bloom;
	private final int n;
	private final double p;
	private static int taille;
	private static int m;
	
	
	public BloomPlease(QueryProcessorMeasure measure,int n, /* Math.ceil(Math.log(m)/Math.log(2))%m*/double p) {
		super(measure);
		this.n=n;
		this.p=p;
		this.m = (int) Math.ceil((n * Math.log(p)) / Math.log(1.0 / (Math.pow(2.0, Math.log(2.0)))));
		this.bloom=new BitSet(m);
		this.bloom.clear();
		int k = (int) Math.round(Math.log(2.0) * m / n);
		this.taille =(int) (Math.ceil(Math.log10(m)/Math.log10(2))%m);
		System.out.println(m +"       "+ k +"     "+ taille);
		
		
		
		
		
	}

	@Override
	protected void process(DebsRecord record) {
		
		for (int i =0; i<10 ;i++)
		{
			
			String a =record.toString()+i;
			BigInteger b = hashPlease(a,"SHA-256");
			bloom.set(b.intValue());
			
		}
	
		

	}
	
	public static BigInteger hashPlease(String is, String Inst ) {
	    String output;
	    BigInteger res = null;
	    try {
	        MessageDigest digest = MessageDigest.getInstance(Inst);
	        digest.update(is.getBytes("UTF-8"));
	        
	        byte[] hash = digest.digest() ;
	       
	        BigInteger bigInt = new BigInteger(1, hash);
	        res = bigInt.mod(BigInteger.valueOf(m));
	        System.out.println(" "+res + "  ");
	        System.out.println(" "+res.bitLength()+" ");
	        output = res.toString(16);
	        while ( output.length() < 32 ) {
	            output = "0"+output;
	        }
	        
	    } 
	    catch (Exception e) {
	        e.printStackTrace(System.err);
	        return res;
	    }
	    
	    return res;
	}

	

	public static boolean contains(String str){
		
		boolean result = true;
		for (int i =0; i<10 ;i++)
		{
			String triche = str + "i";
			BigInteger b = hashPlease(triche,"SHA-256");
			if (bloom.get(b.intValue())==false)
			{
				result =false;
			}
				
			
		}
		System.out.println(result);
		return result;
	}
	

}
