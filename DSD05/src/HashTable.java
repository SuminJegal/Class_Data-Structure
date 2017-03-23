
public class HashTable {
	
	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	private int collision=0; //Ãæµ¹
	private final Entry NIL = new Entry(null,null);
	
	public HashTable(int capacity, float loadFactor){
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	
	public HashTable(int capacity){
		this(capacity, 0.75F);
	}
	
	public HashTable(){
		this(101);
	}
	
	public Object get_linear(Object key){
		int h = hash(key);
		for(int i=0; i<entries.length;i++){
			int j = nextProbe(h,i);
			Entry entry=entries[j];
			if(entry==null) break;
			if(entry==NIL) continue;
			if(entry.key.equals(key)) return entry.value;
		}
		return null;
	}
	
	public Object get_quadratic(Object key){
		int h = hash(key);
		for(int i=0; i<entries.length;i++){
			int j = (h+i*i)%entries.length;
			Entry entry=entries[j];
			if(entry==null) break;
			if(entry==NIL) continue;
			if(entry.key.equals(key)) return entry.value;
		}
		return null;
	}
	
	public Object get_double(Object key){
		int h = hash(key), d = hash2(key);
		for(int i=0; i<entries.length;i++){
			int j = nextProbe2(h,d,i);
			Entry entry=entries[j];
			if(entry==null) break;
			if(entry==NIL) continue;
			if(entry.key.equals(key)) return entry.value;
		}
		return null;
	}
	
	public Object put_linear(Object key, Object value){
		if(used>loadFactor*entries.length) rehash_linear();
		System.out.print(key);
		int h = hash(key);
		for(int i=0; i<entries.length; i++){
			collision++;
			int j = nextProbe(h,i);
			Entry entry = entries[j];
			System.out.print(" -> "+j+" ");
			if(entry == null){
				entries[j] = new Entry(key, value);
				++size;
				++used;
				--collision;
				System.out.println();
				return null;
			}
			if(entry == NIL){
				continue;
			}
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j].value = value;
				return oldValue;
			}
		}
		return null;
	}
	
	public Object put_quadratic(Object key, Object value){
		if(used>loadFactor*entries.length) rehash_quadratic();
		System.out.print(key);
		int h = hash(key);
		for(int i=0; i<entries.length; i++){
			collision++;
			int j = (h+i*i)%entries.length;
			Entry entry = entries[j];
			System.out.print(" -> "+j+" ");
			if(entry == null){
				entries[j] = new Entry(key, value);
				++size;
				++used;
				--collision;
				System.out.println();
				return null;
			}
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j].value = value;
				return oldValue;
			}
		}
		return null;
	}
	
	public Object put_double(Object key, Object value){
		if(used>loadFactor*entries.length) rehash_double();
		System.out.print(key);
		int h = hash(key), d = hash2(key);
		for(int i=0; i<entries.length; i++){
			collision++;
			int j = nextProbe2(h,d,i);
			Entry entry = entries[j];
			System.out.print(" -> "+j+" ");
			if(entry == null){
				entries[j] = new Entry(key, value);
				++size;
				++used;
				--collision;
				System.out.println();
				return null;
			}
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j].value = value;
				return oldValue;
			}
		}
		return null;
	}
	
	public Object remove_linear(Object key) {
		int h = hash(key);
		for(int i=0; i<entries.length;i++){
			int j = nextProbe(h,i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;
			}
		}
		return null;
	}
	
	public Object remove_quadratic(Object key) {
		int h = hash(key);
		for(int i=0; i<entries.length;i++){
			int j = (h+i*i)%entries.length;
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;
			}
		}
		return null;
	}

	public Object remove_double(Object key) {
		int h = hash(key), d = hash2(key);
		for(int i=0; i<entries.length;i++){
			int j = nextProbe2(h,d,i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;
			}
		}
		return null;
	}

	public int size() {
		return size;
	}

		
	private class Entry{
		Object key, value;	
		Entry(Object k, Object v){key = k; value = v;}
	}
	
	private int hash(Object key){	
		if(key == null)throw new IllegalArgumentException();
		return (key.hashCode()&0x7FFFFFFF)%entries.length;
	}
	
	private int hash2(Object key){
		if(key == null)throw new IllegalArgumentException();
		return 1 + (key.hashCode()&0x7FFFFFFF)%(entries.length-1);
	}
		
	private int nextProbe(int h, int i){
		return (h+i)%entries.length;
	}
	
	private int nextProbe2(int h, int d, int i){
		return (h+i*d)%entries.length;
	}
		
	private void rehash_linear(){
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k=0; k<oldEntries.length; k++){
			Entry entry = oldEntries[k];
			if(entry == null || entry == NIL) continue;
			int h = hash(entry.key);
			for(int i=0; i<entries.length;i++){
				int j= nextProbe(h,i);
				if(entries[j]==null){
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
	
	private void rehash_quadratic(){
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k=0; k<oldEntries.length; k++){
			Entry entry = oldEntries[k];
			if(entry == null || entry == NIL) continue;
			int h = hash(entry.key);
			for(int i=0; i<entries.length;i++){
				int j= (h+i*i)%entries.length;
				if(entries[j]==null){
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
	
	private void rehash_double(){
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k=0; k<oldEntries.length; k++){
			Entry entry = oldEntries[k];
			if(entry == null || entry == NIL) continue;
			int h = hash(entry.key), d = hash2(entry.key);
			for(int i=0; i<entries.length;i++){
				int j= nextProbe2(h,d,i);
				if(entries[j]==null){
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
	
	public void printCollision(){
		System.out.println(collision+" Collision");
	}
}
