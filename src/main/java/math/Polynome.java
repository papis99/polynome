package math;

public class Polynome {
private	int degre;
private int[] elements;
public Polynome( int[] tab) {
	
	this.degre = tab.length-1;
	elements=new int[tab.length];
	for(int i=0;i<=degre; i++)
		this.elements[i]=tab[i];
}
public Polynome(int degre)
{
	this.degre=degre;
	elements=new int[degre+1];
	for(int i=0;i<=degre; i++)
		this.elements[i]=0;
		
}
public void setElement(int i , int x) {
	if(i<this.elements.length)
		this.elements[i]=x;
}

public int getElement(int i) {
	
	int retour;
	if(i<this.elements.length)
		retour=this.elements[i];
	else
		retour=0;
	return retour;
}

public Polynome addition(Polynome p) {
	int degreMax= Math.max(p.degre,this.degre);
	Polynome fr =new Polynome(degreMax);
	for(int i=0;i<=degreMax; i++)
		 fr.setElement(i, this.getElement(i)+p.getElement(i));
	return fr;
	
}

public String toString() {
	String s=""+this.elements[0];
	for(int i=0;i<=degre; i++)
		if(this.elements[i]>0)
			s+="+"+this.elements[i]+"x^"+i;
		else
			if((this.elements[i]<0))
				s+=this.elements[i]+"x^"+i;
	return s;
	
}


public Polynome derive() {
	Polynome res = new Polynome(degre - 1);
	for(int i=0;i<=degre; i++)
		res.elements[i]=(i+1)*this.elements[i+1];
	
	return res;
}
 public int calcul(int x) {
	 int Retour = 0;
	 for(int i=0;i<=degre; i++)
		 Retour+=this.elements[i]*Math.pow(x, i);
	return Retour;
	 
	 
	 
	
}

 public static void main (String []args) {
	 int[] t1 = {1,2,3,4};
	 int[] t2 = {1,7,7,7};
	 int[] t3 = {0,2,5,8};
	 Polynome p= new Polynome(t1);
	 Polynome p1= new Polynome(t2);
	 Polynome p2= new Polynome(t3);
	 System.out.println(p.toString());
	 System.out.println(p1.toString());
	 System.out.println(p2.toString());
	 
	Polynome somme= p.addition(p);
	 System.out.println("la somme du polynome"+somme.toString());
 }

	
}
