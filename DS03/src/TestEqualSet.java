
public class TestEqualSet {

	public static boolean equalSet(ArraySet obj1, ArraySet obj2){
		if(obj2.contains(obj1.getFirst())==true){
			for(int i=1; i<obj1.size(); i++)
				if(obj2.contains(obj1.getNext())==false) return false; 
			if(obj1.contains(obj2.getFirst())==true){
				for(int j=1; j<obj2.size(); j++)
					if(obj1.contains(obj2.getNext())==false) return false;
				return true;
			}
			
		}
		return false;
	}

}
