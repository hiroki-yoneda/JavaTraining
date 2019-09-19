package practice01.LookupFolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SimpleLookup implements ExtendLookup{
	private String[] names;
	private Object[] values;

	@Override
	public Object find(String name) {
		System.out.println(names);
		for(int i = 0; i < names.length; i++) {
			if(Objects.equals(names[i], name)) {
				return values[i];
			}
		}
		return null; //見つからなかった
	}

	@Override
	public Object add(String name) {
		if (names == null) {
			names = new String[] {name};
		} else {
			List<String> namesList = new ArrayList<String>(Arrays.asList(names));
			namesList.add(name);
			this.names = (String[]) namesList.toArray(new String[namesList.size()]);
		}
		return null;
	}

	@Override
	public Object remove(String name) {
		List<String> namesList = new ArrayList<String>(Arrays.asList(names));
		namesList.remove(name);
		this.names = (String[]) namesList.toArray(new String[namesList.size()]);
		return null;
	}
}
