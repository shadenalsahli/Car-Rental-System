package project1;
import java.io.*;


 interface Payable {
     
  public abstract String printBill(int days); 
  
} //end Payable
 
 
 class Customer implements Serializable{
	 
    private int id;
    private String name;
    private long phone;

    public Customer(int id, String name, long phone) {
    	
        this.id = id;
        this.name = name;
        this.phone = phone; }
  
    //--------------------
    
    public String toString() {
    return String.format("%nCustormer Info:- "+"%nId: %d%n"+"Name: %s%n"+"Phone: %d%n",id,name,phone); }
    
    //--------------------

    public int getId() {
    	return id; }
    
    //--------------------

    public String getName() {
    	return name; }
    
    //--------------------

    public long getPhone() {
    	return phone; }

} //end Customer 
 
 
 abstract class Car implements Payable ,Serializable {
	 
	 protected String plateNo;
	 protected double pricePerDay;
	 protected String model;
	 protected String color;
	 protected boolean available;
	 private Customer cr;
            
    public Car(String plate, double price, String model, String color) {
    	
        plateNo = plate;
        pricePerDay = price;
        this.model = model;
        this.color = color;
        available=true;
        cr=null; }
    
    //--------------------

    public void setCr(Customer c) {
 	    cr = c; }

    //--------------------
    
    public String toString() {    
        return "Car Info:- "+"\nPlate No. : "+plateNo+"\nPrice Per Day: "+pricePerDay+"\nModel: "+model+"\nColor: "+color+"\nAvailable: "+available; }

    //--------------------
   
    public String getPlateNo() {
        return plateNo; }
    
    //--------------------
    
    public double getPricePerDay() {
        return pricePerDay; }
    
    //--------------------

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay; }
    
    //--------------------
  
    public String getModel() {
        return model; }
    
    //--------------------

    public String getColor() {
        return color; }
    
    //--------------------

    public boolean isAvailable() {
        return available; }
    
    //--------------------

    public Customer getCr() {
        return cr; }
    
    //--------------------

    public void setAvailable(boolean available) {
        this.available = available; }

 } //end Car

 
class Driver implements Serializable{

	private int id;
    private String name;
    
    public Driver(int id,String name){
    	
        this.id=id;
        this.name=name; }
    
    //--------------------

    public String toString() {
        return String.format("%nDriver Info:- "+ "\nId: %d%n"+"Name: %s",id,name); }
 
 
} //end Driver


class VIP extends Car { 
      
    
      private Driver d;
      public VIP(String plate, double price, String model, String color, Driver d ) {
          
           super(plate, price, model, color);
           this.d =d; }
      
      //--------------------

      public String printBill( int days ){
    
    	  double price = pricePerDay * days;	
    	  price += (100 * days);
    	
          return toString()+getCr()+"Days: "+days+"\nTotal price: "+price+" SR"; }//end printBill
      
      //--------------------

      public Driver getD() {
         return d; }
      
      //--------------------

      public String toString() {
    	return super.toString()+d.toString(); }
  
} //end VIP

class Economy extends Car {
  
     public Economy( String plate, double price, String model, String color ) {
       
          super(plate, price, model, color); }
     
     //--------------------

     public String printBill( int days ){
    	 
         double price = pricePerDay * days;
    	 
    	 if(days>7)
    	 price -= (price * 0.20);
    	             
         return toString()+getCr()+"Days: "+days+"\nTotal price: "+price+" SR"; }//end printBill
   
  } //end Economy
  
        
class CarRental {
  
     private int numOfCars;
     private Car[] carlist;
     
     public CarRental(int size) {
    	 
        carlist = new Car[size];
        numOfCars=0; }
     
     //--------------------

     public boolean addCar(Car c) {
    	 
          if(numOfCars>=carlist.length) 
          return false;   
          
          for(int i = 0;i<numOfCars;i++) {
        	 if(carlist[i].getPlateNo().equalsIgnoreCase(c.getPlateNo()))
        	    return false; }
   
          carlist[numOfCars++]=c;
          return true; }//end addCar

     //----------------------
       
 	 public void saveToFile() throws FileNotFoundException, IOException{
 		
 		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("cars.dat"));	
 		oos.writeInt(numOfCars);
 		oos.writeObject(carlist);
 	
 		oos.close(); }//end saveToFile
 	
    //----------------------
 	
     public void loadFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
    
    	 ObjectInputStream  ois=new ObjectInputStream(new FileInputStream("cars.dat"));
         numOfCars = ois.readInt();
    	 carlist=(Car[])ois.readObject();
   
    	 ois.close(); }//end loadFromFile
    
     //----------------------
     
     public String rentCar( String plateNo, Customer c, int numOfDay ) {
    	
      for( int i = 0 ; i < numOfCars ; i++ )  {
          
       if(carlist[i].isAvailable()&&carlist[i].getPlateNo().equalsIgnoreCase(plateNo)) {
	          
	      carlist[i].setAvailable(false);
	      carlist[i].setCr(c); 
	   
	      PrintWriter writer = null;
	      
		  try {
			writer = new PrintWriter(new FileOutputStream(new File(c.getName()+"_"+c.getId()+".txt"))); } 
		  catch (FileNotFoundException e) {}
	       writer.println(carlist[i].printBill(numOfDay));
	       writer.close();
      
      return carlist[i].printBill(numOfDay); } }
      
      return null; }//end rentCar
     
     //----------------------
     
     public boolean returnCar( String plateNo ) {
    	 
      int count=0;
     
      for( int i = 0 ; i < numOfCars ; i++ )  {
	      if(!(carlist[i].isAvailable())&&carlist[i].getPlateNo().equalsIgnoreCase(plateNo)) {
	       carlist[i].setAvailable(true);
	       carlist[i].setCr(null); 
	       return true;  } }
      
      return false; }//end returnCar
     
     //----------------------
     
     public VIP[] searchAvailableVIP() {
    	 
       int size=0;
       
       for(int i=0;i<numOfCars;i++) {
          if(carlist[i] instanceof VIP)
            if(carlist[i]. isAvailable()) 
              size++; }
       
       if( size == 0)
          return null;
     
       VIP[] availableVC = new VIP[size];
       
       for( int i = 0, j = 0  ; i < numOfCars ; i++ ) {
          if( carlist[i] instanceof VIP )
            if( carlist[i]. isAvailable() ) 
              availableVC[j++]=(VIP)carlist[i]; }
       
         return availableVC; }//end searchAvailableVIP
 
     //----------------------
     
     public Economy[] searchAvailableEconomy() {
	 
       int size=0;
       for( int i = 0 ; i < numOfCars ; i++ )
          if( carlist[i] instanceof Economy )
            if( carlist[i]. isAvailable() ) 
              size++;
       
       if( size == 0)
          return null;
          
       Economy[] availableEC = new Economy[size];
       
       for( int i = 0, j = 0  ; i < numOfCars ; i++ ) {
          if( carlist[i] instanceof Economy )
            if( carlist[i]. isAvailable() ) 
              availableEC[j++] = (Economy)carlist[i]; }
       
       return availableEC; }//end searchAvailableEconomy
 
     //----------------------
       
     public Car getCar( String PN ) {
       
          for( int i = 0 ; i < numOfCars ; i++ ) {
            if( carlist[i].getPlateNo().equalsIgnoreCase(PN))
              return carlist[i]; }
          
          return null; }//end getCar
       
     
  } //end CarRental

