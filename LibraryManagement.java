import java.io.*;
import java.util.*;  
class Book {  
int id;  
String name,author,publisher;  
int quantity;  
 Book(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  
    this.name = name;  
    this.author = author;  
    this.publisher = publisher;  
    this.quantity = quantity;  
}  
}  

class Queue {  
int id;  
String bname;  
String ddate;  
 Queue(int id, String name,  String date) {  
    this.id = id;  
    this.bname = name;  
    this.ddate = date;  
}  
}  

class Member{  
  int rollno;  
  String name;  
  int age;  
  String dob;
  String addr;
  String city;
  Member(int rollno,String name,int age,String dob,String addr,String city){  
   this.rollno=rollno;  
   this.name=name;  
   this.age=age;  
   this.dob=dob;
   this.addr=addr;
   this.city=city;
  }  
}  

class Lib1{  
   void add(HashMap<Integer,Member> al){  
   
  int id;  
  String name;  
  int age;  
  String dob;
  String addr;
  String city;
  Scanner s=new Scanner(System.in);
	System.out.println("enter id");
	id=s.nextInt();
	System.out.println("enter name");
	name=s.nextLine();
 s.nextLine();
	System.out.println("enter age");
	age=s.nextInt();
	System.out.println("enter date of birth");
	dob=s.nextLine();
 s.nextLine();
	System.out.println("enter door no");
	addr=s.nextLine();

	System.out.println("enter city");
	city=s.nextLine();
       if(al.containsKey(id))
       {
        System.out.println("Member with id "+id+" already exists");
        }
      else
     {
	Member b4=new Member(id,name,age,dob,addr,city); 
	al.put(id,b4);
     }
  
 }
 void addbooks(HashMap list) {  
    //Creating list of Books  
    
    //Creating Books  
	int id,quantity;
	String name,author,publisher;
   
	Scanner s=new Scanner(System.in);
	System.out.println("enter id");
	id=s.nextInt();
	System.out.println("enter name");
	name=s.nextLine();
         s.nextLine();
	System.out.println("enter author");
	author=s.nextLine();
	System.out.println("enter publisher");
	publisher=s.nextLine();
	System.out.println("enter quantity");
	quantity=s.nextInt();
        if(list.containsKey(id))
       {
        System.out.println("Book with id "+id+" already exists");
        }
      else
     {
	Book b4=new Book(id,name,author,publisher,quantity); 
	list.put(id,b4);
      }
   
}
void Issue(HashMap<Integer,Book> map,HashMap<Integer,Integer> barrows,HashMap<Integer,Queue> qlist)
	{
		HashMap<Integer,Book> hm=new HashMap<Integer,Book>(); 
        Book b;		
		System.out.println("enter book id");
		Scanner s=new Scanner(System.in);
		int id=s.nextInt();
		System.out.println("enter memeber id");
		int mid=s.nextInt();
		b=map.remove(id); 
		b.quantity=b.quantity-1;
		if(b.quantity<0)
		{
			System.out.println("No more books left to be issued");
                        System.out.println("enter book name");
                        String bname=s.nextLine();
                        s.nextLine();
						System.out.println("enter date");
                        String date=s.nextLine();
                Queue b4=new Queue(mid,bname,date); 
                qlist.put(mid,b4);
			
		}
		else
               { 

                  map.put(id,b);
                  barrows.put(mid,id);
               }
			
		
                
	} 
void returned(HashMap<Integer,Book> map,HashMap<Integer,Integer> barrows)
	{
		HashMap<Integer,Book> hm=new HashMap<Integer,Book>(); 
        Book b;		
		System.out.println("enter book id");
		Scanner s=new Scanner(System.in);
		int id=s.nextInt();
		b=map.remove(id); 
		b.quantity=b.quantity+1;
		System.out.println("enter memeber id");
		int mid=s.nextInt();
barrows.remove(mid);
			
		map.put(id,b);
	} 
	void bookenquiry(HashMap<Integer,Book> map)
	{
		HashMap<Integer,Book> hm=new HashMap<Integer,Book>(); 
        Book b;		
		System.out.println("enter book id");
		Scanner s=new Scanner(System.in);
		int id=s.nextInt();
		if(!map.containsKey(id))
		{
			System.out.println("the book with id "+id+" is not available in the library");
		}
		else{
			b=map.remove(id); 
		if(b.quantity>0)
			System.out.println(" "+b.quantity+"copies are available");
		else 
			System.out.println("no copy of books is available"); 
		
			
		}
		
		
			
		//map.put(id,b);
	} 
	

