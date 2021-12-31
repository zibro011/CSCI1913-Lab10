class AssociationList<Key, Value>
{
private Node first;

private class Node{
private Key key;
private Value value;
private Node next;
public Node(Key key,Value value,Node next){
this.key=key;
this.value=value;
this.next=next;
}
public Key getKey(){
return key;
}
public Value getValue(){
return value;
}
public Node getNext(){
return next;
}
public void setValue(Value value){
this.value=value;
}
public void setNext(Node next){
this.next=next;
}

}

public AssociationList(){//inititialize an empty list
first=null;
}

public void delete (Key key)
{
  Node leftKey = first;
  Node rightKey = leftKey.next;
  while (rightKey != null)
  {
    if (isEqual(rightKey.key, key)) //delete node
    {
      leftKey.next = rightKey.next;
      break;
    }
    leftKey = rightKey;
    rightKey = rightKey.next;
  }
}

public Value get(Key key) throws IllegalArgumentException{
Node temp=first;
while(temp!=null){//iterate through
if(isEqual(temp.getKey(),key))//if it matches return the value
return temp.getValue();
temp=temp.getNext();
}
throw new IllegalArgumentException();
}

private boolean isEqual(Key leftKey, Key rightKey){
if(leftKey==null&&rightKey==null)
return true;
else if(leftKey==null||rightKey==null)
return false;
else
return (leftKey.equals(rightKey));
}

public boolean isIn(Key key){
Node temp=first;
while(temp!=null){
if(isEqual(temp.getKey(),key)) //find the key
return true;
temp=temp.getNext();
}
//loop completion means theres no key
return false;
}

public void put(Key key, Value value){
Node temp=first;
Boolean keyFound=false;
while(temp!=null){
if(isEqual(temp.getKey(),key))
{
temp.setValue(value); //if found set keyFound to true
keyFound=true;
break;

}
temp=temp.getNext();
}

if(!keyFound){//if key not found create a new node
Node newNode=new Node(key,value,first);
first=newNode;//make new node first
}

}
}
//
//  Tests for CSci 1913 Lab 10
//  James Moen
//  08 Apr 19
//
//  The TRY-CATCH statements catch exceptions thrown by ASSOCIATION LIST's
//  methods, so that the program can continue to run even if a method fails.
//
//  Each test has a comment that shows what it should print and how many points
//  it is worth, for a total of 40 points.

//  HOGWARTS. The Hogwarts dating service.

class Hogwarts
{

//  MAIN. Make an instance of ASSOCIATION LIST and test it.

  public static void main(String[] args)
  {
    AssociationList<String,String> list = new AssociationList<String,String>();

    System.out.println(list.isIn(null));         //  false         2 points.

    try
    {
      System.out.println(list.get(null));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No null");             //  No null       2 points.
    }

    list.put(null,        "Wormtail");
    list.put("Ron",       "Lavender");
    list.put("Voldemort", null);
    list.put("Dean",      "Ginny");

    System.out.println(list.isIn("Dean"));       //  true          2 points.
    System.out.println(list.isIn("Ginny"));      //  false         2 points.
    System.out.println(list.isIn("Ron"));        //  true          2 points.
    System.out.println(list.isIn("Voldemort"));  //  true          2 points.
    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.isIn("Joanne"));     //  false         2 points.

    System.out.println(list.get("Ron"));         //  Lavender      2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Voldemort"));   //  null          2 points.
    System.out.println(list.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(list.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");           //  No Joanne     2 points.
    }

    list.delete(null);

    System.out.println(list.isIn(null));         //  false         2 points.

    list.put(null,    null);
    list.put("Harry", "Ginny");
    list.put("Ron",   "Hermione");

    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.get(null));          //  null          2 points.
    System.out.println(list.get("Harry"));       //  Ginny         2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Ron"));         //  Hermione      2 points.

    list.delete("Dean");

    try
    {
      System.out.println(list.get("Dean"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Dean");             //  No Dean       2 points.
    }
  }
}
