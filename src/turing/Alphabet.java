package turing;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class Alphabet<E> extends HashSet<Symbol<E>>
{
	
	public Alphabet()
	{
		super.add(Symbol.BLANK);
	}
	
	public Alphabet(Collection<? extends Symbol<E>> c)
	{
		super(c);
		super.add(Symbol.BLANK);
	}
	
}
