
public class HashTable_double {
	
	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	private final Entry NIL = new Entry(null);
	
	public HashTable_double(int capacity, float loadFactor){
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	
	public HashTable_double(int capacity){
		this(capacity, 0.75F);
	}
	
	public HashTable_double(){
		this(11);
	}
	
	public Object put(Object key){
		if(used>loadFactor*entries.length) rehash();
		int h = hash(key), d = hash2(key);
		for(int i=0; i<entries.length; i++){
			int j = nextProbe(h,d,i);
			Entry entry = entries[j];
			if(entry == null){
				entries[j] = new Entry(key);
				++size;
				++used;
				return null;
			}
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				entry.count++;
				return entry.key;
			}
		}
		return null;
	}

	public int size() {
		return size;
	}

		
	private class Entry{
		int count=1;
		Object key;	
		Entry(Object k){key = k; }
	}
	
	private int hash(Object key){	
		if(key == null)throw new IllegalArgumentException();
		return (key.hashCode()&0x7FFFFFFF)%entries.length;
	}
	
	private int hash2(Object key){
		if(key == null)throw new IllegalArgumentException();
		return 1 + (key.hashCode()&0x7FFFFFFF)%(entries.length-1);
	}
		
	private int nextProbe(int h, int d, int i){
		return (h+i*d)%entries.length;
	}
	
	private void rehash(){
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k=0; k<oldEntries.length; k++){
			Entry entry = oldEntries[k];
			if(entry == null || entry == NIL) continue;
			int h = hash(entry.key), d = hash2(entry.key);
			for(int i=0; i<entries.length;i++){
				int j= nextProbe(h,d,i);
				if(entries[j]==null){
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
	
	public void print(){
		for(int i=0; i<entries.length; i++)
			if(entries[i]!=NIL && entries[i]!=null)
				System.out.println(entries[i].key+": "+ entries[i].count);
	}
}
