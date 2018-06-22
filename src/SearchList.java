import java.util.Iterator;

public class SearchList <T extends Comparable> implements SList {

    Node root;




    @Override
    public void add(Comparable comparable) {

        Node element= new Node(comparable);
        boolean match=false;
    if(root==null){
        root=element;
    }
    else{
        Node i=root;
        if(comparable.compareTo(root.obj)<0){

            element.next=i;
            i.prev=element;
            root=element;
            match=true;
        }
        while(i.next!=null && match==false) {
            if(comparable.compareTo(i.obj)==0){
                i.vorkommen++;
                match=true;
            }
            else if(comparable.compareTo(i.obj)<1){

                        element.next=i;
                        element.prev=i.prev;
                        element.prev.next=element;
                        i.prev=element;
                        match=true;
            }
            i=i.next;
                }
        if(comparable.compareTo(i.obj)==0 && match==false){
            i.vorkommen++;
            match=true;
        }
             if(comparable.compareTo(i.obj)>0 && match==false) {
                 element.prev = i;
                 i.next = element;
             }
             if(comparable.compareTo(i.obj)<0 && match==false){
                 element.next=i;
                element.prev=i.prev;
                i.prev=element;
                element.prev.next=element;
             }
            }
    }



    @Override
    public int count(Comparable comparable) {

        Node i=root;
        while(comparable.compareTo(i.obj)!=0 && i.next!=null ){
            i=i.next;
        }
        if(i==null){
            return 0;
        }

        return i.vorkommen;
    }

    @Override
    public boolean remove(Comparable comparable) {
        if(root!=null){
        Node i=root;
        while(comparable.compareTo(i.obj)!=0){
            i=i.next;
        }
        if(i==null){
            return false;
        }
        else if(i.next!= null && i.prev!=null){
            i.next.prev=i.prev;
            i.prev.next=i.next;
            return true;
        }
        else if(i.prev==null && i.next!=null){
            root=i.next;
            i.next.prev=null;

            return true;
        }
        else if(i.next==null && i.prev!=null){
            i.prev.next=null;
            return true;
        }
        else{
           i.prev.next=null;
            return true;
        }
        }
        else{
        return false;}

    }

    @Override
    public int noOccurences() {
        int count=0;
        if(root!=null) {
            Node i = root;
            while(i!=null){
                count=count+i.vorkommen;
               i=i.next;
            }
        }
        return count;
    }

    @Override
    public int noWords() {
        int anzahl=0;
        if(root!=null){
        Node i=root;
        while (i!=null){
           anzahl++;
           i=i.next;}
        }

        return anzahl;
    }

    @Override
    public Iterator iterator() {

        Iterator it= new Iterator() {
            Node i=root;
            @Override
            public boolean hasNext() {

                return i!=null;
            }

            @Override
            public Object next() {
                if (i == root) {
                    i=i.next;
                    return root.obj;
                } else {
                    if (hasNext()) {
                       Comparable element= i.obj;
                        i=i.next;
                        return element;
                    } else {
                        return null;
                    }
                }
            }


        };

        return it;
    }

  public void ausgabe(){
        if(root!=null){
        Node i=root;
        while (i!=null){
            System.out.println(i.obj);
            i=i.next;
        }
        }

    }
}
