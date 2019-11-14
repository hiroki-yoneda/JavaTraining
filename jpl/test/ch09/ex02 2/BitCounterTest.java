package jpl.ch09.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BitCounterTest {

	@Test
	public void BitCheck() {
		BitCounter bit_Counter = new BitCounter();
		assertThat(bit_Counter.CheckBitCount(2), is(1));
	}
}
