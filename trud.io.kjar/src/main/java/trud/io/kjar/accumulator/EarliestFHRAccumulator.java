package main.java.trud.io.kjar.accumulator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Date;

import org.kie.api.runtime.rule.AccumulateFunction;

public class EarliestFHRAccumulator implements AccumulateFunction {
	public static class EarliestFHRContext implements Externalizable {

		public Date minDate = null;
		
		public EarliestFHRContext() {
			
		}
		
		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeObject(minDate);
		}

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			minDate = (Date) in.readObject();
		}
		
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
	}

	@Override
	public Serializable createContext() {
		return new EarliestFHRContext();
	}

	@Override
	public void init(Serializable context) throws Exception {
		EarliestFHRContext c = (EarliestFHRContext) context;
		c.minDate = null;

	}

	@Override
	public void accumulate(Serializable context, Object value) {
		EarliestFHRContext c = (EarliestFHRContext) context;
		
		Date fhrDate = (Date) value;
		if (c.minDate == null) {
			c.minDate = fhrDate;
		}
		if (fhrDate.before(c.minDate)) {
			c.minDate = fhrDate;
		}
	}

	@Override
	public void reverse(Serializable context, Object value) throws Exception {
		
	}

	@Override
	public Object getResult(Serializable context) throws Exception {
		return ((EarliestFHRContext) context).minDate;
	}

	@Override
	public boolean supportsReverse() {
		return false;
	}

	@Override
	public Class<?> getResultType() {
		return Date.class;
	}
}
