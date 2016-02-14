import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * * @see http://www.javamadesoeasy.com/2015/02/hashmap-custom-implementation.html
 */
class HashMap<K, V> {
     
     Entry<K,V>[] table;   //Array of Entry.
     private int capacity_;  //Initial capacity_ of HashMap
   
    @SuppressWarnings("unchecked")
    public HashMap(int capacity){
    	capacity_ = capacity;
       table = new Entry[capacity_];
    }
       
    public void put(K newKey, V data){
       if(newKey==null)
           return;    //does not allow to store null.
      
       //calculate hash of key.
       int hash=hash(newKey);
       //create new entry.
       Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
      
       //if table location does not contain any entry, store entry there.
        if(table[hash] == null){
         table[hash] = newEntry;
        }else{
           Entry<K,V> previous = null;
           Entry<K,V> current = table[hash];
           
           while(current != null){ //we have reached last entry of bucket.
           if(current.key.equals(newKey)){           
               if(previous==null){  //node has to be insert on first of bucket.
                     newEntry.next=current.next;
                     table[hash]=newEntry;
                     return;
               }
               else{
                   newEntry.next=current.next;
                   previous.next=newEntry;
                   return;
               }
           }
           previous=current;
             current = current.next;
         }
         previous.next = newEntry;
        }
    }
 
    /**
     * Method returns value corresponding to key.
     * @param key
     */
    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
         return null;
        }else{
         Entry<K,V> temp = table[hash];
         while(temp!= null){
             if(temp.key.equals(key))
                 return temp.value;
             temp = temp.next; //return value corresponding to key.
         }         
         return null;   //returns null if key is not found.
        }
    } 
 
    /**
     * Method removes key-value pair from HashMap.
     * @param key
     */
    public boolean remove(K deleteKey){
       
       int hash=hash(deleteKey);
              
      if(table[hash] == null){
            return false;
      }else{
        Entry<K,V> previous = null;
        Entry<K,V> current = table[hash];
        
        while(current != null){ //we have reached last entry node of bucket.
           if(current.key.equals(deleteKey)){               
               if(previous==null){  //delete first entry node.
                     table[hash]=table[hash].next;
                     return true;
               }
               else{
                     previous.next=current.next;
                      return true;
               }
           }
           previous=current;
             current = current.next;
          }
        return false;
      }
    
    }
   
 
    /**
     * Method displays all key-value pairs present in HashMap.,
     * insertion order is not guaranteed, for maintaining insertion order
     * refer LinkedHashMap.
     * @param key
     */
    public void display(){
       
       for(int i=0;i<capacity_;i++){
           if(table[i]!=null){
                  Entry<K, V> entry=table[i];
                  while(entry!=null){
                        System.out.print("{"+entry.key+"="+entry.value+"}\n");
                        entry=entry.next;
                  }
           }
       }             
    
    }
    /**
     * Method implements hashing functionality, which helps in finding the appropriate
     * bucket location to store our data.
     * This is very important method, as performance of HashMap is very much
     * dependent on  this method's implementation.
     * @param key
     */
    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity_;
    }
    
    public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}	
	
	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}
		
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}
 
}
