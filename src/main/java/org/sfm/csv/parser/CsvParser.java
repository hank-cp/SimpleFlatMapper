package org.sfm.csv.parser;

import java.io.IOException;
import java.io.Reader;

import org.sfm.utils.RowHandler;

public final class CsvParser {
	
	private final int bufferSize;
	
	public CsvParser(final int bufferSize) {
		this.bufferSize = bufferSize;
	}
	
	public CsvParser() {
		this(1<<16);
	}
		
	public <CH extends CharsCellHandler> CH parse(final Reader r, final CH handler) throws IOException {
		new ReaderCsvParser(bufferSize).parse(r, handler);
		return handler;
	}
	
	public <RH extends RowHandler<String[]>> RH readRows(final Reader r, final RH handler) throws IOException {
		new ReaderCsvParser(bufferSize).parse(r, new StringArrayHandler(handler));
		return handler;
	}
}
