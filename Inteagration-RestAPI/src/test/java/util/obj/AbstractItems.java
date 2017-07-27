package util.obj;

import java.util.Collection;
import java.util.function.Supplier;

import org.apache.commons.collections4.CollectionUtils;


public abstract class AbstractItems <T>
{
	protected T getOrSaveAndReturn(final Supplier<T> getter, final Supplier<T> creator)
	{
		T obj = null;
			obj = getter.get();
			if (obj == null)
			{
				System.out.println("Object returned null.");
				obj = creator.get();
			}
		return obj;
	}

	protected T getFromCollectionOrSaveAndReturn(final Supplier<Collection<T>> getter, final Supplier<T> creator)
	{
		T obj = null;
		if (!CollectionUtils.isEmpty(getter.get()))
		{
			System.out.println("Object already exist.");
		}
		else
		{
			obj = creator.get();
		}
		return obj;
	}

}
