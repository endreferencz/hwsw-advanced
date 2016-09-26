package com.epam.training;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Description;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.IntResult1;


/**
 *
 * Run with: java -XX:-UseCompressedOops -jar target/jcstress.jar -v
 *
 */
public class SingletonTest {
	@JCStressTest
	@Description("Tests the unsafe singleton pattern.")
	@Outcome(id = "[-2]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Singleton.getInstance() returned null.")
	@Outcome(id = "[-1]", expect = Expect.ACCEPTABLE_INTERESTING, desc = "singleton.number is null.")
	@Outcome(id = "[1]", expect = Expect.ACCEPTABLE, desc = "Expected result.")
	public static class Test {
		@Actor
		public final void actor1(SingletonFactory s) {
			s.getInstance();
		}

		@Actor
		public final void actor2(SingletonFactory s, IntResult1 r) {
			Singleton singleton = s.getInstance();
			if (singleton == null) {
				r.r1 = -2;
			} else {
				Long number = singleton.number;
				if (number == null) {
					r.r1 = -1;
				} else if (number == 1) {
					r.r1 = 1;
				}
			}
		}
	}

	public static class Singleton {
		private Long number = 1L;
	}

	@State
	public static class SingletonFactory {
		private Singleton instance; // non-volatile

		public Singleton getInstance() {
			if (instance == null) {
				synchronized (this) {
					if (instance == null) {
						instance = new Singleton();
					}
				}
			}
			return instance;
		}
	}

}