	 void remove(HashMap<Integer,Member> map)
	{
		HashMap<Integer,Member> hm=new HashMap<Integer,Member>(); 
        Member b;		
		System.out.println("enter member id");
		Scanner s=new Scanner(System.in);
		int id=s.nextInt();
		map.remove(id); 
		
	}

    void showbooks(HashMap<Integer,Book> map)
{

for(Map.Entry<Integer, Book> entry:map.entrySet()){    
        int key=entry.getKey();  
        Book b=entry.getValue();  
        System.out.println(key+" Details:");  
        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);   
    }    

}
  void showmembers(HashMap<Integer,Member> map)
{

for(Map.Entry<Integer, Member> entry:map.entrySet()){    
        int key=entry.getKey();  
        Member b=entry.getValue();  
        System.out.println(key+" Details:");  
        System.out.println(b.rollno+" "+b.name+" "+b.age+" "+b.dob+" "+b.addr+" "+b.city);   
    }    

}


void objectabook(HashMap<Integer,Book> map,HashMap<Integer,Integer> obook)
{
	System.out.println("enter book id");
		Scanner s=new Scanner(System.in);
		int id=s.nextInt();
		if(!map.containsKey(id))
		{
			System.out.println("the book with id "+id+"is not available in the library");
		}
		else{
             obook.put(id,0);
		
			
		}
}

void   showobbooks(HashMap<Integer,Integer> obook)
{
	System.out.println("The books with following id's are objected");
	
System.out.println(obook);		
	
}
void   borrow(HashMap<Integer,Integer> barrows)
{
	System.out.println("The  following  are borrowed books");
	
System.out.println(barrows);		
	
}
void  print(HashMap<Integer,Queue> a)
{
for(Map.Entry<Integer, Queue> entry:a.entrySet()){    
        int key=entry.getKey();  
        Queue b=entry.getValue();  
        System.out.println(key+" Details:");  
        System.out.println(b.id+" "+b.bname+" "+b.ddate+" "+b.bname);   
    }    
//System.out.println(a);
}
   
}  

public class LibraryManagement{  
 public static void main(String args[]){  
  //Creating user-defined class objects 
  Lib1 obj=new Lib1();
  Scanner s=new Scanner(System.in);
   HashMap<Integer,Book> hm=new HashMap<Integer,Book>();  
   HashMap<Integer,Member> al=new HashMap<Integer,Member>();  
    HashMap<Integer,Integer> obook=new HashMap<Integer,Integer>(); 
    HashMap<Integer,Integer> barrows=new HashMap<Integer,Integer>();
    HashMap<Integer,Queue>  qlist=new     HashMap<Integer,Queue>();
  int t;
  System.out.println("enter \n 1 to add books \n 2 to add members \n 3 issue a book  \n 4 remove a member \n 5 to show books \n 6 to show members \n 7 ifreturned \n 8 for bookenquiry\n 9 to object a book \n 10 to show objected books \n  11 for barrows \n 12 for quelist\n -1 to quit");
  t=s.nextInt();
  while(t!=-1)
  {
	  if(t==1)
	  {
		 
		  obj.addbooks(hm);
	  }
	  if(t==2)
	  {
		  
		  obj.add(al);
	  }
	  if(t==3)
	  {
		 
		  obj.Issue(hm,barrows,qlist);
	  }
	  if(t==4)
	  {
		
		  obj.remove(al);
	  }
	  if(t==5)
	  {
		  obj.showbooks(hm);
	  }
	  if(t==6)
	  {
		  obj.showmembers(al);
	  }
	  if(t==7)
	  {
		  obj.returned(hm,barrows);
	  }
      if(t==8)
      {
          obj.bookenquiry(hm);
      } 
      if(t==9)	
	  {
		  obj.objectabook(hm,obook);
	  }	
      if(t==10)
	  {
		  obj.showobbooks(obook);
	  }
       if(t==11)
         {
           obj.borrow(barrows);
          }
if(t==12)
{
obj.print(qlist);
}		  
       
System.out.println("enter \n 1 to add books \n 2 to add members \n 3 issue a book  \n 4 remove a member \n 5 to show books \n 6 to show members \n 7 if returned \n8 for bookenquiry\n 9 to object a book \n 10 to show objected books \n  11 for barrows \n 12 for quelist -1 to quit ");
	  
t=s.nextInt();
  }
  System.out.println("you are exited fron the program");
  
 }
} 




  
